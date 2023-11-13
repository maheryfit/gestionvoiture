package mg.gestion.gestionflottevehicule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="marque")
public class Marque {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "marque_id")
    private Long marqueId;

    @Column(name = "nom_marque", nullable = false, unique = true)
    private String nomMarque;
}
