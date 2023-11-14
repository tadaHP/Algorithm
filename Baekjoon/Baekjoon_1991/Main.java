package Baekjoon.Baekjoon_1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static Node startNode = new Node("A", null, null);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());


        for (int i = 0; i < size; i++) {
            String[] split = br.readLine().split(" ");
            insertNode(startNode,split[0], split[1], split[2]);
        }

        System.out.println(preorder(startNode));
        System.out.println(inorder(startNode));
        System.out.println(postorder(startNode));
    }

    private static String preorder(Node visit) {
        String valueNow = visit.value;
        String left = "";
        String right = "";

        if (visit.left != null) {
            left = preorder(visit.left);
        }
        if (visit.right != null) {
            right = preorder(visit.right);
        }
        return valueNow + left + right;
    }

    private static String inorder(Node visit) {
        String valueNow = visit.value;
        String left = "";
        String right = "";

        if (visit.left != null) {
            left = inorder(visit.left);
        }
        if (visit.right != null) {
            right = inorder(visit.right);
        }
        return left + valueNow + right;
    }

    private static String postorder(Node visit) {
        String valueNow = visit.value;
        String left = "";
        String right = "";

        if (visit.left != null) {
            left = postorder(visit.left);
        }
        if (visit.right != null) {
            right = postorder(visit.right);
        }

        return left + right + valueNow;
    }

    private static void insertNode(Node visit, String target, String left, String right) {
        if (visit.value.equals(target)) {//
            if (!left.equals(".")) {
                visit.left = new Node(left, null, null);
            }
            if (!right.equals(".")) {
                visit.right = new Node(right, null, null);
            }
        } else {
            if (visit.left != null) {
                insertNode(visit.left, target, left, right);
            }
            if (visit.right != null) {
                insertNode(visit.right, target, left, right);
            }
        }
    }


    private static class Node {
        private String value;
        private Node left;
        private Node right;
        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
