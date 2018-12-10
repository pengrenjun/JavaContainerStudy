package JavaContainerStudy.list;

import java.util.ArrayList;

/**
 * @Description: ArrayList源码代码测试
 * @Author：pengrj
 * @Date : 2018/12/7 0007 9:54
 * @version:1.0
 */
public class ArrayListSourceTest {

    public static void main(String[] args) {

        ArrayList<String> arrayList=new ArrayList<>();


        //应用程序也可以使用ensureCapacity操作来增加ArrayList实例的容量，这可以减少递增式再分配的数量
        arrayList.ensureCapacity(10);

        int oldCapacity=10;
        //注意此处扩充capacity的方式是将其向右一位再加上原来的数，实际上是扩充了1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        System.out.println("newCapacity :"+newCapacity);


    }
}
