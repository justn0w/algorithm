
import java.util.ArrayList;

public class Cal {
    ArrayList<String> input;

    public Cal(ArrayList<String> input) {
        this.input = input;
    }

    public int findLocation(String str, char n) {
        int loc = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == n) {
                loc = i;
            }
        }
        return loc;
    }

    public ArrayList<String> checkString() {

        int posA;
        int posP;
        int posT;
        int flag = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (String s : input) {
            //满足条件一
            if (s.equals("PAT")) {
                list.add("YES");
                continue;
            }
            //出现非PAT的元素
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != 'A' && s.charAt(i) != 'P' && s.charAt(i) != 'T') {
                    flag = 1;//说明出现非PAT元素
                    list.add("NO");
                    break;
                }
            }
            if (flag == 1) {
                flag = 0;
                continue;
            }
            if (findLocation(s, 'T') - findLocation(s, 'P') == 1) {
                list.add("NO");
                continue;
            }
            //
            if (findLocation(s, 'A') >= 0 && findLocation(s, 'P') >= 0 && findLocation(s, 'T') >= 0) {
                posP = findLocation(s, 'P');
                posT = findLocation(s, 'T');
                if (posP > posT) {
                    //如果p在T后或者以P开头
                    list.add("NO");
                    continue;
                }
                if (posP == 0 && (posT - posP) > 1) {
                    list.add("YES");
                    continue;
                }
                if (posP * (posT - posP - 1) == (s.length() - 1 - posT)) {
                    list.add("YES");
                } else {
                    list.add("NO");
                }
            }
        }
        return list;
    }
}

