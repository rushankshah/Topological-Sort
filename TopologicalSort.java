import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

    static class Node {
        int data;
        List<Node> nodes;

        Node(int data) {
            this.data = data;
            nodes = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        Node node2 = new Node(4);
        node2.nodes.add(new Node(1));
        root.nodes.add(node2);
        root.nodes.add(new Node(3));
        topologicalSort(root);
    }

    static void topologicalSort(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                Node currNode = queue.poll();
                System.out.println(currNode.data);
                for (Node node : currNode.nodes)
                    queue.offer(node);
            }
        }
    }
}
