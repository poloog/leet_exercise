package 字符串.字符串的排列;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int len_s1 = s1.length();
        int len_s2 = s2.length();

        if (len_s1 > len_s2) {  // 如果子串比主串长，直接返回false
            return false;
        }

        int[] count = new int[26];  // 定义一个存储差别的数组
        for (int i = 0; i < len_s1; i++) {  // 先初始化第一个子串长度
            count[s1.charAt(i) - 'a']--;  // 子串在字母表中的字母，用 -1 表示。
            count[s2.charAt(i) - 'a']++;
        }

        // 先统计第一个s1长度的的不同字符数量
        int diff = 0;
        for (int j = 0; j < 26; j++) {
            if (count[j] != 0) {
                diff++;
            }
        }

        // 如果第一次就有相同字符，直接返回
        if (diff == 0) {
            return true;
        }

        // 窗口向后滑。固定窗口
        for (int k = len_s1; k < len_s2; k++) {
            int left = s2.charAt(k-len_s1) - 'a'; // 窗口刚滑出去的字符
            int right = s2.charAt(k) - 'a';  // 窗口刚滑进来的字符

            // 如果滑出去和滑进来的字符一样，相当于和上个窗口一样，就继续循环
            if (left == right) {
                continue;
            }

            // 如果刚滑进来的字符，在字母表中是0，表示不在s1中，那么当前窗口内就有一个不属于s1的字符，diff要加1
            if (count[right] == 0) {
                diff++;
            }

            // 只要滑进来，就给该字母在表上加1
            count[right]++;

            // 刚滑进来的字符，已经在表中加1了，如果加1后，值为0，说明该字符是s1的字符，diff-1
            if (count[right] == 0) {
                diff--;
            }

            // 刚滑走的字符， 如果在表中为0，表示窗口中一个属于s1的字符出去了
            // （如果该字符不属于s1，值应该大于1，因为每次滑进来都在表中加1）
            // 所以窗口中少了一个s1中的字符，diff+1  和上面的diff--是对称的操作
            if (count[left] == 0) {
                diff++;
            }

            // 出去的字符都要在表中减去
            count[left]--;

            // 一个字符滑出去了，表要减一，如果减一后为0，说明不是s1中的字符，正常的diff-1，和上面的刚滑进来diff+1是对称的操作
            if (count[left] == 0) {
                diff--;
            }

            if (diff == 0) {
                return true;
            }
        }
        return false;
    }
}
