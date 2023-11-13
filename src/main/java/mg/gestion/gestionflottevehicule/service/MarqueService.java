package mg.gestion.gestionflottevehicule.service;

import mg.gestion.gestionflottevehicule.model.Marque;
import mg.gestion.gestionflottevehicule.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {
    @Autowired
    private MarqueRepository marqueRepository;

    public List<Marque> getAll() {
        return marqueRepository.findAll();
    }
}
