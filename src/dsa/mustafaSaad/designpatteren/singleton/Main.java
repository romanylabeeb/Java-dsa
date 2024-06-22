package dsa.mustafaSaad.designpatteren.singleton;

import java.io.*;

class Singleton implements Serializable {
    private static Singleton instance;

    private Singleton() {
    }

    // global access
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }
}

public class Main {
    //
    public static void main(String[] args) throws Exception {
        Singleton instance1 = Singleton.getInstance();
        // serialize
//        writes primitive data types and graphs of Java objects to an OutputStream
        ObjectOutputStream out = new ObjectOutputStream(
                //Creates a file output stream to write to the file with the specified name
                new FileOutputStream("single.ser"));
        out.writeObject(instance1);
        out.close();

        // deserialize
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("single.ser"));
        Singleton instance2 = (Singleton) in.readObject();
        in.close();

        System.out.println("inst1 hashcode:" + instance1.hashCode());
        System.out.println("inst2 hashcode:" + instance2.hashCode());
        System.out.println("inst1=inst2?" + instance1.equals(instance2));
    }

}
