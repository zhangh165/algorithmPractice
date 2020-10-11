package com.zhh1011.algorithmPractice.dataStructure;

import com.zhh1011.algorithmPractice.Util.TreeNode;

import java.util.Arrays;

public class SearchTree{
    private TreeNode root;

    public SearchTree(int data){
        root = new TreeNode(data);
    }

    public SearchTree(int[] array){
        root = new TreeNode();
        create(array);
    }

    public void insert(int data){
        insert(root,data);
    }

    private void insert(TreeNode nextNode,int data){
        if(data < nextNode.val){
            if (nextNode.left == null){
                nextNode.left=new TreeNode(data);
            }else {
                insert(nextNode.left,data);
            }
        }else {
            if (nextNode.right == null){
                nextNode.right=new TreeNode(data);
            }else {
                insert(nextNode.right,data);
            }
        }
    }

    public boolean search(int data){
        return search(root,data);
    }

    private boolean search(TreeNode nextNode,int data){
        if(data == nextNode.val){
            return true;
        }

        if(data < nextNode.val){
            if (nextNode.left == null){
                return false;
            }else {
                return search(nextNode.left,data);
            }
        }else {
            if (nextNode.right == null){
                return false;
            }else {
                return search(nextNode.right,data);
            }
        }
    }

    public boolean delete(int data){
        TreeNode curNode = delSearch(root,data);

        if(null == curNode){
            return false;
        }else {
            TreeNode indeedNode = delete(curNode);
            if(indeedNode == curNode){
                curNode.val = 0;
                return true;
            }else {
                curNode.val=indeedNode.val;
                indeedNode.val = 0;
                return true;
            }
        }
    }

    private TreeNode delete(TreeNode nextNode){
        if(nextNode.left != null){
            while (nextNode.right != null){
                nextNode = nextNode.right;
            }
            return nextNode;
        }else if(nextNode.right != null){
            while (nextNode.left != null){
                nextNode = nextNode.left;
            }
            return nextNode;
        }else {
            return null;
        }
    }

    private TreeNode delSearch(TreeNode nextNode,int data) {
        if (data == nextNode.val) {
            return nextNode;
        }

        if (data < nextNode.val) {
            if (nextNode.left == null) {
                return null;
            } else {
                return delSearch(nextNode.left, data);
            }
        } else {
            if (nextNode.right == null) {
                return null;
            } else {
                return delSearch(nextNode.right, data);
            }
        }
    }

    public void create(int[] array){
        root.val = array[0];

        array = Arrays.copyOfRange(array,1,array.length);

        for (int a:
             array) {
            insert(a);
        }
    }

    private String perOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        perOrder(stringBuffer,root);
        return stringBuffer.toString();
    }

    private void perOrder(StringBuffer stringBuffer,TreeNode nextNode){
        if(null == nextNode){
            return;
        }
        stringBuffer.append(nextNode.val);
        perOrder(stringBuffer,nextNode.left);
        perOrder(stringBuffer,nextNode.right);
    }

    private String inOrder(){
        StringBuffer stringBuffer = new StringBuffer();
        inOrder(stringBuffer,root);
        return stringBuffer.toString();
    }

    private void inOrder(StringBuffer stringBuffer,TreeNode nextNode){
        if(null == nextNode){
            return;
        }
        inOrder(stringBuffer,nextNode.left);
        stringBuffer.append(nextNode.val);
        inOrder(stringBuffer,nextNode.right);
    }

    public TreeNode getRoot() {
        return root;
    }

    public static void main(String[] args){
        int[] array = new int[]{5,2,4,8,3,7,9,6,1};
        SearchTree searchTree = new SearchTree(array);
        System.out.println(searchTree.inOrder());
        System.out.println(searchTree.perOrder());
//        System.out.println(searchTree.search(1));
//        searchTree.delete(5);
//        System.out.println(searchTree.inOrder());

    }

}
