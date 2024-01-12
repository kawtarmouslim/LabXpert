package org.example.labanalyse.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "reactives")
public class Reactive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date dateexperation;
    private int quantitestock;
    private String fournisseur;
    @OneToMany (mappedBy="reactive" ,fetch = FetchType.LAZY)
   private List<Analyse> listanalyse;
}
