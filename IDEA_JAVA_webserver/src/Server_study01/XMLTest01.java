package Server_study01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Create By ${潘晟凯} on S{DATE}
 * XML语言是可扩展语言，作为数据的一种存储格式或用于存储软件的参数，
 * 程序解析此文件，就可以达到不修改代码就能更改程序的目的。
 *
 * HTML
 *    1.HTML5
 *    2.XHTML---->XML
 *
 * UDP TCP是传输层协议
 * Http协议是应用层协议：超文本传输协议
 *
 * 请求协议
 * 1.请求行：方法（Get/Post）,URI,协议/版本
 * 2.请求头：(Request Header)
 * 3.请求正文
 *
 * 响应协议
 * 1.状态行：协议/版本 状态码 状态描述  200 OK    404  Not Found
 * 2.响应头：(Request Header)
 * 3.响应正文(注意与响应头之间有个空行)
 *
 */
public class XMLTest01 {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //SAX解析
        //1.获取解析工厂
        SAXParserFactory factory=SAXParserFactory.newInstance();
        //2.从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //3.编写处理器
        //4.加载文档Document注册处理器
        PHandler handler =new PHandler();
        //5.解析
        parse.parse(Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("Server_study01/p.xml")
        ,handler);
    }
}
class PHandler extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("解析文档开始...");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println(qName+"--->解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String contents = new String(ch,start,length);
        if(contents.length()>0){
            System.out.println("内容为--->"+contents);
        }else{
            System.out.println("内容为--->"+"空");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        System.out.println(qName+"--->解析结束");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析文档结束...");
    }
}