package adapter;

import java.util.Enumeration;
import java.util.Vector;

public class TestEnumeration {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.addElement("Lisa");
        v.addElement("Billy");
        v.addElement("Mr Brown");
        Enumeration<String> e = v.elements();// 返回Enumeration对象
        while (e.hasMoreElements()) {
            String value = (String) e.nextElement();// 调用nextElement方法获得元素
            System.out.print(value);
        }
    }
}
