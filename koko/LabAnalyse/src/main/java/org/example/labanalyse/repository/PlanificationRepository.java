package org.example.labanalyse.repository;

import org.example.labanalyse.entites.Planification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanificationRepository extends JpaRepository<Planification,Long> {
}
