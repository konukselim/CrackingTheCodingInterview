package Chapter5_BitManipulation;

/**
 * Created by selimkonuk on 26/11/2017.
 */
public class Questions {

    /*
    Question 1: Create a hole with 0's between the indices i and j on n.
    Shift m to the left by i. Perform or operation on masked n with
    shifted m.
     */
    public int insertion(int n, int m, int i, int j) {
        int shifted_n_i = ( 1 << i ) - 1;
        int shifted_n_j = ( -1 << j +1 );

        int mask = shifted_n_i | shifted_n_j;

        int n_masked = n & mask;
        int m_shifted = m << i;

        return n_masked | m_shifted;
    }

    /*
    Question 2: Start with 0.5 check if input double bigger than it or not.
    If bigger or equal add 1 to the binary string else add 0. In each iteration,
    control the double input completely represented by checking it's value with 0.
     */
    public String binaryToString(double n) {
        if (n < 0 || n > 1) {
            return "ERROR";
        }

        StringBuilder bin_repr = new StringBuilder();
        int counter = 0;
        double frac = 0.5;
        while (counter < 32) {
            if (n == 0) {
                fillTo32Bit(bin_repr, counter);
                return bin_repr.toString();
            }
            if (n >= frac) {
                n -= frac;
                bin_repr.append(1);
            }
            else {
                bin_repr.append(0);
            }
            frac /= 2;
            counter++;
        }

        return "ERROR";
    }

    private void fillTo32Bit(StringBuilder bin_repr, int counter) {
        while (counter < 32) {
            bin_repr.append(0);
            counter ++;
        }
    }

    /*
    Question 3: Find the one series, if a zero come up compare current length + current max
    + flipped0 with max length. If max length bigger just ignore, else change it. Do it until
    right logical shifted n equals to 0. For the case where the most significant bit is 0,
    do the same check after loop ends.
     */
    public int flipBitToWin(int n) {
        if (n == -1)
            return Integer.BYTES * 8;

        int curr_len = 0;
        int curr_max = 0;
        int max_len = 1;

        while (n != 0) {
            if ((n & 1) == 1) {
                curr_len++;
            }
            else {
                max_len = (max_len > curr_max + curr_len + 1) ? max_len : curr_max + curr_len + 1;
                curr_max = curr_len;
                curr_len = 0;
            }

            n = (n >>> 1);
        }
        max_len = (max_len > curr_max + curr_len + 1) ? max_len : curr_max + curr_len + 1;

        return max_len;
    }

    /*
    Question 5: (n & (n-1)) == 0   => What does this code do?
    Think about bits. If you perform an and operation on two integers, you will get 0
    only when all the same indiced bits are different in two integers. So now think about
    the question. There is an and operation on an integer and its minus one. This happens
    only we have one 1 bit in our binary representation. Because, when we subtract 1 from
    an integer right most 1 bit will set to 0 and the bits right of it will set to 1.
    (e.g) let n be XYZ1000 where XYZ are random bits. Then n-1 will be XYZ0111.
          If we perform an and operation we will get XYZ0000. Hence, we can easily say
          that if XYZ bits are all 0 then we will get 0. The code checks if we have one
          1 bit in n's binary representation or not. Of course also, there is an edge case
          where n = 0. As a result, the code checks whether we have one or zero 1 bit or not.
     (In the book author says the code checks whether n is a power of 2 or not. Also if it is zero)
     */

    /*
    Question 8:
     */
    public void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int yStarting = (screen.length * 8) / width;
        int xStarting = yStarting + (x1 / 8);
        int xEnding = yStarting + (x2 / 8);

        for (int i=xStarting+1; i < xEnding ;i++) {
            screen[i] = (byte) 0xFF;
        }

        byte sMask = (byte) (0xFF >>> (x1 % 8));
        byte eMask = (byte) (0xFF << 7 - (x2 % 8));

        if (xStarting == xEnding) {
            screen[xStarting] = (byte) (sMask & eMask);
        }
        else {
            screen[xStarting] = sMask;
            screen[xEnding] = eMask;
        }

    }
}
