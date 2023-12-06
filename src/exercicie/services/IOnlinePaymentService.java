package exercicie.services;

public interface IOnlinePaymentService {
  public Double paymentFee(Double amount);
  public Double interest(Double amount, Integer months);
}
