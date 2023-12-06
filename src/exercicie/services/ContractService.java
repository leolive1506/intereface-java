package exercicie.services;

import java.time.LocalDate;

import exercicie.entities.Contract;
import exercicie.entities.Installment;

public class ContractService {
  private IOnlinePaymentService paymentService;
  
  public ContractService(IOnlinePaymentService paymentService) {
    this.paymentService = paymentService;
  }

  public void processContract(Contract contract) {
    int months = contract.getMonths();
    double basicQuota = contract.getTotalValue() / months;

    for (int currentMonth = 1; currentMonth <= months; currentMonth++) {
      LocalDate dueDate = contract.getDate().plusMonths(currentMonth);
      double interest = paymentService.interest(basicQuota, currentMonth);
      double fee = paymentService.paymentFee(basicQuota + interest);
      double quote = basicQuota + interest + fee;

      contract.addInstallment(new Installment(dueDate, quote));
    }
  }
}
