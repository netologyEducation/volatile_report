import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.*;
import java.util.concurrent.atomic.DoubleAdder;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Shop> shopList = new ArrayList<>();

        DoubleAdder total = new DoubleAdder();

        shopList.add(new Shop("number one"));
        shopList.add(new Shop("number two"));
        shopList.add(new Shop("number three"));

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Double>> futures = executor.invokeAll(shopList);

        for (Future<Double> future : futures) {
            total.add(future.get());
        }

        executor.shutdown();
        System.out.printf("Итоговый заработок за день - %s $", total);
//    }
    }
}
