package mg.gestion.gestionflottevehicule.service;

import mg.gestion.gestionflottevehicule.model.Kilometrage;
import mg.gestion.gestionflottevehicule.repository.KilometrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class KilometrageService {
    @Autowired
    private KilometrageRepository kilometrageRepository;


    public List<Kilometrage> getAll () {
        return kilometrageRepository.findAll();
    }

    public Kilometrage getOne(Long id) {
        return kilometrageRepository.findById(id).get();
    }

    public Kilometrage insert(Kilometrage kilometrage) {
        return kilometrageRepository.save(kilometrage);
    }

    public Kilometrage update(Kilometrage kilometrage, Long id) {
        kilometrage.setKilometrageId(id);
        kilometrageRepository.save(kilometrage);
        return kilometrage;
    }

    public ResponseEntity<String> delete(Long id) {
        try {
            kilometrageRepository.deleteById(id);
            return new ResponseEntity<>("Le kilometrage de ID " + id + " est supprimé", HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
    }
}
