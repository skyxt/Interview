package proxy.jdk;

/**
 * @author skyxt
 * Created 2019-06-30 22:51
 * Email skyxt.yang@gmail.com
 */
public class Person implements Human {

    @Override
    public void eat() {
        System.out.println("吃吃吃，毛起吃");
    }

    @Override
    public String get(String object) {
        System.out.println("get " + object);
        return "get " + object;
    }
}
