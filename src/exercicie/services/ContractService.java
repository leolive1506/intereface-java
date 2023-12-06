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
    double installmentTax = 0;
    double installmentWithTax = 0;
    int months = contract.getMonths();
    double installmentValueWithoutTax = contract.getTotalValue() / months;

    int currentInstallment = 1;
    while (currentInstallment <= months) {
      installmentTax = installmentValueWithoutTax + paymentService.interest(installmentValueWithoutTax, currentInstallment);
      installmentWithTax = installmentTax + paymentService.paymentFee(installmentTax);
      
      contract.addInstallment(new Installment(contract.getDate().plusMonths(currentInstallment), installmentWithTax));
      
      currentInstallment++;
    }
  }
}
