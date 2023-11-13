package mg.gestion.gestionflottevehicule.repository;

import mg.gestion.gestionflottevehicule.model.Kilometrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KilometrageRepository extends JpaRepository<Kilometrage, Long> {

    Optional<List<Kilometrage>> findAllByVehiculeIdKilometrage(Long vehiculeId);
}
