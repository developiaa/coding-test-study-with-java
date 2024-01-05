package programmers.test.n2501;

import java.util.*;

public class Solution2 {
    // ([('boston', 7, 5, 10), ('hawaii', 8, 9, 12), ('newyorker', 8, 9, 130), ('philadelphia', 5, 10, 13)], [('boston', 'Small', 3), ('hawaii', 'Large', 3), ('newyorker', 'Large', 1), ('boston', 'Large', 2), ('philadelphia', 'Large', 2)])
    // 102가 나와야되는데 219 나옴

    //([('margherita', 90, 80, 100), ('hawaii', 80, 90, 120), ('capricciosa', 50, 70, 130), ('greek', 50, 70, 130)], [('greek', 'Small', 5), ('margherita', 'Small', 4), ('hawaii', 'Large', 1), ('margherita', 'Medium', 2), ('capricciosa', 'Small', 7)])
    // 900이 나와야되는데 910이 나옴


    public static void main(String[] args) {
        Pizza[] menu = {
                new Pizza("margherita", 90, 80, 100),
                new Pizza("hawaii", 80, 90, 120),
                new Pizza("capricciosa", 50, 70, 130),
                new Pizza("greek", 50, 70, 130)
        };

        OrderItem[] order = {
                new OrderItem("greek", "Small", 5),
                new OrderItem("margherita", "Small", 4),
                new OrderItem("hawaii", "Large", 1),
                new OrderItem("margherita", "Medium", 2),
                new OrderItem("capricciosa", "Small", 7)
        };

        System.out.println(solution(menu, order)); // 900이 나와야되는데 1090이 나옴
    }
//
//    public static int solution(Pizza[] menu, OrderItem[] order) {
//// 메뉴 맵 생성 (name -> Pizza)
//        Map<String, Pizza> menuMap;
//        menuMap = new HashMap<>();
//        for (Pizza pizza : menu) {
//            menuMap.put(pizza.name, pizza);
//        }
//
//        // 총 비용 계산
//        int totalCost = 0;
//        List<Integer> allPrices = new ArrayList<>();
//        Map<String, int[]> sizeCount = new HashMap<>();
//
//        for (OrderItem item : order) {
//            Pizza pizza = menuMap.get(item.name);
//
//            int pricePerPizza = item.size.equals("Small") ? pizza.price_S :
//                    item.size.equals("Medium") ? pizza.price_M : pizza.price_L;
//
//            totalCost += pricePerPizza * item.quantity;
//
//            // 모든 가격 기록
//            for (int i = 0; i < item.quantity; i++) {
//                allPrices.add(pricePerPizza);
//            }
//
//            // 크기별 수량 저장
//            sizeCount.putIfAbsent(item.name, new int[3]);
//            int[] counts = sizeCount.get(item.name);
//            if (item.size.equals("Small")) counts[0] += item.quantity;
//            else if (item.size.equals("Medium")) counts[1] += item.quantity;
//            else if (item.size.equals("Large")) counts[2] += item.quantity;
//        }
//
//        // 1. 할인 조건 1: "Buy 3, the cheapest one is free"
//        int discount1 = totalCost;
//        if (allPrices.size() >= 3) {
//            Collections.sort(allPrices);
//            discount1 -= allPrices.get(0); // 가장 저렴한 피자 가격을 빼기
//        }
//
//        // 2. 할인 조건 2: "Buy 5 for 100"
//        int discount2 = totalCost;
//        for (Map.Entry<String, int[]> entry : sizeCount.entrySet()) {
//            int[] counts = entry.getValue();
//            Pizza pizza = menuMap.get(entry.getKey());
//            int[] prices = {pizza.price_S, pizza.price_M, pizza.price_L};
//
//            for (int i = 0; i < 3; i++) {
//                if (counts[i] >= 5) {
//                    discount2 = Math.min(discount2, totalCost - (5 * prices[i]) + 100);
//                }
//            }
//        }
//
//        // 3. 할인 조건 3: "For every Large pizza, get a free Small one"
//        int discount3 = totalCost;
//        int tempCost = totalCost;
//        for (Map.Entry<String, int[]> entry : sizeCount.entrySet()) {
//            int[] counts = entry.getValue();
//            Pizza pizza = menuMap.get(entry.getKey());
//
//            int pairs = Math.min(counts[0], counts[2]); // Large와 Small 페어링 가능 수
//            tempCost -= pairs * pizza.price_S; // Small 피자 가격 만큼 할인
//        }
//        discount3 = tempCost;
//
//        // 4. 할인 조건 4: "Buy 3 Large, pay for 3 Medium"
//        int discount4 = totalCost;
//        for (Map.Entry<String, int[]> entry : sizeCount.entrySet()) {
//            int[] counts = entry.getValue();
//            Pizza pizza = menuMap.get(entry.getKey());
//
//            if (counts[2] >= 3) {
//                discount4 = Math.min(discount4, totalCost - (3 * pizza.price_L) + (3 * pizza.price_M));
//            }
//        }
//
//
//
//        return Math.min(Math.min(discount1, discount2), Math.min(discount3, discount4));
//    }

