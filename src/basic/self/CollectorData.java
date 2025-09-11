package basic.self;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorData {
    public static void main(String[] args) {
        // 재고 총합 계산
        List<Product> products = List.of(
                new Product("Apple", 150),
                new Product("Banana", 200),
                new Product("Orange", 120)
        );

        Integer totalStock = products.stream()
                .collect(Collectors.summingInt(Product::getStock));

        // 470
        System.out.println("totalStock = " + totalStock);

        IntSummaryStatistics stats = products.stream()
                .collect(Collectors.summarizingInt(Product::getStock));
        // IntSummaryStatistics{count=3, sum=470, min=120, average=156.666667, max=200}
        System.out.println("통계 정보: " + stats);


        System.out.println();

        int totalStock2 = products.stream()
                .mapToInt(Product::getStock).sum();
        // 470
        System.out.println("totalStock2 = " + totalStock2);


        Map<Product, Integer> productToStockMap = products.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(Product::getStock)));

        Map<String, Integer> nameToStockMap = products.stream()
                .collect(Collectors.groupingBy(Product::getName, Collectors.summingInt(Product::getStock)));
    }

    static class Product {
        private String name;
        private int stock;

        public Product(String name, int stock) {
            this.name = name;
            this.stock = stock;
        }

        public String getName() {
            return name;
        }

        public int getStock() {
            return stock;
        }
    }
}
