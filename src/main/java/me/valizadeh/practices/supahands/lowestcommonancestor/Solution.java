package me.valizadeh.practices.supahands.lowestcommonancestor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :   Valizadeh, Ali
 */
public class Solution {

    public static void main(String[] args) {
        Node head = createTree();
        Node aNode = findNode(head, 'G');
        Node bNode = findNode(head, 'D');
        Node lowestCommonAncestor = getLowestCommonAncestor(head, aNode, bNode);
        System.out.println(lowestCommonAncestor);
    }

    /**
     * Finding the lowest ancestor of two given nodes
     * @param head The start node of a tree
     * @param a First Node
     * @param b Second Node
     * @return
     */
    private static Node getLowestCommonAncestor(Node head, Node a, Node b) {
        if(a.parent != null && b.parent != null && a.parent.equals(b.parent)) {
            return a.parent;
        } else {
            if(a.level == b.level) {
                return getLowestCommonAncestor(head, a.parent, b.parent);
            } else if(a.level < b.level) {
                return getLowestCommonAncestor(head, a, b.parent);
            } else {
                return getLowestCommonAncestor(head, a.parent, b);
            }
        }

    }

    /**
     * Finding a node in a tree
     * @param head The start node of a tree
     * @param value The value of a Node we want to find in the tree
     * @return The node equivalent to the value
     */
    private static Node findNode(Node head, char value) {
        if (head.isEqual(value)) {
            return head;
        }
        for (Node child : head.children) {
            Node node = findNode(child, value);
            if (node != null) {
                return node;
            }
        }
        return null;

    }


    /**
     * If we have restriction of saving node level then we should calculate it.
     * So this method would be handy.
     * @param head Start node of the tree
     * @param node The node we want to find its level
     * @param parentLevel The level of parent of this node.
     *                    If the node we want to find its level is head of the tree then parentLevel would be 0;
     * @return
     */
    private static int findNodeLevel(Node head, Node node, int parentLevel) {
        if (head.equals(node)) {
            return parentLevel + 1;
        }
        for (Node child : head.children) {
            int level = findNodeLevel(child, node, parentLevel + 1);
            if (level > parentLevel) {
                return level;
            }
        }
        return 0;

    }


    /**
     * The method to create the sample tree.
     * @return The head node of our tree.
     */
    private static Node createTree() {
        Node head = new Node('A', null);
        {
            Node nodeB = new Node('B', head);
            {
                Node nodeC = new Node('C', nodeB);
                {
                    Node nodeD = new Node('D', nodeC);
                    Node nodeE = new Node('E', nodeC);
                }
                Node nodeF = new Node('F', nodeB);
                {
                    Node nodeG = new Node('G', nodeF);
                    Node nodeH = new Node('H', nodeF);
                }
                Node nodeI = new Node('I', nodeB);
            }
            Node nodeJ = new Node('J', head);
            {
                Node nodeK = new Node('K', nodeJ);
            }
        }
        return head;
    }

    /**
     * The class which is used to make the tree.
     */
    static class Node {
        int level;
        char value;

        Node parent;

        Set<Node> children;

        public Node(char value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.children = new HashSet<>();
            if (this.parent != null) {
                this.parent.addChild(this);
                this.level = this.parent.level + 1;
            } else {
                this.level = 1;
            }
        }

        public void addChild(Node child) {
            this.children.add(child);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return value == node.value;

        }

        @Override
        public int hashCode() {
            int result = (int) value;
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        public boolean isEqual(char value) {
            return this.value == value;
        }
    }
}


