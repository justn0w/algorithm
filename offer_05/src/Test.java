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

