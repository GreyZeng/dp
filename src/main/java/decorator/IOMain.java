package decorator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

// 装饰器的在jdk中的一个应用
public class IOMain {
    public static void main(String[] args) throws Exception {

        File f = new File("D:/1.txt");
        FileOutputStream fos = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("abc");
        bw.flush();
        bw.close();
    }
}
