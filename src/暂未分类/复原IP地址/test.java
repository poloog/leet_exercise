package 暂未分类.复原IP地址;

import java.util.List;

public class test {
    public static void main(String[] args) {
        RestoreIpAddresses test = new RestoreIpAddresses();
        String s = "0279245587303";
        List<String> res = test.restoreIpAddresses(s);
        System.out.println(res);
    }
}
