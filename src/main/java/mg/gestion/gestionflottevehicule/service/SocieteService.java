package mg.gestion.gestionflottevehicule.service;

import mg.gestion.gestionflottevehicule.model.Societe;
import mg.gestion.gestionflottevehicule.repository.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocieteService {
    @Autowired
    private SocieteRepository societeRepository;

    public List<Societe> getAll() {
        return societeRepository.findAll();
    }
}
