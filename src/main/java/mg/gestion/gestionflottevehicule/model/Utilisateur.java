package mg.gestion.gestionflottevehicule.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @Column(name = "utilisateur_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long utilisateurId;

    @Column(name = "nom_utilisateur", precision = 20, nullable = false)
    private String nomUtilisateur;

    @Column(name = "email", unique = true, precision = 40, nullable = false)
    private String email;

    @Column(name = "mot_de_passe", precision = 30, nullable = false)
    private String motDePasse;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Utilisateurs_role", joinColumns = @JoinColumn(name = "utilisateur_id", referencedColumnName = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id") )
    Set<Role> roles = new HashSet<Role>();

    public void setRole(Role role) {
        this.roles.add(role);
    }
}
