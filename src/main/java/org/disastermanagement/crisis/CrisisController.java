package org.disastermanagement.crisis;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
@RequestMapping("/crisis")
public class CrisisController {
  private final CrisisService crisisService;

  CrisisController(CrisisService crisisService) {
    this.crisisService = crisisService;
  }

  @GetMapping("/get-all")
  public List<Crisis> getListOfCrisis() {
    return crisisService.getListOfCrisis();
  }

  @PostMapping("/add")
  public Crisis addNewCrisis(@RequestBody Crisis crisis) {
    return crisisService.create(crisis);
  }

  @PutMapping("/update")
  public Optional<Crisis> updateCrisis(@RequestBody Crisis crisis) {
    return crisisService.updateCrisis(crisis);
  }


}
