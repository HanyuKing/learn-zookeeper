import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ClassAdapter extends ClassVisitor {
    public ClassAdapter(ClassWriter cw) {
        super(Opcodes.ASM5, cw);
    }
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if("xxx".equals(name)){
            return null;
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}
