package visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author <a href="mailto:410486047@qq.com">GreyZeng</a>
 * @version 1.0, 2022/8/11
 */
public class FileVisitorTest {
    public static void main(String[] args) throws IOException {
        // 使用FileVisitor对目录进行遍历
        // 访问当前目录的所有文件
        Files.walkFileTree(Paths.get("."), new SimpleFileVisitor<Path>() {

            // 在访问子目录前触发该方法
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问" + dir + "目录");
                return FileVisitResult.CONTINUE;
            }

            // 在访问文件时触发该方法
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问" + file + "文件");
                return FileVisitResult.CONTINUE;
            }

            // 在访问失败时触发该方法
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                // 写一些具体的业务逻辑
                return super.visitFileFailed(file, exc);
            }

            // 在访问目录之后触发该方法
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                // 写一些具体的业务逻辑
                return super.postVisitDirectory(dir, exc);
            }
        });
    }
}
