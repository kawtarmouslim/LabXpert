package org.example.labanalyse.repository;

import org.example.labanalyse.entites.Reactive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactiveRepository extends JpaRepository<Reactive,Long> {
}
