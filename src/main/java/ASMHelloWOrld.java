import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by wanghanyu on 2017/12/2.
 *
 * http://www.acyouzi.com/2016/12/09/java-asm/
 */
public class ASMHelloWOrld {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassReader cr = new ClassReader(getClassAllName());

        ClassWriter cw = new ClassWriter(cr, 0);

        ClassVisitor cv = new ClassAdapter(cw);

        cr.accept(cv, 0);

        byte[] b = cw.toByteArray();

        Class clazz = new SimpleClassLoader().loadClass(b);
        Constructor con = clazz.getConstructor();
        Object obj = con.newInstance();

        Method method = obj.getClass().getDeclaredMethod("toString");
        method.setAccessible(true);

        method.invoke(obj);
    }

    public static String getClassAllName() {
        return Runnable.class.getName();
    }
}
