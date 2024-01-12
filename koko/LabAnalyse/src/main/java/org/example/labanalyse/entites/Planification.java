package org.example.labanalyse.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "planifications")
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "planification")
    private Analyse analyse;
    @OneToMany(mappedBy="planification" ,fetch = FetchType.LAZY)
    private List<User> userList;
    private Date datedebut;
    private Date datefin;

}
