package applications.recursionpractice;

public class ReverseString {

    // https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/

    // This one uses another array
    public char[] reverseString(char[] s){
        int len = s.length;
        char[] temp = new char[len];
        int count = 0;
        for (int i = len-1; i >= 0 ; i--) {
            temp[count] = s[i];
            count++;
        }
        return temp;
    }

    // TODO: This is a basic one, come back to study this
    public char[] reverseSameStrings(char[] s){
        int len = s.length;
        for (int i = 0; i < len / 2 ; i++) {
            char ch = s[i];
            s[i] = s[len - i -1];
            s[len - i - 1] = ch;
        }
        return s;
    }
}
