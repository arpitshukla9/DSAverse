package abstraction;

abstract class Notification {

    abstract void SendNotification(String message);

    public void SendGreet() {
        System.out.println("Hello SIR/MADAM...");
    }
}

class EmailNotification extends Notification {

    @Override
    void SendNotification(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSNotification extends Notification {

    @Override
    void SendNotification(String message) {
        System.out.println("SMS: " + message);
    }
}

public class NotificationSystem {

    public static void main(String[] args) {

        Notification noti = new EmailNotification();

        noti.SendGreet();

        noti.SendNotification("Welcome to DSAverse via Email");

        noti = new SMSNotification();
        noti.SendGreet();
        noti.SendNotification("Welcome to DSAverse via SMS");
    }
}
