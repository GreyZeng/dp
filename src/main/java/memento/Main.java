package memento;

import java.io.*;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "zhangsan";
        person.age = 12;
        new Main().save(person);
        new Main().load();
    }

    public void save(Person person) {
        File c = new File("D:/git/tank.data");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(c));) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        File c = new File("D:/git/tank.data");
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream(c));) {

            Person myTank = (Person) oos.readObject();
            System.out.println(myTank);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

