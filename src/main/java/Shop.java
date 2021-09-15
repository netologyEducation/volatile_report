import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Shop {

    private String shopName;

    private List<Double> soldGoods = new ArrayList<>();

    public Shop(String shopName) {
        this.shopName = shopName;
        this.generateSoldGoods();
    }

    public String getShopName() {
        return shopName;
    }

    private void generateSoldGoods() {
        for (int i = 0; i < 10; i++) {
            soldGoods.add(Math.floor(new Random().nextDouble() * 1000));
        }
    }

    public Double totalAmount() {
        double total = soldGoods.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.printf("Магазин '%s' заработал - %s$\n", this.getShopName(), total);
        return total;
    }
}
