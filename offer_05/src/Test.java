/**
 *用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能
 *思路：用两个栈，数据先进入第一个队列然后弹出，将弹出的元素内容按照顺序放入到第二个队列，来模拟队列
 *
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        int head = solution.pop();
        System.out.println(head);
    }
}

