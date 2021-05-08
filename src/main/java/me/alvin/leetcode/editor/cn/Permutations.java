//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1333 👎 0


package me.alvin.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result;
        public List<List<Integer>> permute(int[] nums) {
            result = new ArrayList<>();
            List<Integer> track = new ArrayList<>();
            backtrack(nums,track);
            return result;
        }


        public void backtrack(int[] nums, List<Integer> track) {
            if(track.size() == nums.length){
                result.add(new ArrayList<>(track));
            }
            for (int i = 0; i < nums.length; i++) {
                int theNum = nums[i];
                if(track.contains(theNum)){
                    continue;
                }
                track.add(theNum);
                backtrack(nums,track);
                track.remove((Integer) theNum);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}