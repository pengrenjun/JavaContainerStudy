package JavaContainerStudy.iterator;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @Description: 测试ListIterator迭代器
 * @Author：pengrj
 * @Date : 2018/12/6 0006 13:54
 * @version:1.0
 */
public class ListIteratorExample {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add("aaa");
        a.add("bbb");
        a.add("ccc");
        System.out.println("Before iterate : " + a);
        ListIterator<String> it = a.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next() + ", " + it.previousIndex() + ", " + it.nextIndex());
        }
        System.out.println("===========================================");

        while (it.hasPrevious()) {
            System.out.println(it.previous() + " "+it.previousIndex() + ", " + it.nextIndex());
        }
        System.out.println("=======================================");

        //从bbb,ccc开始迭代
        it = a.listIterator(1);
        while (it.hasNext()) {
            String t = it.next();
            System.out.println(t);
            if ("ccc".equals(t)) {
                it.set("nnn");
            } else {
                it.add("kkk");
            }
        }
        System.out.println("After iterate : " + a);
    }
}

