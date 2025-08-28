public class TaxCalculator {
    private final double taxRate;

    public TaxCalculator(double tax){
        this.taxRate = tax;
    }

    double calculateTotalwithTax(double subtotal){
        return subtotal + subtotal * this.taxRate;
    }
}
