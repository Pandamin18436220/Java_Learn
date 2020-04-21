package Server_study_core;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class WebApp {
    private static WebContext webContext;
    static {
        try {
            //SAX解析
            //1.获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //2.从解析工厂获取解析器
            SAXParser parse = factory.newSAXParser();
            //3.编写处理器
            //4.加载文档Document注册处理器
            WebHandler handler = new WebHandler();
            //5.解析
            parse.parse(Thread.currentThread().getContextClassLoader()
                            .getResourceAsStream("Server_study04/web.xml")
                    , handler);
            //6.获取数据
            webContext = new WebContext(handler.getEntitys(), handler.getMappings());
            //假设你输入了/login
        } catch (Exception e) {
            System.out.println("解析配置文件错误");
        }
    }

    /**
     * 通过url获取配置文件对应的servlet
     * @param url
     * @return
     */
    public static Servlet getServletFromUrl(String url) {
        String className = webContext.getClz("/"+url);
        Class clz;
        try {
//            System.out.println(className+"-->");
            clz = Class.forName(className);
            Servlet servlet = (Servlet) clz.getConstructor().newInstance();
            return servlet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
