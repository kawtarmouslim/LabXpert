package org.example.labanalyse.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "echantillons")
public class Echantillon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Patient patient;
    private String typeanalyse;
    @OneToOne(mappedBy = "echantillon")
    private Analyse analyse;
    private Date dateprelevement;
    @Enumerated(EnumType.STRING)
    private StatusEchan status;




}
