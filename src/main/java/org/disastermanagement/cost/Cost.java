package org.disastermanagement.cost;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cost {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int donation;
  private int expenses;

  @CreationTimestamp
  private LocalDateTime createdAt;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDonation() {
    return donation;
  }

  public void setDonation(int donation) {
    this.donation = donation;
  }

  public int getExpenses() {
    return expenses;
  }

  public void setExpenses(int expenses) {
    this.expenses = expenses;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
