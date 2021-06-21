//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 442 👎 0


package me.alvin.leetcode.editor.cn;

public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] temp;
        int[] holder;

        public int reversePairs(int[] nums) {
            this.holder = nums;
            temp = new int[nums.length];
            return mergeSort(0, nums.length - 1);
        }

        /**
         * 对区间 [left,right] 进行排序
         *
         * @param left
         * @param right
         * @return
         */
        public int mergeSort(int left, int right) {
            //子数组长度为1
            if (left >= right) {
                return 0;
            }
            //划分
            int mid = left + (right - left) / 2;
            int result = mergeSort(left, mid) + mergeSort(mid + 1, right);
            //合并
            int i = left;
            int j = mid + 1;
            //将holder[lo..hi]复制到temp[lo..hi]
            for (int k = left; k <= right; k++) {
                temp[k] = holder[k];
            }
            //归并到holder中
            for (int k = left; k <= right; k++) {
                if (i > mid) {//左半边用尽(取右半边元素)
                    holder[k] = temp[j++];
                } else if (j > right) { //右半边用尽(取左半边元素)
                    holder[k] = temp[i++];
                } else if (temp[i] <= temp[j]) {//左边元素小于等于右边元素，取左边元素
                    holder[k] = temp[i++];
                }else{ //左边元素大于等于右边元素，取右边元素；计算逆序对个数
                    holder[k] = temp[j++];
                    result += mid-i+1;//逆序对，左边比右边多的数字
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}