public class reverseWords {
    public static void main(String[] args) {
        String s1 = "the sky is blue";
        System.out.println(reverseWords(s1));
        String s2 = "  hello world  ";
        System.out.println(reverseWords(s2));
        String s3 = "a good   example";
        System.out.println(reverseWords(s3));

    }

    public static String reverseWords(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.去除多余空格，并翻转整个字符串
        sb = reverseString(sb, 0, sb.length() - 1);
        // 3.把每个单词翻转回来
        sb = reverseEachWord(sb);
        return sb.toString();
    }

    public static StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        // 去掉首尾空格
        while (s.charAt(start)==' '){
            start++;
        }
        while (s.charAt(end)==' '){
            end--;
        }
        // 添加字母并去掉多余空格
        StringBuilder sb = new StringBuilder();
        while(start <= end){
            char c = s.charAt(start);
            if(c != ' ' || sb.charAt(sb.length()-1) != ' '){
                sb.append(c);
            }

            start++;
        }
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public static StringBuilder reverseString(StringBuilder sb, int start, int end){
        while(start<end){ // 当start=end时，那个字母就在中间，不用翻转
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);

            start++;
            end--;
        }

        return sb;
    }

    private static StringBuilder reverseEachWord(StringBuilder sb){
        int start = 0;
        int end = 1;
        int len = sb.length();
        while(start < len){
            while(end < len && sb.charAt(end) != ' ' ){
                end++;
            }
            // 此时end在空格处
            sb = reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;

        }

        return sb;
    }
}
