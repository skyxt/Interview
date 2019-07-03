package machinetest.probability;

import javax.sound.midi.SysexMessage;
import java.util.Random;

/**
 * 有一个随机数发生器，以概率P产生0，概率(1-P)产生1，请问能否利用这个随机数发生器，构造出新的发生器，以1/2的概率产生0和1。请写明结论及推理过程。
 * @author skyxt
 * Created 2019-07-03 10:05
 * Email skyxt.yang@gmail.com
 */
public class Probability {

    public static void main(String[] args) {
        //1出现的次数
        int count1 = 1;
        //0出现的次数
        int count0 = 0;
        for(int i = 0; i < 10000; i++) {
            int data = println(rand(), rand());
            if (1 == data) {
                ++count1;
            } else if (0 == data) {
                ++count0;
            }
            System.out.println(data);
        }
        System.out.println("count0:" + count0);
        System.out.println("count1:" + count1);
    }

    static int rand() {
        float probabilityA = 0.9f;
        float probabilityB = 0.1f;
        if (new Random().nextInt() < probabilityA * 10) {
            return 1;
        } else {
            return 0;
        }
    }

    static int println(int i, int j) {
        if(i ==1 && j == 0) {
            return i;
        } else if (i == 0 && j ==1) {
            return i;
        } else {
            return println(rand(), rand());
        }
    }
}
