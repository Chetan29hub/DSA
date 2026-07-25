class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to positive long
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long quotient = 0;

        while (dvd >= dvs) {

            int shift = 0;

            // Find largest shifted divisor
            while (dvd >= (dvs << (shift + 1))) {
                shift++;
            }

            quotient += (1L << shift);
            dvd -= (dvs << shift);
        }

        if (negative)
            quotient = -quotient;

        return (int) quotient;
    }
}