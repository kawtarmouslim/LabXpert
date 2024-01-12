package org.example.labanalyse.entites;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tayprtests")
public class TypeTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double min;
    private double max;
    @ManyToOne
    private Test test;

}
