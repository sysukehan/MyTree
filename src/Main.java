import binarySearchTree.DBSTree;
import util.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kehan on 16-10-17.
 */
public class Main {

//    private final static int[] intData = new int[] {27, 67, 39, 23, 48, 83, 86, 64, 75, 64};
    private static DBSTree<Integer> intTree = new DBSTree<>();
    private static DBSTree<Double> doubleTree = new DBSTree<>();
    private static List<Integer> intData = new ArrayList<>();
    private static List<Double> doubleData = new ArrayList<>();

    public static void main(String[] args) {
        intrgerTypeTest();
//        doubleTypeTest();
    }

    private static void intrgerTypeTest() {
        for (int i = 0; i < 30; i++) {
            intData.add((int)(Math.random() * 100));
            intTree.insert(intData.get(i));
        }
//        System.out.println(intData.toString());
//        System.out.println("root:" + intTree.getRoot().getKey());
        for (int i = 0; i < intData.size(); i++) {
            intTree.delete(intData.get(i));
            System.out.println(intTree.ascend().toString());
//            if (i >= intData.size() / 2) {
//                break;
//            }
        }
//        System.out.println(intData.toString());
//        System.out.println(intTree.ascend().toString());
//        for (int i = 0; i < intData.size(); i++) {
//            Logger.print(intData.get(i) + " exist:" + intTree.search(intData.get(i)));
//        }

//        intData.clear();
//        for (int i = 0; i < 10; i++) {
//            intData.add((int)(Math.random() * 100));
//            intTree.insert(intData.get(i));
//            System.out.println(intTree.ascend().toString());
//        }
//        System.out.println(intData.toString());
    }

    private static void doubleTypeTest() {
        for (int i = 0; i < 30; i++) {
//            intData.add((int)(Math.random() * 100));
//            intTree.insert(intData.get(i));
            doubleData.add(Math.ceil(Math.random() * 1000 * 100) / 100);
            doubleTree.insert(doubleData.get(i));
//            doubleTree.insert(Math.ceil(Math.random() * 1000 * 100) / 100);
        }
//        System.out.println(intData.toString());
//        System.out.println("root:" + intTree.getRoot().getKey());
        System.out.println(doubleData.toString());
        System.out.println(doubleTree.ascend().toString());
        for (int i = 0; i < doubleData.size(); i++) {
            doubleTree.delete(doubleData.get(i));
//            System.out.println("root:" + intTree.getRoot().getKey());
            System.out.println(doubleTree.ascend().toString());
            if (i >= doubleData.size() / 2) {
                break;
            }
        }
        doubleData.clear();
        for (int i = 0; i < 10; i++) {
            doubleData.add(Math.ceil(Math.random() * 1000 * 100) / 100);
            doubleTree.insert(doubleData.get(i));
            System.out.println(doubleTree.ascend().toString());
        }
        System.out.println(doubleData.toString());
    }
}
