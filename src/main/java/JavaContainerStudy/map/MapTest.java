package JavaContainerStudy.map;

import java.util.*;

/**
 * @Description:
 * @Author：pengrj
 * @Date : 2018/12/6 0006 14:50
 * @version:1.0
 */
public class MapTest {
    public static void main(String[] args) {

        //HashMap 按照key的hashcode进行排序
        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("4", "d");
        hashMap.put("3", "c");
        hashMap.put("2", "b");
        hashMap.put("1", "a");

        String str=hashMap.get("1");



        //hashMap.putIfAbsent()  如果key值相同不进行覆盖 putVal(hash(key), key, value, true, true);
        // hashMap.put()         如果key值相同进行覆盖   putVal(hash(key), key, value, false, true);

//        * @param onlyIfAbsent if true, don't change existing value
//        * @param evict if false, the table is in creation mode.
//        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//        boolean evict)

        Iterator<String> iteratorHashMap = hashMap.keySet().iterator();

        System.out.println("HashMap-->");

        while (iteratorHashMap.hasNext()){

            Object key1 = iteratorHashMap.next();
            System.out.println(key1 + "--" + hashMap.get(key1)+"--"+"key hashcode:"+key1.hashCode());
        }

        //LinkedHashMap 按照添加的顺序进行排序
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("4", "d");
        linkedHashMap.put("3", "c");
        linkedHashMap.put("2", "b");
        linkedHashMap.put("1", "a");

        Iterator<String> iteratorLinkedHashMap = linkedHashMap.keySet().iterator();

        System.out.println("LinkedHashMap-->");

        while (iteratorLinkedHashMap.hasNext()){

            Object key2 = iteratorLinkedHashMap.next();
            System.out.println(key2 + "--" + linkedHashMap.get(key2));
        }


        //TreeMap 默认按照key的升序进行排序
        TreeMap<String,String> treeMap = new TreeMap();
        treeMap.put("4", "d");
        treeMap.put("3", "c");
        treeMap.put("2", "b");
        treeMap.put("1", "a");

        Iterator<String> iteratorTreeMap = treeMap.keySet().iterator();

        System.out.println("TreeMap-->");

        while (iteratorTreeMap.hasNext()){

            Object key3 = iteratorTreeMap.next();
            System.out.println(key3 + "--" + treeMap.get(key3));
        }


        //TreeMap 添加排序规则
        TreeMap<String,String> treeMapB = new TreeMap(new Comparator() {
            //这个规则的定义通过比较key值进行value的添加，所以定义的规则一定要准确能够区分不同的key的关系
            @Override
            public int compare(Object o1, Object o2) {
                String o11=(String) o1;
                String o22=(String) o2;

                if(o11.length()>o22.length()){
                   return -1;
                }
                if(o11.length()==o22.length()){
                    return 0;
                }
                return 1;
            }
        });
        treeMapB.put("4qqq", "d");
        treeMapB.put("3qqq", "c");
        treeMapB.put("2qq", "b");
        treeMapB.put("1q", "a");

        Iterator<String> iteratorTreeMapB = treeMapB.keySet().iterator();

        System.out.println("TreeMap Comparator-->");

        while (iteratorTreeMapB.hasNext()){

            Object key3 = iteratorTreeMapB.next();
            System.out.println(key3 + "--" + treeMapB.get(key3));
        }
    }
}
