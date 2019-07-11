import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*
题目描述
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
先入栈，再出栈，然后就可以倒序插入到一个ArrayList中
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode now = null;
        StringBuffer input = new StringBuffer(in.next());
        input.deleteCharAt(input.length()-1);
        input.deleteCharAt(0);
        String[] s = input.toString().split(",");
        for (String s1 : s) {
            if(now == null) {
                ListNode listNode = new ListNode(Integer.parseInt(s1));
                head = listNode;
                now = listNode;
            }else{
                ListNode listNode = new ListNode(Integer.parseInt(s1));
                now.next = listNode;
                now = listNode;
            }
        }
//        String input = in.next();
//        input.replaceAll(",", "");
//        input.replaceAll("}", "");
        Solution solution = new Solution();
        System.out.println(solution.printListFromTailToHead(head).toString());
    }
}
