public class Solution {
    public String replaceBlank(StringBuffer str){
        int blacklength=0;
        int originlength=0;
        int newlength=0;
        int indexOfOriginal=0;
        int indexOfnew=0;
        String scaleString = "";
        originlength = str.length();
        for(int i=0; i<originlength; i++){
            if(str.charAt(i) == ' '){
                blacklength++;
                scaleString += " ";
            }
        }

        newlength = originlength + 2*blacklength;
        indexOfnew = newlength;
        indexOfOriginal = originlength;
        str.append(scaleString);
        //开始替换
        return null;
    }
}
