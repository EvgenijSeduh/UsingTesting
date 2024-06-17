package lambda;

public class ParseInt {
    public static int parseFirstInt(String str){
        String resStr = "";
        for(int i = 0; i < str.length(); i++){
            if(Character.isDigit(str.charAt(i)))
                resStr+=str.charAt(i);
            else
                break;
        }
        return Integer.parseInt(resStr);
    }
}
