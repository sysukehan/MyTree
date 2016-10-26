package binarySearchTree;

/**
 * Created by kehan on 16-10-14.
 * 二叉搜索树的节点
 */
public class DBSTreeNode<T extends Comparable> {

    private T key;  //  节点存放的关键字
    private DBSTreeNode<T> leftNode;  //  节点的左节点
    private DBSTreeNode<T> rightNode;  //  节点的右节点

    /**
     * 根据关键字构造一个节点
     * @param key 关键字
     */
    public DBSTreeNode(T key) {
        this.key = key;
        leftNode = null;
        rightNode = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public DBSTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(DBSTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public DBSTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(DBSTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }
}
