package mg.gestion.gestionflottevehicule.repository;

import mg.gestion.gestionflottevehicule.model.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, Long> {
}
