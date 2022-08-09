package com.practice.Trees_Graphs;

//greater than node and smallest element
public class Solution {

    static class Node {
        int key;
        Node parent;
        Node right;
        Node left;

        Node(int key) {
            this.key = key;
            parent = null;
            left = null;
            right = null;
        }
    }

    static class BinarySearchTree {
        Node root;

        Node inOrderSuccessor(Node inputNode) {
            if (inputNode == null)
                return null;

            if (inputNode.right != null) {
                getMostLeft(inputNode.right);
            }

            Node parent = inputNode.parent;
            Node child = inputNode;

            while (parent.right == child) {
                if (parent.parent == null)
                    return null;
                child = parent;
                parent = parent.parent;
            }

            //if node.right exists
            // go down to right
            // check if left exists
            // go all way to bottom left until null

            // need to go up
            // got to parent
            // check which side you came from
            // if you came from left side, return parent
            // if you came from right side, go up again
            return parent;
        }

        Node getMostLeft(Node x) {
            if (x.left == null) {
                return x;
            } else {
                getMostLeft(x.left);
            }
            return null;
        }

        void insert(int key) {
            // 1. if tree is empty, create the root
            if (this.root == null) {
                this.root = new Node(key);
                return;
            }
            //2. other-wise create a node with key and traverse down the tree to find where to insert new node
            Node currentNode = this.root;
            Node newNode = new Node(key);
            while (currentNode != null) {
                if (key < currentNode.key) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        Node getNodeByKey(int key) {
            Node currentNode = this.root;
            while (currentNode != null) {
                if (key == currentNode.key) {
                    return currentNode;
                }

                if (key < currentNode.key) {
                    currentNode = currentNode.left;
                } else
                    currentNode = currentNode.right;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        Node test = null, succ = null;

        //create binary search tree
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);
        succ = tree.getNodeByKey(9);

        System.out.println(tree.inOrderSuccessor(succ).key);
    }
}
