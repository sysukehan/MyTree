package binarySearchTree;

import util.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kehan on 16-10-14.
 * 有重复值的二叉搜索树
 * 根节点左子树的关键值小于等于根节点的关键值
 * 根节点右子树的关键值大于根节点的关键值
 */
public class DBSTree<T extends Comparable> {

    private DBSTreeNode<T> root;  //  根节点
    private List<T> list;  //  存储树中关键值按升序排列的list
    private int size;  //  节点数量
    private boolean flag;  //  用于记录数据从上次获得升序排列list之后有无改变

    /**
     * 构造函数
     */
    public DBSTree() {
        create();  //  调用创建空二叉树的方法
    }

    /**
     * 创建一个空的二叉搜索树
     */
    private void create() {
        root = null;  //  根节点为空
        size = 0;  //  节点数量为0
        list = new ArrayList<T>();  //  初始化list
        //  flag为true，表示这棵二叉树在上次获得list之后元素没有增删
        //  flag为false，表示这棵二叉树在上次获得list之后元素有增删
        flag = true;
    }

    /**
     * 查找关键值为key的元素
     * @param key
     * @return 成功返回true，失败返回false
     */
    public boolean search(T key) {
//        return recursiveSearch(root, key);  //  调用搜索的方法（递归查找）
        return loopSearch(key);  //  调用搜索的方法（循环查找）
    }

    /**
     * 将指定的关键字插入树中
     * @param key 关键字
     */
    public void insert(T key) {
        if (root == null) {  //  如果此时根节点为空，那么将该关键字作为根节点的关键字，初始化根节点
            root = new DBSTreeNode<T>(key);
        } else {  //  否则，调用插入关键字的方法
//            recursiveSearchForInsert(root, key);  //  使用递归的方法插入关键字
            loopSearchForInsert(key);  //  使用循环的方法插入关键字
        }
        flag = false;  //  因为有插入元素的操作发生，所以flag置为false
        size++;  //  树的元素数量加1
    }

    /**
     * 删除关键值为key的元素
     * @param key
     */
    public void delete(T key) {
        flag = false;
//        removeTheLastOne(key);
        removeTheFirstOne(key);
    }

    /**
     * 获取树中元素的升序排列
     * @return
     */
    public List<T> ascend() {
        //  如果flag为true，说明从上次获取升序排列的列表之后，树中没有插入删除操作
        //  那么将上次得到的列表直接返回即可，节省时间
        //  否则，就需要清空列表中的元素，然后重新获得升序排列的列表
        if (!flag) {
            flag = true;
            list.clear();
            inorderTraversal(root);
        }
        return list;
    }

    /**
     * 获得树节点的数量
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 递归搜索树中有没有指定的关键字
     * @param node 搜索的节点
     * @param key 关键字
     * @return
     */
    private boolean recursiveSearch(DBSTreeNode<T> node, T key) {
        //  如果传进来的搜索节点为空，则说明找不到该关键字，返回false
        if (node == null) {
            return false;
        }
        //  如果搜索节点的关键字就是要查找的关键字，返回true
        if (node.getKey().compareTo(key) == 0) {
            return true;
        } else if (key.compareTo(node.getKey()) < 0) {  //  如果关键字比搜索节点的关键字小，从当前搜索节点的左子树继续查找
            return recursiveSearch(node.getLeftNode(), key);
        } else {  //  如果关键字比搜索节点的关键字大，从当前搜索节点的右子树继续查找
            return recursiveSearch(node.getRightNode(), key);
        }
    }

    /**
     * 循环搜索树中有没有指定的关键字
     * @param key 关键字
     * @return
     */
    private boolean loopSearch(T key) {
        DBSTreeNode<T> tempNode = root;  //  从根节点开始搜索
        //  当搜索到的节点为空或者搜索到的节点的关键字与要搜索的关键字相同时跳出循环
        //  注意：要先判断搜索到的节点是否为空，否则可能会出现空指针错误
        while (tempNode != null && tempNode.getKey().compareTo(key) != 0) {
            if (key.compareTo(tempNode.getKey()) < 0) {
                tempNode = tempNode.getLeftNode();
            } else {
                tempNode = tempNode.getRightNode();
            }
        }
        //  如果跳出循环时搜索到的节点为空，说明树中没有该关键字，返回false
        //  否则，说明树中有该关键字，返回true
        return tempNode != null;
    }

    /**
     * 中序遍历
     * @param root 遍历开始节点
     */
    private void inorderTraversal(DBSTreeNode<T> root) {
        if (root == null) {  //  如果节点为空，返回
            return;
        }
        inorderTraversal(root.getLeftNode());  //  中序遍历当前节点左子树
        list.add(root.getKey());  //  将当前节点的关键值放入列表中
        inorderTraversal(root.getRightNode());  //  中序遍历当前节点的右子树
    }

    /**
     * 使用递归的方式搜寻key应该插入的位置
     * @param node 当前搜索节点
     * @param key 关键字
     */
    private void recursiveSearchForInsert(DBSTreeNode<T> node, T key) {
        //  如果key小于等于搜索节点的关键字，从当前搜索节点的左子树继续查找
        if (key.compareTo(node.getKey()) <= 0) {
            if (node.getLeftNode() == null) {  //  如果当前节点的左节点为空，则关键字插入在此处
                node.setLeftNode(new DBSTreeNode<T>(key));
            } else {  //  不为空则继续查找
                recursiveSearchForInsert(node.getLeftNode(), key);
            }
        } else {  //  如果key大于搜索节点的关键字，从当前搜索节点的右子树继续查找
            if (node.getRightNode() == null) {  //  如果当前节点的右节点为空，则关键字插入在此处
                node.setRightNode(new DBSTreeNode<T>(key));
            } else {  //  不为空则继续查找
                recursiveSearchForInsert(node.getRightNode(), key);
            }
        }
    }

