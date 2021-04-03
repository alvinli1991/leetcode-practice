package me.alvin.leetcode.editor.cn;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author Alvin Li
 * @since 2021/4/2 18:36
 */
public class HouseRobberIiiTest {

    @Test
    public void test1(){
        HouseRobberIii.Solution solution = new HouseRobberIii().new Solution();

        HouseRobberIii.TreeNode node3_t = new HouseRobberIii.TreeNode(3);
        HouseRobberIii.TreeNode node2_l = new HouseRobberIii.TreeNode(2);
        HouseRobberIii.TreeNode node3_r = new HouseRobberIii.TreeNode(3);
        HouseRobberIii.TreeNode node3_lr = new HouseRobberIii.TreeNode(3);
        HouseRobberIii.TreeNode node1_r = new HouseRobberIii.TreeNode(1);
        node3_t.left = node2_l;
        node3_t.right = node3_r;
        node2_l.right = node3_lr;
        node3_r.right = node1_r;
        System.out.println(solution.rob(node3_t));
        assertThat(solution.rob(node3_t),equalTo(7));
    }

    @Test
    public void test2(){
        HouseRobberIii.Solution solution = new HouseRobberIii().new Solution();
        HouseRobberIii.TreeNode node3_t = new HouseRobberIii.TreeNode(3);
        HouseRobberIii.TreeNode node4_l = new HouseRobberIii.TreeNode(4);
        HouseRobberIii.TreeNode node5_r = new HouseRobberIii.TreeNode(5);
        HouseRobberIii.TreeNode node1_l = new HouseRobberIii.TreeNode(1);
        HouseRobberIii.TreeNode node3_lr = new HouseRobberIii.TreeNode(3);
        HouseRobberIii.TreeNode node1_r = new HouseRobberIii.TreeNode(1);
        node3_t.left = node4_l;
        node3_t.right = node5_r;
        node4_l.left = node1_l;
        node4_l.right = node3_lr;
        node5_r.right = node1_r;
        System.out.println(solution.rob(node3_t));
        assertThat(solution.rob(node3_t),equalTo(9));
    }

    @Test
    public void test3(){
        HouseRobberIii.Solution solution = new HouseRobberIii().new Solution();
        HouseRobberIii.TreeNode node1 = new HouseRobberIii.TreeNode(1);
        HouseRobberIii.TreeNode node2 = new HouseRobberIii.TreeNode(2);
        HouseRobberIii.TreeNode node3 = new HouseRobberIii.TreeNode(3);
        node1.left = node2;
        node1.right  = node3;
        System.out.println(solution.rob(node1));

    }

    @Test
    public void test4(){
        HouseRobberIii.Solution solution = new HouseRobberIii().new Solution();
        HouseRobberIii.TreeNode node4 = new HouseRobberIii.TreeNode(4);
        HouseRobberIii.TreeNode node1 = new HouseRobberIii.TreeNode(1);
        HouseRobberIii.TreeNode node2 = new HouseRobberIii.TreeNode(2);
        HouseRobberIii.TreeNode node3 = new HouseRobberIii.TreeNode(3);
        node4.left = node1;
        node1.left  = node2;
        node2.left = node3;
        System.out.println(solution.rob(node4));

    }
}