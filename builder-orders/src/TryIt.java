import com.example.orders.*;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);

        Order o = new Order.Builder("o2", "a@b.com")
                .addLine(l1)
                .addLine(l2)
                .withDiscountPercent(10)
                .build();

        System.out.println("Before: " + o.totalAfterDiscount());
        System.out.println("=> In the solution, totals remain stable due to defensive copies.");
    }
}
