// public class RechargeService {
//     private PaymentGateway gateway;

//     public RechargeService() {
//         this.gateway = new InternalPaymentGateway();
//     }

//     public void processRecharge(String username, double amount) {
//         gateway.pay(amount);
//         System.out.println("Nạp " + amount + " cho " + username);
//     }
// }

//Đoạn sai nằm ở dòng:
// this.gateway = new InternalPaymentGateway();
//Dòng new InternalPaymentGateway() làm mất tính linh hoạt vì class tự tạo dependency gây tight coupling nên vi phạm IoC