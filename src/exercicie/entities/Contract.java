package exercicie.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
  private Integer number;
  private Integer months;
  private LocalDate date;
  private Double totalValue;

  private List<Installment> instalments;

  public Contract(Integer number, Integer months, LocalDate date, Double totalValue) {
    this.number = number;
    this.months = months;
    this.date = date;
    this.totalValue = totalValue;
    instalments = new ArrayList<>();
  }

  public Integer getNumber() {
    return number;
  }

  public Integer getMonths() {
    return months;
  }

  public void setMonths(Integer months) {
    this.months = months;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }

  public List<Installment> getInstallments() {
    return instalments;
  }

  public void addInstallment(Installment installment) {
    instalments.add(installment);
  }

  public void removeInstallment(Installment installment) {
    instalments.remove(installment);
  }
}