    public static int solution(Pizza[] menu, OrderItem[] order) {

        Map<String, Pizza> pizzaMap = new HashMap<>();
        for (Pizza pizza : menu) {
            pizzaMap.put(pizza.name, pizza);
        }


        List<Integer> orderItemPrices = new ArrayList<>();
        int totalPrice = 0;

        // 피자 이름별로 크기 수량 매핑
        Map<String, Map<String, Integer>> orderCountMap = new HashMap<>();

        for (OrderItem item : order) {
            Pizza pizza = pizzaMap.get(item.name);
            int pizzaSize = pizza.price_L;

            if (item.size.equals("Small")) {
                pizzaSize = pizza.price_S;
            } else if (item.size.equals("Medium")) {
                pizzaSize = pizza.price_M;
            }

            totalPrice += pizzaSize * item.quantity;

            for (int i = 0; i < item.quantity; i++) {
                orderItemPrices.add(pizzaSize);
            }

            // 피자 이름별로 크기 수량 매핑
            orderCountMap.putIfAbsent(item.name, new HashMap<>());
            Map<String, Integer> sizeMap = orderCountMap.get(item.name);
            sizeMap.put(item.size, sizeMap.getOrDefault(item.size, 0) + item.quantity);

        }

        System.out.println(orderCountMap);


        return Math.min(Math.min(discount1(totalPrice, orderItemPrices), discount2(totalPrice, pizzaMap, orderCountMap)),
                Math.min(discount3(totalPrice, pizzaMap, orderCountMap), discount4(totalPrice, pizzaMap, orderCountMap)));
    }

    private static int discount1(int totalPrice, List<Integer> orderItemPrices) {
        if (orderItemPrices.size() >= 3) {
            totalPrice -= Collections.min(orderItemPrices);
        }
        return totalPrice;
    }

    private static int discount2(int totalPrice, Map<String, Pizza> pizzaMap, Map<String, Map<String, Integer>> orderCountMap) {
        int temp = totalPrice;
        for(Map.Entry<String, Map<String, Integer>> entry: orderCountMap.entrySet()){
            String pizzaString = entry.getKey();
            Map<String, Integer> map = entry.getValue();
            Pizza pizza = pizzaMap.get(pizzaString);

            List<Integer> allPrices = new ArrayList<>();

            for(Map.Entry<String, Integer> sizeTemp: map.entrySet()) {
                String size = sizeTemp.getKey();
                int count = sizeTemp.getValue();

                int price = pizza.price_L;
                if(size.equals("Small")){
                    price = pizza.price_S;
                }else if(size.equals("Medium")){
                    price = pizza.price_M;
                }

                for(int i=0; i<count; i++){
                    allPrices.add(price);
                }
            }

            if(allPrices.size()>=5){
                Collections.sort(allPrices);
                int discount =0;
                for(int i=0; i<5; i++){
                    discount +=allPrices.get(i);
                }

                int total = temp - discount+100;
                totalPrice = Math.min(totalPrice, total);
            }
        }
        return totalPrice;
    }

    private static int discount3(int totalPrice, Map<String, Pizza> pizzaMap, Map<String, Map<String, Integer>> orderCountMap) {
        for (Map.Entry<String, Map<String, Integer>> entry : orderCountMap.entrySet()) {
            String pizzaString = entry.getKey();
            Map<String, Integer> map = entry.getValue();
            Pizza pizza = pizzaMap.get(pizzaString);

            int num = Math.min(map.getOrDefault("Small", 0), map.getOrDefault("Large", 0));
            totalPrice -= num * pizza.price_S;

        }
        return totalPrice;
    }

    private static int discount4(int totalPrice, Map<String, Pizza> pizzaMap, Map<String, Map<String, Integer>> orderCountMap) {
        int temp = totalPrice;
        for (Map.Entry<String, Map<String, Integer>> entry : orderCountMap.entrySet()) {
            String pizzaString = entry.getKey();
            Map<String, Integer> map = entry.getValue();
            Pizza pizza = pizzaMap.get(pizzaString);

            int count = map.getOrDefault("Large", 0);
            if (count >= 3) {

                totalPrice = Math.min(totalPrice, temp - (3 * pizza.price_L) + (3 * pizza.price_M));
            }
        }
        return totalPrice;
    }


    static class Pizza {
        public String name;
        public int price_S;
        public int price_M;
        public int price_L;

        public Pizza(String name, int price_S, int price_M, int price_L) {
            this.name = name;
            this.price_S = price_S;
            this.price_M = price_M;
            this.price_L = price_L;
        }
    }

    static class OrderItem {
        public String name;
        public String size;
        public int quantity;

        public OrderItem(String name, String size, int quantity) {
            this.name = name;
            this.size = size;
            this.quantity = quantity;
        }
    }
}





