import com.sun.xml.internal.ws.org.objectweb.asm.*;

/**
 * Created by wanghanyu on 2017/12/2.
 */
public class ClassPrinter implements ClassVisitor {
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        System.out.println(s + " extends " + s2 + " {");
    }

    public void visitSource(String s, String s1) {
        System.out.println(s + " extends "  + " {");
    }

    public void visitOuterClass(String s, String s1, String s2) {
        System.out.println(s + " extends " + s2 + " {");
    }

    public AnnotationVisitor visitAnnotation(String s, boolean b) {
        System.out.println(s + " extends "  + " {");
        return null;
    }

    public void visitAttribute(Attribute attribute) {
        System.out.println(1);
    }

    public void visitInnerClass(String s, String s1, String s2, int i) {
        System.out.println(11);
    }

    public FieldVisitor visitField(int i, String s, String s1, String s2, Object o) {
        System.out.println(111);
        return null;
    }

    public MethodVisitor visitMethod(int i, String s, String s1, String s2, String[] strings) {
        System.out.println(12);
        return null;
    }

    public void visitEnd() {
        System.out.println(123);
    }
}
