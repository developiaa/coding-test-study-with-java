package codility.n2211;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


interface TimeProvider {
    long getMillis();
}

public class Solution2 {

    private int maxSize;
    private TimeProvider timeProvider;
    private ConcurrentHashMap<String, Map<String, TimeProvider>> map;

    Solution2(TimeProvider timeProvider, int maxSize) {
        this.timeProvider = timeProvider;
        this.maxSize = maxSize;
        this.map = new ConcurrentHashMap<>();
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) {

//        new HashMap<>()
//        throw new Exception();
    }

//    public Optional<String> get(String key) {
//        if(key==null){
//            throw new Exception();
//        }else{
//            Map<String, TimeProvider> stringTimeProviderMap = map.get(key);
//        }
//
//    }

    public int size() {
        return this.maxSize;
        //throw new NotImplementedException();
    }

}
