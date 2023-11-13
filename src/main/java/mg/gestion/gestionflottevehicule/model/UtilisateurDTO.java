package mg.gestion.gestionflottevehicule.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDTO {

	private String nomUtilisateur;
	private String motDePasse;
	private String email;
	private String role;

}
