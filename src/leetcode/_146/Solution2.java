package leetcode._146;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution2 {
    static class LRUCache {

        // 실제 LRU 기능을 수행할 LinkedHashMap 구현체를 사용합니다.
        private final LRUCacheLinkedHashMap cacheImpl;

        public LRUCache(int capacity) {
            this.cacheImpl = new LRUCacheLinkedHashMap(capacity);
        }

        public int get(int key) {
            return cacheImpl.get(key);
        }

        public void put(int key, int value) {
            cacheImpl.put(key, value);
        }

        // (선택 사항) 내부 클래스로 LinkedHashMap 구현체를 포함시킬 수도 있습니다.
        private static class LRUCacheLinkedHashMap extends LinkedHashMap<Integer, Integer> {
            private final int capacity;

            public LRUCacheLinkedHashMap(int capacity) {
                super(16, 0.75f, true);
                this.capacity = capacity;
            }

            @Override
            public Integer get(Object key) {
                Integer value = super.get(key);
                return value == null ? -1 : value;
            }

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        }
    }

}
