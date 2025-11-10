public interface IProductSales {
    int[][] GetProductSale();

    int[][] GetProductSales();

    int GetTotalSales();
    int GetSalesOverLimit();
    int GetSalesUnderLimit();
    int GetProductsProcessed();
    double GetAverageSales();
}
