import Task.LengthStringNoDuplicates;
import Task.Palindrome;

public class Main {
    public static void main(String[] args) {
        int[] a ={1,2,3,4,5,6,7,8,9,0,7};
        String s = "выфвф";
        System.out.println(LengthStringNoDuplicates.lengthOfLongestSubstring(s));
        //System.out.println(ContainsDuplicate.containsDuplicate(a));
        System.out.println(Palindrome.isPalindromeString2("A man, a plan, a canal: Panama"));
        }

    }