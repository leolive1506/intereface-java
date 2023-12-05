package seminterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import seminterface.model.entities.CarRental;
import seminterface.model.entities.Vehicle;
import seminterface.model.services.BrazilTaxService;
import seminterface.model.services.RentalService;

public class Index {
  public static void main() {
    Scanner sc = new Scanner(System.in);

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    System.out.println("Entre com os dados do aluguel");
    System.out.print("Modelo do carro: ");
    String carModel = sc.nextLine();
    System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
    LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);

    System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
    LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

    CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
    
    System.out.print("Entre com o preço por hora: ");
    double pricePerHour = sc.nextDouble();
    System.out.print("Entre com o preço por dia: ");
    double pricePerDay = sc.nextDouble();

    RentalService rentalSerive = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
    rentalSerive.processInvoice(cr);

  
    System.out.println("FATURA:");
    System.out.println("Pagamento básico: " + String.format(".2f", cr.getInvoice().getBasicPayment()));
    System.out.println("Imposto: "+ String.format("%.2f", cr.getInvoice().getTax()));
    System.out.println("Pagamento total: "+ String.format("%.2f", cr.getInvoice().getTotalPayment()));

    sc.close();
  }
}
