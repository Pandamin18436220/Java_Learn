package JAVA_Dynamic.动态编译;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class DynamicCompile {
    public static void main(String[] args) throws IOException {
        //通过IO流，将字符串存储成一个临时文件(hello.java)，然后调用动态编译方法！
        String str = "public class hello {\n" +
                "        public static void main(String[] args) {\n" +
                "            System.out.println(\"Helloworld\");\n" +
                "        }\n" +
                "    }";

        //通过JavaCompiler动态编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,"E:\\Java_Learn\\IDEA_JAVA_反射\\src\\JAVA的动态性\\动态编译\\hello.java");
        System.out.println(result==0?"编译成功":"编译失败");

        //通过Runtime.getRuntime()运行启动新的进程运行
        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp E:\\Java_Learn\\IDEA_JAVA_反射\\src\\JAVA的动态性\\动态编译\\hello");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String info ="";
        while((info=reader.readLine())!=null){
            System.out.println(info);
        }

        //通过反射运行编译好的类
        try {
            URL[] urls = new URL[]{new URL("file:/"+"E:\\Java_Learn\\IDEA_JAVA_反射\\src\\JAVA的动态性\\动态编译")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("hello");
            //调用加载类的main方法
            Method m =c.getMethod("main",String.class);
            m.invoke(null,(Object)new String[]{});
            //由于可变参数是JDK5.0之后才有。
            /**
             * m.invoke(null,new String[]{"aa","bb});
             * 就发生了参数个数不匹配问题
             * 因此，必须要加上（object），才能避免这个问题
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
