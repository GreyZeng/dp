package builder;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class Person {

    private String name;
    private int age;
    private String address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    private Person() {
    }

    public static class PersonBuilder {
        private Person person = new Person();

        public PersonBuilder basicInfo(String name, int age) {
            person.name = name;
            person.age = age;
            return this;
        }

        public PersonBuilder name(String name) {
            person.name = name;
            return this;
        }

        public PersonBuilder age(int age) {
            person.age = age;
            return this;
        }

        public PersonBuilder address(String address) {
            person.address = address;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }


}
