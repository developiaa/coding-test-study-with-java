package basic.self;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test3_review {
    public static void main(String[] args) {
        String[] words = {"i", "love", "java", "i", "love", "coding", "i", "java"};
        int k = 2;
        // 각 단어에 빈도수 계산

        // [i, java]
        // 1. 빈도 내림차순
        // 2. 단어 정렬

        System.out.println(getList(words).subList(0, k));

        System.out.println(twice(2));
        System.out.println(divide2(2));

        List<Product> products = Arrays.asList(
                new Product("Apple", 150),
                new Product("Banana", 200),
                new Product("Orange", 120)
        );

//        Integer totalStock = products.stream().collect(Collectors.summingInt(Product::getStock));
        Integer totalStock = products.stream().mapToInt(Product::getStock).sum();
        System.out.println("totalStock = " + totalStock);
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

    public static int twice(int n) {
        return n << 1;
    }

    public static int divide2(int n) {
        return n >> 1;
    }

    public static List<String> getList(String[] words) {
        Map<String, Integer> wordToCountMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(_ -> 1)));

        wordToCountMap.forEach((key, value) -> {
            System.out.printf("%s : %s", key, value);
            System.out.println();
        });
        System.out.println();

        return new ArrayList<>(wordToCountMap.keySet()).stream()
                .sorted((o1, o2) -> {
                    Integer first = wordToCountMap.get(o1);
                    Integer second = wordToCountMap.get(o2);
                    if (Objects.equals(first, second)) {
                        return o1.compareTo(o2);
                    }
                    return second - first;
                }).toList();
    }

}
