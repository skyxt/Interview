package proxy.jdk;

import proxy.ProxyUtils;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * @author skyxt
 * Created 2019-07-01 01:00
 * Email skyxt.yang@gmail.com
 */
public class Test {

    public static void main(String[] args) {
        Person person = new Person();
        ClassLoader loader = person.getClass().getClassLoader();
        Class[] interfaces = person.getClass().getInterfaces();
        InvocationHandlerImpl handler = new InvocationHandlerImpl(person);
        Object o = Proxy.newProxyInstance(loader, interfaces, handler);
        Human human = (Human) o;
        human.eat();
        String s = human.get("苹果");
        System.out.println("获取到接口：" + s);
        ProxyUtils.generateClassFile(human.getClass(), "PersonProxy");
    }
}
