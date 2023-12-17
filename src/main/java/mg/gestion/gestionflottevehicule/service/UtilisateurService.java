package mg.gestion.gestionflottevehicule.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import mg.gestion.gestionflottevehicule.details.UtilisateurDetails;
import mg.gestion.gestionflottevehicule.model.Role;
import mg.gestion.gestionflottevehicule.model.Utilisateur;
import mg.gestion.gestionflottevehicule.model.UtilisateurDTO;
import mg.gestion.gestionflottevehicule.repository.RoleRepository;
import mg.gestion.gestionflottevehicule.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UtilisateurService implements UserDetailsService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String nomUtilisateur) throws UsernameNotFoundException {
        Utilisateur user = utilisateurRepository.findByNomUtilisateur(nomUtilisateur);
        if (user == null) {
            throw new UsernameNotFoundException("User : " + nomUtilisateur + " not found");
        }
        return new UtilisateurDetails(user, mapRolesToAuthorities(user.getRoles()));
    }

    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

    public Utilisateur save(UtilisateurDTO userRegisteredDTO) {
        Role role = new Role();
        if(userRegisteredDTO.getRole().equals("USER"))
            role = roleRepository.findByRole("ROLE_USER");
        else if(userRegisteredDTO.getRole().equals("ADMIN"))
            role = roleRepository.findByRole("ROLE_ADMIN");
        Utilisateur user = new Utilisateur();
        user.setEmail(userRegisteredDTO.getEmail());
        user.setNomUtilisateur(userRegisteredDTO.getNomUtilisateur());
        user.setMotDePasse(bCryptPasswordEncoder.encode(userRegisteredDTO.getMotDePasse()));
        user.setRole(role);
        return utilisateurRepository.save(user);
    }


    public Utilisateur logIn(Utilisateur utilisateur) throws Exception {
        // Obtenez une instance de CriteriaBuilder
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        // Créez une requête Criteria
        CriteriaQuery<Utilisateur> cq = cb.createQuery(Utilisateur.class);

        // Définissez l'entité à partir de laquelle la requête est construite
        Root<Utilisateur> user = cq.from(Utilisateur.class);

        // Définissez la clause WHERE
        cq.where(cb.and(
                    cb.or(cb.equal(user.get("nomUtilisateur"), utilisateur.getEmail()), cb.equal(user.get("email"), utilisateur.getEmail()))
                ), cb.equal(user.get("motDePasse"), utilisateur.getMotDePasse()));

        // Exécutez la requête
        TypedQuery<Utilisateur> query = entityManager.createQuery(cq);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new Exception("Verify your email or your password");
        }
    }
}
