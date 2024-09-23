package org.disastermanagement.cost;

import org.springframework.stereotype.Component;

@Component
public class Donation {
  int allTimeDonation;

  public int getAllTimeDonation() {
    return allTimeDonation;
  }

  public void setAllTimeDonation(int allTimeDonation) {
    this.allTimeDonation = allTimeDonation;
  }
}
