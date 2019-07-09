import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();
        int n = in.nextInt();
        while(n > 0){
            list.add(in.next());
            n--;
        }
        Cal cal = new Cal(list);
        for (String s : cal.checkString()) {
            System.out.println(s);
        }
    }
}
