package org.example.labanalyse.repository;

import org.example.labanalyse.entites.TypeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTestRepository extends JpaRepository<TypeTest,Long> {
}
