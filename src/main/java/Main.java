import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.DoubleAdder;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Shop> shopList = new ArrayList<>();

        DoubleAdder total = new DoubleAdder();

        for (int i = 1; i <= 1000; i++) {
            shopList.add(new Shop("Shop - #" + i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (Shop shop : shopList) {
            executor.submit(() ->
                    total.add(shop.totalAmount()));
        }

        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);
        System.out.printf("\nИтоговый заработок за день - %s $\n", total.sum());
    }
}
