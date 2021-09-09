import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public double totalPriceSoldGoods() {
        return soldGoods.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }
}
