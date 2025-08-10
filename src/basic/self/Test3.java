package basic.self;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test3 {
    /**
     * 리스트에서 가장 많이 나온 단어 K개를 빈도순, 알파벳순으로 정렬하여 리턴합니다.
     *
     * @param words 단어 배열
     * @param k     추출할 개수
     * @return 상위 K개 단어 리스트
     */
    public static List<String> findTopK(String[] words, int k) {
        // 1. 각 단어의 빈도수를 계산합니다.
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // 2. Map의 keySet을 가져와 리스트로 변환 후 정렬합니다.
        List<String> uniqueWords = new ArrayList<>(freqMap.keySet());

        // 3. 정렬 (1순위: 빈도수 내림차순, 2순위: 알파벳 오름차순)
        Collections.sort(uniqueWords, (w1, w2) -> {
            int freq1 = freqMap.get(w1);
            int freq2 = freqMap.get(w2);

            // 빈도수가 다르면 빈도수 기준으로 내림차순 정렬
            if (freq1 != freq2) {
                return freq2 - freq1;
            }
            // 빈도수가 같으면 단어 기준으로 오름차순(알파벳순) 정렬
            else {
                return w1.compareTo(w2);
            }
        });

        // 4. 정렬된 리스트에서 상위 k개만 추출하여 리턴합니다.
        return uniqueWords.subList(0, k);
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "java", "i", "love", "coding", "i", "java"};
        int k = 2;
        // 빈도수: "i"(3), "love"(2), "java"(2), "coding"(1)
        // 정렬 결과: "i", "java", "love", "coding" ("java"가 "love"보다 알파벳순으로 앞서므로)

        List<String> topKWords = findTopK(words, k);
        System.out.println(topKWords); // [i, java]
        System.out.println(findTop(words, k));
        System.out.println(findTop2(words, k));

        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 3;
        // 빈도수: "the"(4), "is"(3), "sunny"(2), "day"(1)
        List<String> topKWords2 = findTopK(words2, k2);
        System.out.println(topKWords2); // [the, is, sunny]
    }


    public static List<String> findTop(String[] words, int k) {
        Map<String, Long> freqMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        List<String> sortedList = new ArrayList<>(freqMap.keySet()).stream()
                .sorted((o1, o2) -> Math.toIntExact(freqMap.get(o2) - freqMap.get(o1)))
                .toList();

        return sortedList.subList(0, k);
    }

    public static List<String> findTop2(String[] words, int k) {
        Map<String, Integer> collect = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.summingInt(_ -> 1)));

        List<String> sortedList = new ArrayList<>(collect.keySet()).stream()
                .sorted((o1, o2) -> collect.get(o2) - collect.get(o1))
                .toList();

        return sortedList.subList(0, k);
    }
}
