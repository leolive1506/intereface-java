import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import exercicie.entities.Contract;
import exercicie.entities.Installment;
import exercicie.services.ContractService;
import exercicie.services.PaypalService;

public class Exercice {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    System.out.println("Entre os dados do contrato");
    System.out.print("Numero: ");
    int number = sc.nextInt();

    System.out.print("Data (dd/MM/yyyy): ");
    LocalDate localDate = LocalDate.parse(sc.next(), formatter);

    System.out.print("Valor do contrato: ");
    double totalValue = sc.nextDouble();

    System.out.print("Entre com o numero de parcelas: ");
    int months = sc.nextInt();
    
    Contract contract = new Contract(number, months, localDate, totalValue);
    ContractService service = new ContractService(new PaypalService());
    service.processContract(contract);
    
    System.out.println("Parcelas: ");
    for (Installment installment: contract.getInstallments()) {
      System.out.println(installment);
    }
  }
}
