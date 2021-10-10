import java.util.ArrayList;

public class Driver {
    static class Node
    {
        Node left;
        Node right;
        int data;
    };

    static Node newNode(int data)
    {
        Node temp = new Node();

        temp.data = data;
        temp.left = null;
        temp.right = null;

        return temp;
    }

    static ArrayList<Integer> findLongestPath(Node root)
    {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> rightList = findLongestPath(root.right);

        ArrayList<Integer> leftList = findLongestPath(root.left);

        if (rightList.size() > leftList.size()) {
            rightList.add(root.data);
        } else {
            leftList.add(root.data);
        }
        

        return leftList.size() > rightList.size() ? leftList : rightList;
    }

    public static void main(String [] args) {
        Node root = newNode(100);
        root.left = newNode(20);
        root.right = newNode(130);
        root.left.left = newNode(10);
        root.left.right = newNode(50);
        root.left.left.left = newNode(5);

        root.left.right.right = newNode(140);
        root.left.right.left = newNode(110);

        ArrayList<Integer> output = findLongestPath(root);
        int n = output.size();

        System.out.print(output.get(n - 1));
        for(int i = n - 2; i >= 0; i--)
        {
            System.out.print(" -> " + output.get(i));
        }
    }
}
