package org.disastermanagement.cost;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
class CostService {
  private final CostRepository costRepository;

  CostService(CostRepository costRepository) {
    this.costRepository = costRepository;
  }

  List<Cost> getAllCost() {
    return costRepository.findAllCost();
  }

  Cost saveCost(Cost cost) {
    return costRepository.save(cost);
  }

  
}
