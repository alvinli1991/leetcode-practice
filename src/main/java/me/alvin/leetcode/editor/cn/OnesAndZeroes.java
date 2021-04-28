//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 动态规划 
// 👍 382 👎 0


package me.alvin.leetcode.editor.cn;

public class OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new OnesAndZeroes().new Solution();
        System.out.println(solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            //前N个中，当0为m，1为n时，最多的子集个数
            int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
            ItemCount[] itemCounts = trans(strs);
            for (int zeroCnt = 0; zeroCnt <= m; zeroCnt++) {
                for (int oneCnt = 0; oneCnt <= n; oneCnt++) {
                    //在有i个0，j个1时，对前k个字符串进行选择
                    for (int k = 1; k <= itemCounts.length; k++) {
                        ItemCount theItem = itemCounts[k - 1];
                        if (theItem.getZeroCount() > zeroCnt || theItem.getOneCount() > oneCnt) {
                            //无法选当前元素，则大小取决与前k-1
                            dp[k][zeroCnt][oneCnt] = dp[k - 1][zeroCnt][oneCnt];
                        } else {
                            dp[k][zeroCnt][oneCnt] = Math.max(
                                    dp[k - 1][zeroCnt][oneCnt], //不选此元素
                                    dp[k - 1][zeroCnt - theItem.getZeroCount()][oneCnt - theItem.getOneCount()] + 1 //选此元素
                            );
                        }

                    }
                }
            }
            return dp[strs.length][m][n];
        }

        public ItemCount[] trans(String[] strs) {
            ItemCount[] result = new ItemCount[strs.length];
            for (int i = 0; i < strs.length; i++) {
                String item = strs[i];
                ItemCount count = new ItemCount();
                for (int j = 0; j < item.length(); j++) {
                    if ('0' == item.charAt(j)) {
                        count.addZero();
                    } else {
                        count.addOne();
                    }
                }
                result[i] = count;
            }
            return result;
        }

    }

    class ItemCount {
        int zeroCount;
        int oneCount;

        public ItemCount() {
            this.zeroCount = 0;
            this.oneCount = 0;
        }

        public void addZero() {
            this.zeroCount++;
        }

        public void addOne() {
            this.oneCount++;
        }

        public int getZeroCount() {
            return zeroCount;
        }

        public int getOneCount() {
            return oneCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}