package mg.gestion.gestionflottevehicule.repository;

import mg.gestion.gestionflottevehicule.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);

}
