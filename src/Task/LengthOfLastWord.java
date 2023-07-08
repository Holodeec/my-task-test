package Task;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] text = s.split(" ");
        int leng = text[text.length-1].length();
//        for (int i = 0; i < text.length; i++) {
//            if(text[i].length() > leng) {
//                leng = text[i].length();
//            }
//        }
        return leng;
    }
}
