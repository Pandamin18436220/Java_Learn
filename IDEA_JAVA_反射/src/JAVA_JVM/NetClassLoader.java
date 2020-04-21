package JAVA_JVM;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
//网络类加载器
/**
 * 自定义类加载器的流程
 *  - 继承：java.lang.ClassLoader
 *  - 首先检查请求的类型是否已经被这个类装载到命名空间中了，如果已经转载，直接返回；
 *  - 委派类加载请求给父类加载器，如果父类加载器能够完成，则返回父类加载器加载的class实例；
 *  - 调用本类加载器的findClass()方法，试图获取对应的字节码，如果获取的到，则调用defineClass()导入类型到方法区
 *    如果获取不到对应的字节码或者其他原因失败，返回异常给loadClass,loadClass()抛出异常，终止加载过程。
 */
public class NetClassLoader extends  ClassLoader{
    //JAVA_JVM.自定义类加载器    --->E:/Java_Learn/IDEA_JAVA_反射    JAVA_JVM/自定义类加载器
    private String rootDir;
    public NetClassLoader(String rootDir){
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
            URL url = new URL(path);
            is = url.openStream();
            byte[] buffer = new byte[1024];
            int temp = 0;
            while ((temp=is.read(buffer))!=-1){
                baos.write(buffer,0,temp);
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
