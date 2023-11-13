package mg.gestion.gestionflottevehicule.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceUnit;
import mg.gestion.gestionflottevehicule.model.Vehicule;
import mg.gestion.gestionflottevehicule.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VehiculeService {
    @Autowired
    private VehiculeRepository vehiculeRepository;

    public List<Vehicule> getAll(){
        return vehiculeRepository.findAll();
    }

    public Vehicule getOne(Long id) {
        return vehiculeRepository.findById(id).get();
    }

    public Vehicule insert(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    public Vehicule update(Vehicule vehicule, Long id) {
        vehicule.setVehiculeId(id);
        vehiculeRepository.save(vehicule);
        return vehicule;
    }

    public String delete(Long id) {
        try {
            vehiculeRepository.deleteById(id);
            return "Le véhicule de ID " + id + " est supprimé";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
    }
}
