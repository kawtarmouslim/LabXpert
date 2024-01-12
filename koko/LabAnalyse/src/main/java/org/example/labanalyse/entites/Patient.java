package org.example.labanalyse.entites;

import lombok.Data;
import org.hibernate.mapping.FetchProfile;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private Date datenaissnce;
    private String adresse;
    private  String tel;
    @OneToMany (mappedBy="patient" ,fetch = FetchType.LAZY)
    private List<Echantillon> listechantillon;



}
