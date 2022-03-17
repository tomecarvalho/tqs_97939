package stocks;

import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {
    private List<Stock> stocks;
    private IStockmarketService stockmarket;

    public StocksPortfolio(IStockmarketService stockmarket) {
        this.stockmarket = stockmarket;
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double getTotalValue() {
        return stocks.stream().mapToDouble(stock -> stock.getQuantity() * stockmarket.lookUpPrice(stock.getLabel())).sum();
//        double total = 0;
//        for (Stock stock : stocks)
//            total += stockmarket.lookUpPrice(stock.getLabel());
    }
}
