package org.example.labanalyse.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String motpasse;
    private  String informationpersonelle;
    @ManyToOne
    private Planification planification;
}
