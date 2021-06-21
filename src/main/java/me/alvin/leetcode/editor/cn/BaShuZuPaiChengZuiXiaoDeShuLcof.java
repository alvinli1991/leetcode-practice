//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 228 👎 0


package me.alvin.leetcode.editor.cn;

import java.math.BigInteger;

public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        System.out.println(solution.minNumber(new int[]{10,2}));
        System.out.println("30".compareTo("3"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        BigInteger min;
        boolean[] visited ;
        int count = 0;
        String minPath;
        public String minNumber(int[] nums) {
            visited = new boolean[nums.length];
            min = null;
            minPath = "";
            backtrace("",nums);
            return minPath;
        }

        public void backtrace(String path,int[] choices){
            if(count == choices.length){
                if(null == min){
                    min = new BigInteger(path);
                    minPath = path;
                }else{
                    BigInteger newNum = new BigInteger(path);
                    if(newNum.compareTo(min) < 0){
                        minPath = path;
                        min = newNum;
                    }
                }
            }

            for(int i = 0;i<choices.length;i++){
                if(visited[i]){
                    continue;
                }
                visited[i] = true;
                count++;
                backtrace(path+choices[i],choices);
                visited[i] = false;
                count--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}