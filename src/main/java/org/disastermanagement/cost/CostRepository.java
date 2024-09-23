package org.disastermanagement.cost;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
interface CostRepository extends JpaRepository<Cost, Integer> {
  @Query("SELECT c FROM Cost c ORDER BY c.createdAt DESC")
  List<Cost> findAllCost();

}
