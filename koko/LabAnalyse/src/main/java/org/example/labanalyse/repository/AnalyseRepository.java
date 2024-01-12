package org.example.labanalyse.repository;

import org.example.labanalyse.entites.Analyse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyseRepository extends JpaRepository<Analyse,Long> {
}
