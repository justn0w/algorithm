import java.util.Scanner;

/**
 * 这题主要难在题目的解读，如果将题目读懂这题就不是很难，这里我把题目作简单的分析。

 1、对于第一个条件，我们可以知道所输入字符串只能包括P,A,T三个字母，我们可以根据设置3个变量来统计这3个字母的数量如果3个字母数量之和不等于字符串长度那就有可能包含其它字母。

 2、条件2告诉我们的是在PAT左右两边的字符必须相等或为空或为A字符

 3、条件3是比较好理解的，意思就是说P，T之间如果增加一个字符A那么在T的右边就要添加与P左边相等的字符，这个字符的数量要根据P左边的字符来定。
 */
public class PAT_B_1003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str[] = new String[n];
        for(int i=0; i<n; i++){
            str[i] = scanner.next();
        }
        for(int i=0; i<n; i++){
            System.out.println(StrTrueOrFalse(str[i]));
        }
    }

    public static String StrTrueOrFalse(String s){
        int NumA=0,NumP=0,NumT=0;
        int PosP=0,PosT=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='A'){
                NumA++;
            }
            if(s.charAt(i)=='P'){
                NumP++;
                PosP=i;
            }
            if(s.charAt(i)=='T'){
                NumT++;
                PosT=i;
            }
        }
        if(NumA+NumP+NumT==s.length() && NumA!=0 && NumP==1 && NumT==1 && PosT-PosP>1 && PosP*(PosT-PosP-1)==s.length()-PosT-1 ){
            return "YES";
        }else {
            return "NO";
        }
    }
}