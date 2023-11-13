package mg.gestion.gestionflottevehicule.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kilometrage")
public class Kilometrage {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "kilometrage_id")
    private Long kilometrageId;

    @Column(name = "vehicule_id_kilometrage", nullable = false)
    private Long vehiculeIdKilometrage;

    @OneToOne
    @JoinColumn(name = "vehicule_id_kilometrage", referencedColumnName = "vehicule_id", insertable = false, updatable = false , nullable = false)
    private Vehicule vehicule;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date_kilometrage", columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
    private Date dateKilometrage = Date.valueOf(LocalDate.now());

    @Column(name = "debut_km", nullable = false)
    private Long debutKm;

    @Column(name = "fin_km", nullable = false)
    private Long finKm;
}
