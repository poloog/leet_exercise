package 暂未分类.复原IP地址;

import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        String ip = "";
        String cur = "";
        process(ip, cur, 0, 0, s);
        return res;
    }

    public void process(String ip, String cur, int point_num, int index, String s) {
        if (index >= s.length()) return;
        if (point_num == 3) {
            if (isValid(s.substring(index, s.length()))) {
                res.add(ip+s.substring(index,s.length()));
                return;
            } else return;
        }

        cur = cur + s.charAt(index);
        if (isValid(cur)) {
            index++;
            process(ip, cur, point_num, index, s);
            process(ip+cur+'.', "", point_num+1, index, s);
        }

    }

    public boolean isValid(String str) {
        if (str.charAt(0)=='0' && str.length()>1 || str.length() > 3) {
            return false;
        }
        int t = Integer.parseInt(str);
        if (t >= 0 && t <= 255) {
            return true;
        } else {
            return false;
        }
    }
}
