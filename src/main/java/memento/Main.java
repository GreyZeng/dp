package memento;

import java.io.*;
import java.nio.file.Files;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {
    private final static String FILE_PATH= "C:\\workspace\\tank.data";
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "zhangsan";
        person.age = 12;
        new Main().save(person);
        new Main().load();
    }

    public void save(Person person) {
        File c = new File(FILE_PATH);
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(c.toPath()));) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        File c = new File(FILE_PATH);
        try (ObjectInputStream oos = new ObjectInputStream(Files.newInputStream(c.toPath()));) {

            Person myTank = (Person) oos.readObject();
            System.out.println(myTank);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

