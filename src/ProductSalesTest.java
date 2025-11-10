import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        ProductSales ps = new ProductSales() {
            @Override
            public int[][] GetProductSale() {
                return new int[0][];
            }
        };
        assertEquals(2, ps.GetSalesOverLimit(), "Sales over limit should be 2");
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        ProductSales ps = new ProductSales() {
            @Override
            public int[][] GetProductSale() {
                return new int[0][];
            }
        };
        assertEquals(4, ps.GetSalesUnderLimit(), "Sales under limit should be 4");
    }
}
