package decorator;

import java.io.*;

// 装饰器模式在jdk中的一个应用
public class IOMain {
    public static void main(String[] args) {
        File f = new File("D:/1.txt");
        try (
                FileOutputStream fos = new FileOutputStream(f);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                // BufferedWriter用来装饰OutputStreamWriter
                BufferedWriter bw = new BufferedWriter(osw);
        ) {
            bw.write("abc");
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
