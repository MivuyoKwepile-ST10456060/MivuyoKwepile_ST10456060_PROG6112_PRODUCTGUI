public abstract class ProductSales implements IProductSales {
    private final int[][] salesData = {{300, 150, 700}, {250, 200, 600}};

    private final int SALES_LIMIT = 500;

    @Override
    public int[][] GetProductSales() {
        return salesData;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : salesData)
            for (int sale : year)
                total += sale;
        return total;
    }

    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = salesData.length * salesData[0].length;
        return (double) total / count;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : salesData)
            for (int sale : year)
                if (sale > SALES_LIMIT)
                    count++;
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : salesData)
            for (int sale : year)
                if (sale <= SALES_LIMIT)
                    count++;
        return count;
    }

    @Override
    public int GetProductsProcessed() {
        return salesData.length; // Number of years
    }
}

//AI was used to brainstorm this class