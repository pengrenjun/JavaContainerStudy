package JavaContainerStudy.list;

import java.util.LinkedList;

/**
 * @Description:   LinkedList源代码测试
 * @Author：pengrj
 * @Date : 2018/12/8 0008 9:30
 * @version:1.0
 */
public class LinkedListSourceTest {

    public static void main(String[] args) {

        LinkedList linkedList=new LinkedList();

        //计算指定索引上的节点（返回Node） LinkedList还对整个做了优化，
        // 不是盲目地直接从头进行遍历，而是先比较一下index更靠近链表（LinkedList）的头节点还是尾节点。
        // 然后进行遍历，获取相应的节点
        /*优化的算法 index < (size >> 1)*/

        //list的长度
        int size=30;

        //数据的存储位置
        int index=2;

        //size >> 1 相当于size/2
        System.out.println(size >> 1);




    }
}
