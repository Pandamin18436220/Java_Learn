package JAVA_JVM;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 加载文件系统加密后的class字节码的类加载器
 */
public class 自定义加密解密加载器 extends ClassLoader{
    //JAVA_JVM.自定义类加载器    --->E:/Java_Learn/IDEA_JAVA_反射    JAVA_JVM/自定义类加载器
    private String rootDir;
    public 自定义加密解密加载器(String rootDir){
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //查找已经加载的类
        Class<?> c = findLoadedClass(name);
        //应该先查询有没有加载过这个类，如果已经加载，则直接返回加载好的类。如果没有，则加载新的类
        if(c!=null){
            return c;
        }else{
            ClassLoader parent = this.getParent();
            try{
                c = parent.loadClass(name);  //委派给父类加载
            }catch (Exception e){
//                e.printStackTrace();
            }
            if(c!=null){
                return c;
            }else {
                byte[] classData = getClassData(name);
                if(classData==null){
                    throw new ClassNotFoundException();
                }else{
                    c = defineClass(name,classData,0,classData.length);
                }
            }
        }
        return c;
    }
    private byte[] getClassData(String classname){
        String path = rootDir + "/" + classname.replace('.','/')+"class";
        //IOUtils,可以使用它将流中的数据转化成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);

            int temp = -1;
            while((temp=is.read())!=-1){
                baos.write(temp^0xff);//取反操作
            }

            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