    /**
     * 使用循环的方式搜寻key应该插入的位置
     * @param key 关键字
     */
    private void loopSearchForInsert(T key) {
        DBSTreeNode<T> tempNode = root;  //  从根节点开始查找
        while (true) {  //  死循环，由内部控制什么时候跳出
            if (key.compareTo(tempNode.getKey()) <= 0) {  //  如果关键字小于等于当前节点
                if (tempNode.getLeftNode() == null) {  //  当前节点的左节点为空
                    tempNode.setLeftNode(new DBSTreeNode<T>(key));  //  关键字插入在当前节点的左节点位置
                    break;  //  插入完毕，跳出循环
                } else {
                    tempNode = tempNode.getLeftNode();  //  当前节点的左节点不为空，将当前节点移动至它的左节点，继续循环
                }
            } else {  //  如果关键字大于当前节点
                if (tempNode.getRightNode() == null) {  //  当前节点的右节点为空
                    tempNode.setRightNode(new DBSTreeNode<T>(key));  //  关键字插入在当前节点的右节点位置
                    break;  //  插入完毕，跳出循环
                } else {
                    tempNode = tempNode.getRightNode();  //  当前节点的右节点不为空，将当前节点移动至它的右节点，继续循环
                }
            }
        }
    }

    /**
     * 删除指定关键字，如果有相同的关键字，删除最早插入树中的那个
     * @param key 关键字
     */
    private void removeTheFirstOne(T key) {
        DBSTreeNode<T> targetParentNode = null;
        DBSTreeNode<T> targetNode = null;
        DBSTreeNode<T> currentParentNode = root;
        DBSTreeNode<T> currentNode = root;
        while (currentNode != null) {
            if (currentNode.getKey().compareTo(key) == 0) {
                targetParentNode = currentParentNode;
                targetNode = currentNode;
                break;
            }
            currentParentNode = currentNode;
            if (key.compareTo(currentNode.getKey()) <= 0) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }
        removeOperation(targetParentNode, targetNode);
    }

    /**
     * 删除指定关键字，如果有相同的关键字，删除最晚插入树中的那个
     * @param key 关键字
     */
    private void removeTheLastOne(T key) {
        DBSTreeNode<T> targetParentNode = null;
        DBSTreeNode<T> targetNode = null;
        DBSTreeNode<T> currentParentNode = root;
        DBSTreeNode<T> currentNode = root;
        while (currentNode != null) {
            if (currentNode.getKey().compareTo(key) == 0) {
                targetParentNode = currentParentNode;
                targetNode = currentNode;
            }
            currentParentNode = currentNode;
            if (key.compareTo(currentNode.getKey()) <= 0) {
                currentNode = currentNode.getLeftNode();
            } else {
                currentNode = currentNode.getRightNode();
            }
        }
        removeOperation(targetParentNode, targetNode);
    }

    /**
     * 删除操作，删除child节点
     * @param parent child节点的父节点
     * @param child 待删除的节点
     */
    private void removeOperation(DBSTreeNode<T> parent, DBSTreeNode<T> child) {
        if (parent == null || child == null) {
            return;
        }
        int flag = -1;  //  标志位，用于判断child是parent节点的左子树还是右子树，或者child和parent都是根节点
        if (parent.getLeftNode() == child) {
            flag = 0;  //  child是parent节点的左子树
        } else if (parent.getRightNode() == child){
            flag = 1;  //  child是parent节点的右子树
        } else {
            flag = 2;  //  child和parent都是根节点
        }
        //  第一种情况，子节点是树叶，没有左右子树
        if (child.getLeftNode() == null && child.getRightNode() == null) {
            if (flag == 0) {  //  child是parent节点的左子树，将parent的左节点置为空即可
                parent.setLeftNode(null);
            } else if (flag == 1) {  //  child是parent节点的右子树，将parent的右节点置为空即可
                parent.setRightNode(null);
            } else {  //  child和parent都是根节点，将根节点置为空
                root = null;
            }
            return;
        }

        //  第二种情况，子节点有两个非空子树
        if (child.getLeftNode() != null && child.getRightNode() != null) {
            DBSTreeNode<T> currentParentNode = child;
            DBSTreeNode<T> currentNode = child.getLeftNode();
            //  在子节点的左子树中找到最大值
            while (currentNode.getRightNode() != null) {
                currentParentNode = currentNode;
                currentNode = currentNode.getRightNode();
            }
            child.setKey(currentNode.getKey());
            removeOperation(currentParentNode, currentNode);
            return;
        }

        //  第三种情况，子节点只有一个非空子树
        //  待删除节点的左子树不为空
        if (child.getLeftNode() != null) {
            if (flag == 0) {
                parent.setLeftNode(child.getLeftNode());
            } else if (flag == 1) {
                parent.setRightNode(child.getLeftNode());
            } else {
                root = child.getLeftNode();
            }
            return;
        }
        //  待删除节点的右子树不为空
        if (child.getRightNode() != null) {
            if (flag == 0) {
                parent.setLeftNode(child.getRightNode());
            } else if (flag == 1) {
                parent.setRightNode(child.getRightNode());
            } else {
                root = child.getRightNode();
            }
            return;
        }
    }
}
