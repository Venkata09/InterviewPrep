package MYPow_50;

public class MyPOW_1 {

/*
    I couldn't find a clear explanation for an interative Log(n) solution so here's mine. The basic idea is to decompose the exponent into powers of 2, so that you can keep dividing the problem in half. For example, lets say

            N = 9 = 2^3 + 2^0 = 1001 in binary. Then:

    x^9 = x^(2^3) * x^(2^0)

    We can see that every time we encounter a 1 in the binary representation of N, we need to multiply the answer with x^(2^i) where i is the ith bit of the exponent. Thus, we can keep a running total of repeatedly squaring x - (x, x^2, x^4, x^8, etc) and multiply it by the answer when we see a 1.

    To handle the case where N=INTEGER_MIN we use a long (64-bit) variable. Below is solution:
*/

    public class Solution {
        public double MyPow(double x, int n) {
            double ans = 1;
            long absN = Math.abs((long) n);
            while (absN > 0) {
                if ((absN & 1) == 1) ans *= x;
                absN >>= 1;
                x *= x;
            }
            return n < 0 ? 1 / ans : ans;
        }
    }



    /* This is a simple solution based on divide and conquer */

    public class Solution1RecurSive {
        public double pow(double x, int m) {
            double temp = x;
            if (m == 0) return 1;
            temp = pow(x, m / 2);
            if (m % 2 == 0) return temp * temp;
            else {
                if (m > 0) return x * temp * temp;
                else return (temp * temp) / x;
            }

        }
    }


    public double pow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double result = 1;
        for (double f = x; n > 0; n = n >> 1) {
            if (n % 2 == 1) {
                result *= f;
            }
            f = f * f;
        }
        return result;
    }

    class Solution2 {
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            double ans = 1;
            for (long i = 0; i < N; i++)
                ans = ans * x;
            return ans;
        }
    }


    class Solution33 {
        private double fastPow(double x, long n) {
            if (n == 0) {
                return 1.0;
            }
            double half = fastPow(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                return half * half * x;
            }
        }

        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }

            return fastPow(x, N);
        }
    }

    class Solution4 {
        public double myPow(double x, int n) {
            long N = n;
            if (N < 0) {
                x = 1 / x;
                N = -N;
            }
            double ans = 1;
            double current_product = x;
            for (long i = N; i > 0; i /= 2) {
                if ((i % 2) == 1) {
                    ans = ans * current_product;
                }
                current_product = current_product * current_product;
            }
            return ans;
        }
    }

}
