import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class classTest {
    public static void main(String[] args) throws NoSuchMethodException, IOException {
        //1.得到项目地址
        String path = Objects.requireNonNull(classTest.class.getResource("/")).getPath();
        System.out.println(path);

        //2.
//        path = Objects.requireNonNull(classTest.class.getClassLoader().getResource("a.html")).getPath();
//        System.out.println(path);

        //3.
        File file = new File("a");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getPath());

        //4.
        System.out.println(System.getProperty("user.dir"));
    }

}


