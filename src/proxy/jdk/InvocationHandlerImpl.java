package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author skyxt
 * Created 2019-07-01 00:39
 * Email skyxt.yang@gmail.com
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Person person;

    public InvocationHandlerImpl(Person person) {
        this.person = person;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("饭前洗手");
        Object invoke = method.invoke(person, args);
        System.out.println("the proxy class's method are : " + Arrays.toString(proxy.getClass().getDeclaredMethods()));
        System.out.println("饭后收拾");
        return invoke;
    }
}
