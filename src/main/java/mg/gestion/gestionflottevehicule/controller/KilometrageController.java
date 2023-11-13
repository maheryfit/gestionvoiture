package mg.gestion.gestionflottevehicule.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import mg.gestion.gestionflottevehicule.model.Kilometrage;
import mg.gestion.gestionflottevehicule.repository.KilometrageRepository;
import mg.gestion.gestionflottevehicule.service.KilometrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static mg.gestion.gestionflottevehicule.handler.ResponseHandler.generateErrorResponse;
import static mg.gestion.gestionflottevehicule.handler.ResponseHandler.sendResponseData;

@RestController
public class KilometrageController {

    @Autowired
    private KilometrageService kilometrageService;

    @Autowired
    private KilometrageRepository kilometrageRepository;

    @GetMapping("/kilometrages/vehicule/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String getKilometragesByVehicule(@PathVariable("id") Long vehiculeId) throws JsonProcessingException {
        Optional<List<Kilometrage>> kilometrages = kilometrageRepository.findAllByVehiculeIdKilometrage(vehiculeId);
        return sendResponseData(kilometrages.get(), HttpStatus.OK);
    }

    @GetMapping("/kilometrages")
    public List<Kilometrage> getAll() {
        return kilometrageService.getAll();
    }

    @GetMapping("/kilometrages/{id}")
    public Kilometrage getOne(@PathVariable("id") Long id) {
        return kilometrageService.getOne(id);
    }

    @PostMapping("/kilometrages")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Kilometrage insert(@ModelAttribute("kilometrage") Kilometrage kilometrage) {
        return kilometrageService.insert(kilometrage);
    }


    @PutMapping("/kilometrages/{id}")
    public Kilometrage update(@PathVariable("id") Long id, @ModelAttribute("kilometrage") Kilometrage kilometrage) {
        return kilometrageService.update(kilometrage, id);
    }

    @DeleteMapping("/kilometrages/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return kilometrageService.delete(id);
    }
}
