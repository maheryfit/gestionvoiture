package mg.gestion.gestionflottevehicule.controller;

import mg.gestion.gestionflottevehicule.model.Societe;
import mg.gestion.gestionflottevehicule.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SocieteController {

    @Autowired
    private SocieteService societeService;

    @GetMapping("/societes")
    public List<Societe> getAll() {
        return societeService.getAll();
    }
}
