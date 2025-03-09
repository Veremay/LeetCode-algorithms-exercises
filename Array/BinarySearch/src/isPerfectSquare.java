/**
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 *
 * 不能使用任何内置的库函数，如  sqrt
 */

public class isPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(144));
    }

    public static boolean isPerfectSquare(int num){
        int left = 0;
        int right = num;

        if(num == 1){
            return true;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if ((long)mid * mid > num) {
                right = mid - 1;
            }
            else if((long)mid * mid < num) {
                left = mid + 1;
            }
            else if((long)mid * mid == num){
                return true;
            }
        }

        return false;
    }
}
