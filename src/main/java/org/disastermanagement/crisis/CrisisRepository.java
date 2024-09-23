package org.disastermanagement.crisis;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CrisisRepository extends JpaRepository<Crisis, Integer> {
  Optional<Crisis> findById(int id);
  
}
