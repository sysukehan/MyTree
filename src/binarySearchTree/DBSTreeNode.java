package binarySearchTree;

/**
 * Created by kehan on 16-10-14.
 * 二叉搜索树的节点
 */
public class DBSTreeNode<T> {

    private T key;
    private DBSTreeNode<T> leftNode;
    private DBSTreeNode<T> rightNode;

    public DBSTreeNode(T key, DBSTreeNode<T> leftNode, DBSTreeNode<T> rightNode) {
        this.key = key;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public DBSTreeNode(T key) {
        this.key = key;
    }

    public DBSTreeNode() {}

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
