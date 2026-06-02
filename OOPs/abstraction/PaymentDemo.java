package abstraction;

abstract class Payment {
    //abstract method
    abstract void pay(double amount);
    // common func..
    void paymentStatus() {
        System.out.println("Payment is processing...");
    }
}

class UpiPayment extends Payment {

    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CardPayment extends Payment {

    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using CARD");
    }
}

public class PaymentDemo {

    public static void main(String[] args) {

        Payment payment = new UpiPayment();

        payment.paymentStatus();
        payment.pay(5000);
    }
}