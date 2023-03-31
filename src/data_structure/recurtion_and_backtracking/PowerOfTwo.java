package data_structure.recurtion_and_backtracking;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(6));
        System.out.println(isPowerOfTwo(2147483647));
        System.out.println(isPowerOfTwo(-2147483647));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n < 0) {
            n = -n;
        }
        return checking(n);
    }

    public static boolean checking(int n) {
        if (n > 0) {
            if (n % 2 == 0) {
                return true;
            }
        } else {
            return checking(n / 2);
        }
        return false;
    }
}
