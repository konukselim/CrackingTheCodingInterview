package Chapter5_BitManipulation;

/**
 * Created by selimkonuk on 26/11/2017.
 */
public class CommonBitTasks {

    public static int xnor(int m, int n) {
        return ~(m ^ n);
    }

    /*
    This function shifts 1 to the left i times then performs an and with the number.
    If desired bit is 0, function will return False, if 1 it will return True
     */
    public static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    /*
    This function shifts 1 to the left i times then performs an or with the number.
    With this way desired bit will set to 1
     */
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    /*
    This function shifts 1 to the left i times then negate it to create bit series that is
    the i'th bit is 0 while others are 1. Then perform an and with the number. With this way
    desired bit will set to 0
     */
    public static int clearBit(int num, int i) {
        return (num & (~(1 << i)));
    }
}
