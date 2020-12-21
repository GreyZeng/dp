package builder;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder().basicInfo("zhangsan", 10).address("xxx").build();
        System.out.println(person);
    }
}
