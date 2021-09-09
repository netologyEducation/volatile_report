import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.*;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Shop> shopList = new ArrayList<>();

        DoubleAdder total = new DoubleAdder();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        shopList.add(new Shop("number one"));
        shopList.add(new Shop("number two"));
        shopList.add(new Shop("number three"));

        for (Shop shop : shopList) {
            double moneyPerDay = executor.submit(shop::totalPriceSoldGoods).get();
            System.out.printf("Магазин '%s' заработал за день - %s $\n", shop.getShopName(), moneyPerDay);
            total.add(moneyPerDay);
        }
        executor.shutdown();
        System.out.printf("Итоговый заработок за день - %s $", total);
    }
}
