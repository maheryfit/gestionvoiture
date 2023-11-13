package mg.gestion.gestionflottevehicule.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import mg.gestion.gestionflottevehicule.model.Vehicule;
import mg.gestion.gestionflottevehicule.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import static mg.gestion.gestionflottevehicule.handler.ResponseHandler.generateResponse;
import static mg.gestion.gestionflottevehicule.handler.ResponseHandler.sendResponseData;

@RestController
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping("/vehicules")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String getAll() throws JsonProcessingException {
        return sendResponseData(vehiculeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/vehicules/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String getOne(@PathVariable("id") Long id) throws JsonProcessingException {
        return sendResponseData(vehiculeService.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/vehicules")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String insert(@ModelAttribute("vehicule") Vehicule vehicule) throws JsonProcessingException {
        Vehicule v = vehiculeService.insert(vehicule);
        return sendResponseData(v, HttpStatus.OK);
    }

    @PutMapping("/vehicules/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String update(@PathVariable("id") Long id, @ModelAttribute("vehicule") Vehicule vehicule) throws JsonProcessingException {
        Vehicule v = vehiculeService.update(vehicule, id);
        return sendResponseData(v, HttpStatus.OK);
    }

    @DeleteMapping("/vehicules/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String delete(@PathVariable("id") Long id) throws JsonProcessingException {
        String response = vehiculeService.delete(id);
        return generateResponse(response, HttpStatus.OK, null);
    }
}
