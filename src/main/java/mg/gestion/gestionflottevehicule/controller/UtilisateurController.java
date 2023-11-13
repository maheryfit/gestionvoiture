package mg.gestion.gestionflottevehicule.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import mg.gestion.gestionflottevehicule.config.JwtGeneratorValidator;
import mg.gestion.gestionflottevehicule.model.UtilisateurDTO;
import mg.gestion.gestionflottevehicule.model.Utilisateur;
import mg.gestion.gestionflottevehicule.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

import static mg.gestion.gestionflottevehicule.handler.ResponseHandler.*;

@RestController
public class UtilisateurController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtGeneratorValidator jwtGenVal;

    @Autowired
    BCryptPasswordEncoder bcCryptPasswordEncoder;

    @Autowired
    UtilisateurService utilisateurService;

    @PostMapping("/utilisateurs/login")
    public String generateJwtToken(@ModelAttribute("UtilisateurDTO") UtilisateurDTO utilisateurDto) throws JsonProcessingException {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(utilisateurDto.getNomUtilisateur(), utilisateurDto.getMotDePasse()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = utilisateurService.loadUserByUsername(utilisateurDto.getNomUtilisateur());
            Map<String, Object> map = new HashMap<>();
            map.put("Token", jwtGenVal.generateToken(userDetails));
            map.put("Status", HttpStatus.OK);
            return getString(map);
        } catch (Exception e) {
            return generateErrorResponse("Username or password are invalidate", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/utilisateurs/registration")
    public String registerUser(@ModelAttribute("UtilisateurDTO") UtilisateurDTO utilisateurDto) throws JsonProcessingException {
        Utilisateur users = utilisateurService.save(utilisateurDto);
        if (users == null)
            return generateResponse("Not able to save user ", HttpStatus.BAD_REQUEST, utilisateurDto);
        else
            return generateResponse("User saved successfully : " + users.getUtilisateurId(), HttpStatus.OK, users);
    }

    @PostMapping("/api/logout")
    public String log_out() throws JsonProcessingException {
        SecurityContextHolder.getContext().setAuthentication(null);
        return generateResponse("Logout successfully", HttpStatus.OK, "");
    }

    @RequestMapping("/api/test")
    public String test() {
        return "";
    }
}
