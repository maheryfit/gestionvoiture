package mg.gestion.gestionflottevehicule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="societe")
public class Societe {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "societe_id")
    private Long societeId;

    @Column(name = "nom_societe", nullable = false, unique = true)
    private String nomSociete;
}
