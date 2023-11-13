package mg.gestion.gestionflottevehicule.repository;


import mg.gestion.gestionflottevehicule.model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
