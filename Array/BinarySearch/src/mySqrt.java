public class mySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt(int x) {
        // int left = 1; // 错误！！！
        int left = 0;
        int right = x;

        if(x == 0 || x == 1){
            return x;
        }

        // 陷入死循环我也不知道为什么...
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if ((long)mid * mid > x) {
//                right = mid + 1;
//            }
//            if((long)mid * mid < x) {
//                left = mid - 1;
//            }
//            if((long)mid * mid == x){
//                return mid;
//            }
//        }

        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long)mid * mid > x) {
                right = mid - 1;
            }
            else if((long)mid * mid < x) {
                ans = mid;
                left = mid + 1;
            }
            else if((long)mid * mid == x){
                return mid;
            }
        }

        return ans;

    }
}
