package mg.gestion.gestionflottevehicule.details;

import mg.gestion.gestionflottevehicule.model.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UtilisateurDetails implements UserDetails {
    Utilisateur utilisateur;
    Collection<? extends GrantedAuthority> authorities;

    public UtilisateurDetails(Utilisateur utilisateur, Collection<? extends GrantedAuthority> authorities) {
        this.utilisateur = utilisateur;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return utilisateur.getMotDePasse();
    }

    @Override
    public String getUsername() {
        return utilisateur.getNomUtilisateur();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
