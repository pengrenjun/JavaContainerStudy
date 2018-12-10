package JavaContainerStudy.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/*
说明：程序中对HashMap进行了封装，将其封装为线程安全的集合，而ConcurrentHashMap是线程安全的，Hashtable也是线程安全的，
但是，其并发效率并不搞，可以看到，ConcurrentHashMap的性能相比HashMap的线程安全同步集合和Hashtable而言，性能都要高出不少。
原因是经过Collections封装的线程安全的HashMap和Hashtable都是对整个结构加锁，
而ConcurrentHashMap是对每一个桶单独进行锁操作，不同的桶之间的操作不会相互影响，可以并发执行。因此，其速度会快很多。
*/

public class ConcurrentHashMapSourceTest {

    static final int THREADNUMBER = 50;
    static final int NUMBER = 5000;

    public static void main(String[] args) throws Exception {
        Map<String, Integer> hashmapSync = Collections
                .synchronizedMap(new HashMap<String, Integer>());
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<String, Integer>();
        Map<String, Integer> hashtable = new Hashtable<String, Integer>();

        long totalA = 0L;
        long totalB = 0L;
        long totalC = 0L;
        for (int i = 0; i <= 100; i++) {
            totalA += put(hashmapSync);
            totalB += put(concurrentHashMap);
            totalC += put(hashtable);
        }
        System.out.println("put time HashMapSync = " + totalA + "ms.");
        System.out.println("put time ConcurrentHashMap = " + totalB + "ms.");
        System.out.println("put time Hashtable = " + totalC + "ms.");
        totalA = 0;
        totalB = 0;
        totalC = 0;
        for (int i = 0; i <= 10; i++) {
            totalA += get(hashmapSync);
            totalB += get(concurrentHashMap);
            totalC += get(hashtable);
        }
        System.out.println("get time HashMapSync=" + totalA + "ms.");
        System.out.println("get time ConcurrentHashMap=" + totalB + "ms.");
        System.out.println("get time Hashtable=" + totalC + "ms.");
    }

    public static long put(Map<String, Integer> map) throws Exception {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(THREADNUMBER);
        for (int i = 0; i < THREADNUMBER; i++) {
            new PutThread(map, countDownLatch).start();
        }
        countDownLatch.await();
        return System.currentTimeMillis() - start;
    }

    public static long get(Map<String, Integer> map) throws Exception {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(THREADNUMBER);
        for (int i = 0; i < THREADNUMBER; i++) {
            new GetThread(map, countDownLatch).start();
        }
        countDownLatch.await();
        return System.currentTimeMillis() - start;
    }

}


class PutThread extends Thread {
    private Map<String, Integer> map;
    private CountDownLatch countDownLatch;
    private String key = this.getId() + "";

    PutThread(Map<String, Integer> map, CountDownLatch countDownLatch) {
        this.map = map;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 1; i <= ConcurrentHashMapSourceTest.NUMBER; i++) {
            map.put(key, i);
        }
        countDownLatch.countDown();
    }
}

class GetThread extends Thread {
    private Map<String, Integer> map;
    private CountDownLatch countDownLatch;
    private String key = this.getId() + "";

    GetThread(Map<String, Integer> map, CountDownLatch countDownLatch) {
        this.map = map;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 1; i <= ConcurrentHashMapSourceTest.NUMBER; i++) {
            map.get(key);
        }
        countDownLatch.countDown();
    }
}
