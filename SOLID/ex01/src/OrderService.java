public class OrderService implements OrderServiceInterface{
    EmailSender email;
    TaxCalculator tc;
    public OrderService(EmailSender em, TaxCalculator tc){
        this.email = em;
        this.tc = tc;
    }

    @Override
    public void checkout(String customerEmail, double subtotal) {
        double total = tc.calculateTotalwithTax(subtotal);
        email.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}