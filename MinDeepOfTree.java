package com.chen.alg;

import java.util.ArrayList;

public class MinDeepOfTree {
    public int run(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);

        return run(list);
    }

    private int run(ArrayList<TreeNode> list) {
        int res = 1;
        ArrayList<TreeNode> tempList = getSonNodes(list);
        if(tempList != null){
            res += run(tempList);
        }

        return res;
    }

    private ArrayList<TreeNode> getSonNodes(ArrayList<TreeNode> list){
        ArrayList<TreeNode> tempList = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            TreeNode node = list.get(i);
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left==null && right==null){
                return null;
            }
            if(left != null){
                tempList.add(left);
            }
            if(right != null){
                tempList.add(right);
            }
        }

        return tempList;
    }
}
