//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 124 👎 0


package me.alvin.leetcode.editor.cn;
public class TiHuanKongGeLcof{
      public static void main(String[] args) {
           Solution solution = new TiHuanKongGeLcof().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        int oldLength = s.length();
        int blankCount = 0;
        for(int i=0;i<oldLength;i++){
            if(s.charAt(i) == ' '){
                blankCount++;
            }
        }
        if(0 == blankCount){
            return s;
        }
        char[] newStr = new char[oldLength+blankCount*2];
        int newIndex = newStr.length - 1;
        for(int i= oldLength -1; i >= 0 ; i--){
            char holder =  s.charAt(i);
            if(s.charAt(i) != ' '){
                newStr[newIndex--] = holder;
            }else{
                newStr[newIndex--] = '0';
                newStr[newIndex--] = '2';
                newStr[newIndex--] = '%';
            }
        }
        return new String(newStr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }