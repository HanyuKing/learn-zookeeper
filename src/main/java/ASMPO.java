/**
 * Created by wanghanyu on 2017/12/2.
 */
public class ASMPO {
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void log() {
        System.out.println("log...");
    }
}
