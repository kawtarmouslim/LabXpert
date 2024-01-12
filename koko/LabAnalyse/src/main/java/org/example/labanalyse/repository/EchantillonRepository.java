package org.example.labanalyse.repository;

import org.example.labanalyse.entites.Echantillon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchantillonRepository extends JpaRepository<Echantillon,Long> {
}
