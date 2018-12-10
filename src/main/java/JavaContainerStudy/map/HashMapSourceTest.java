package JavaContainerStudy.map;

import java.util.HashMap;

/**
 * @Description:  HashMap源码代码测试
 * @Author：pengrj
 * @Date : 2018/12/6 0006 17:39
 * @version:1.0
 */
public class HashMapSourceTest {

    // 序列号
    private static final long serialVersionUID = 362498820763181265L;
    // 默认的初始容量是16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    // 最大容量 1073741824
    static final int MAXIMUM_CAPACITY = 1 << 30;
    // 默认的填充因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    // 当桶(bucket)上的结点数大于这个值时会转成红黑树
    static final int TREEIFY_THRESHOLD = 8;
    // 当桶(bucket)上的结点数小于这个值时树转链表
    static final int UNTREEIFY_THRESHOLD = 6;
    // 桶中结构转化为红黑树对应的table的最小大小
    static final int MIN_TREEIFY_CAPACITY = 64;
    /*// 存储元素的数组，总是2的幂次倍
    transient Node<k,v>[] table;
    // 存放具体元素的集
    transient Set<map.entry<k,v>> entrySet;*/
    // 存放元素的个数，注意这个不等于数组的长度。
    transient int size;
    // 每次扩容和更改map结构的计数器
    transient int modCount;
    // 临界值 当实际大小(容量*填充因子)超过临界值时，会进行扩容
    int threshold;
    // 填充因子
    //final float loadFactor;

    public static void main(String[] args) {

       int tableSize=  HashMapSourceTest.tableSizeFor(100);

        System.out.println("tableSize:"+tableSize);


        int hash=HashMapSourceTest.hash("100000000");
        System.out.println(hash);


        int tablePosision=table(10,"QWE");

        System.out.println("tablePosision:"+tablePosision);

    }

    //返回大于initialCapacity的最小的二次幂数值
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    //hash算法
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }



    //key在哈希列表中的具体位置
    //在putVal源码中，我们通过(n-1)&hash获取该对象的键在hashmap中的位置。（其中hash的值就是（1）中获得的值）其中n表示的是hash桶数组的长度，并且该长度为2的n次方，这样(n-1)&hash就等价于hash%n。因为&运算的效率高于%运算
    static final int table(int tablesize,Object key) {

       return  (tablesize - 1) & hash(key);

    }

}
