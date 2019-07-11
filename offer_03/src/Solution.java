import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){


        /*
        方法一：使用两个数组实现
        ArrayList<Integer> arrayOld = new ArrayList<>();
        ArrayList<Integer> arrayNew = new ArrayList<>();
        int length=0;
        if(listNode == null){
            return arrayOld;
        };
        while(listNode !=null ){
            arrayOld.add(listNode.val);
            length++;
            listNode = listNode.next;
        }

        for(int i=length-1; i>=0; i--){
            arrayNew.add(arrayOld.remove(i));
        }

        return arrayNew;
        */

        //方法二：使用堆栈的方法
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayNew = new ArrayList<>();
        while(!stack.isEmpty()){
            arrayNew.add(stack.pop());
        }
        return arrayNew;
    }
}


