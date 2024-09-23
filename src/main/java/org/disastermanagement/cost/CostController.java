package org.disastermanagement.cost;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
@RequestMapping("/cost")
public class CostController {
  private final CostService costService;
  private Donation donation;

  CostController(CostService costService, Donation donation) {
    this.costService = costService;
    this.donation = donation;
  }

  @GetMapping("/all")
  public List<Cost> getAllCost() {
    return costService.getAllCost();
  }

  @GetMapping("/all-time-donation")
  public int getAllTimeDonation() {
    return donation.getAllTimeDonation();
  }

  @PostMapping("/donate")
  public Cost donate(@RequestBody Cost cost) {

    Integer am = cost.getDonation();

    donation.setAllTimeDonation(donation.getAllTimeDonation()+am);
    return costService.saveCost(cost);
  }

}
