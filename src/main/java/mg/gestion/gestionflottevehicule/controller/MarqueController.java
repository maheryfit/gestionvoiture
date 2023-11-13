package mg.gestion.gestionflottevehicule.controller;

import mg.gestion.gestionflottevehicule.model.Marque;
import mg.gestion.gestionflottevehicule.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarqueController {

    @Autowired
    private MarqueService marqueService;

    @GetMapping("/marques")
    public List<Marque> getAll() {
        return marqueService.getAll();
    }
}
