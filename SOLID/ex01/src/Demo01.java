

public class Demo01 {
    public static void main(String[] args) {
        EmailSender em = new EmailClient();
        TaxCalculator tc = new TaxCalculator(0.18);

        new OrderService(em, tc).checkout("a@shop.com", 100.0);
    }
}
