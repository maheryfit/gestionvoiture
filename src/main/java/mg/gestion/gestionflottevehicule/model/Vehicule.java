package mg.gestion.gestionflottevehicule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "vehicule_id")
    private Long vehiculeId;

    @Column(name = "immatriculation", unique = true)
    private String immatriculation;

    @Column(name = "societe_id_vehicule")
    private Long societeIdVehicule;

    @Column(name = "marque_id_vehicule")
    private Long marqueIdVehicule;

    @OneToOne
    @JoinColumn(name = "marque_id_vehicule", referencedColumnName = "marque_id", insertable = false, updatable = false)
    private Marque marque;

    @OneToOne
    @JoinColumn(name = "societe_id_vehicule", referencedColumnName = "societe_id",insertable = false, updatable = false)
    private Societe societe;
}
