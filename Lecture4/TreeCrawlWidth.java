package Lecture4;

// Обход в ширину
// без рекурсии

import java.util.ArrayList;
import java.util.List;

public class TreeCrawlWidth {
    Node root;

    public boolean exist(int value) {
        if (root != null) {
            Node node = find(value);
            if (node != null) {
                return true;
            }

        }
        return false;
    }

    private Node find(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);

            }
            line = nextLine;
        }
        return null;

    }

    public class Node {
        int value;
        List<Node> children;
    }
}
