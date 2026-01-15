package rufeii.code;

import java.io.IOException;

public class Person implements java.io.Serializable {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeObject("whoami");
    }

    @Override
    public String toString(){
        return "触发成功";
    }

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        String message = (String) s.readObject();
        System.out.println(message);
        //Person p1 = (Person) s.readObject();
        //System.out.println(p1);
    }
}