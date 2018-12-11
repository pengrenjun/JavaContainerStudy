package JavaContainerStudy.map;


public class  ConcurrentSkipListTest{

    public static void main(String[] args) {

        ConcurrentSkipListTest.findPredecessor();
    }


    /*测试findPredecessor方法数据处理流程
    *
    *
    * private Node<K,V> findPredecessor(Object key, Comparator<? super K> cmp) {
    if (key == null)
        throw new NullPointerException(); // don't postpone errors
    for (;;) {
        //q:head节点; r:右节点; d:下节点
        for (Index<K,V> q = head, r = q.right, d;;) {
            //右节点不为空
            if (r != null) {
                Node<K,V> n = r.node;
                K k = n.key;
                //判断r.node是否被删除
                if (n.value == null) {
                    //如果n已经删除,尝试以CAS更新q的右节点为r.right
                    if (!q.unlink(r))
                        break;           // restart
                    r = q.right;         // reread r
                    continue;
                }
                //比较key和k
                if (cpr(cmp, key, k) > 0) {
                    //继续向右循环
                    q = r;
                    r = r.right;
                    continue;
                }
            }
            //right节点为空,则向下找
            if ((d = q.down) == null)
                //下节点为空,返回当前q节点的node
                return q.node;
            q = d;
            r = d.right;
        }
    }
}    */
    public static int  findPredecessor() {

        for (;;) {
            // 从head 开始遍历
            for (int q = 1, r = q+1, d;;) {
                // r != null，表示该节点右边还有节点，需要进行比较
                if (r !=0 ) {

                    // 如果key 大于r节点的key 则继续向后遍历
                    if (r > 0) {
                        q = r;
                        r = r-1;
                        continue;
                    }
                }
                //如果dowm == null，表示指针已经达到最下层了，直接返回该节点
                if (q == 3)
                    return q; //跳出整个for循环
                //否则进入下层查找
                r=r+1;
                q = r+1;

            }
        }
    }

}