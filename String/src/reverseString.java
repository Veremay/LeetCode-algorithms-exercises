public class reverseString {
    public static void main(String[] args) {
char[] s = new char[]{'h', 'e', 'l', 'l', 'o', '!'};
        System.out.println(reverseString(s));
    }

    public static char[] reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

        return s;
    }
}
