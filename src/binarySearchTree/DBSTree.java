package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kehan on 16-10-14.
 * 有重复值的二叉搜索树
 * 根节点左子树的关键值小于等于根节点的关键值
 * 根节点右子树的关键值大于根节点的关键值
 */
public class DBSTree<T> {

    private DBSTreeNode<T> root;  //  根节点
    private List<T> list;  //  升序排列的list
    private int size;  //  节点数量
    private boolean flag;  //  用于记录数据从上次获得升序排列list之后有无改变

    /**
     * 创建一个空的二叉搜索树
     */
    public void create() {
        root = new DBSTreeNode<T>();
        size = 0;
        list = new ArrayList<T>();
        flag = true;
    }

    /**
     * 查找关键值为key的元素
     * @param key
     * @return 成功返回true，失败返回false
     */
    public boolean search(T key) {
        return false;
    }

    /**
     * 将key插入树中
     * @param key
     */
    public void insert(T key) {
        flag = false;
    }

    /**
     * 删除关键值为key的元素
     * @param key
     * @return 成功返回true，失败返回false
     */
    public boolean delete(T key) {
        flag = false;
        return false;
    }

    public List<T> ascend() {
        flag = true;
        return list;
    }
}
