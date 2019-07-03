package proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author skyxt
 * Created 2019-07-01 02:33
 * Email skyxt.yang@gmail.com
 */
public class ProxyUtils {

    public static void generateClassFile(Class clazz, String proxyName) {
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String paths = System.getProperty("user.dir") + System.getProperty("file.separator") + "proxy";
        System.out.println(paths);
        try(FileOutputStream out = new FileOutputStream(paths + System.getProperty("file.separator") + proxyName + ".class")) {
            out.write(classFile);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
