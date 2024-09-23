package org.disastermanagement.crisis;

import java.util.List;
import java.util.Optional;

import org.disastermanagement.users.AppUser;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
class CrisisService {
  private final CrisisRepository crisisRepository;

  CrisisService(CrisisRepository crisisRepository) {
    this.crisisRepository = crisisRepository;
  }

  List<Crisis> getListOfCrisis() {
    return crisisRepository.findAll();
  }

  Crisis create(Crisis crisis) {
    return crisisRepository.save(crisis);
  }

  Optional<Crisis> updateCrisis(Crisis crisis) {
    return crisisRepository.findById(crisis.getId()).map(existingData -> {
      return updateData(existingData, crisis);
    });
  }

  private Crisis updateData(Crisis existingData, Crisis newData) {
    existingData.setStatus(newData.getStatus());

    return crisisRepository.save(existingData);
  }
}
