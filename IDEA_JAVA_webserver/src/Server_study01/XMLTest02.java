package Server_study01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Create By ${潘晟凯} on S{DATE}
 */
public class XMLTest02 {
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
        PersonHandler handler =new PersonHandler();
        //5.解析
        parse.parse(Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("Server_study01/p.xml")
        ,handler);


        //6.获取数据
        List<Person> persons=handler.getPersons();
        for(Person p:persons){
            System.out.println(p.getName()+"---->"+p.getAge());
        }
    }
}

class PersonHandler extends DefaultHandler{
    private List<Person> persons;
    private Person person;
    private String tag;//存储操作标签

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
//        System.out.println("解析文档开始...");
        persons=new ArrayList<Person>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println(qName+"--->解析开始");
        if(null!=qName) {
            tag = qName;//存储标签名
        }
        if(tag.equals("person")){
            person = new Person();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String contents = new String(ch,start,length);
//        if(contents.length()>0){
//            System.out.println("内容为--->"+contents);
//        }else{
//            System.out.println("内容为--->"+"空");
//        }
        if(null!=tag) {//处理空
            if(tag.equals("name")){
                person.setName(contents);
            }else if (tag.equals("age")){
                if(contents.length()>0) {
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(null!=qName){
            System.out.println(qName+"--->解析结束");
            if(qName.equals("person")){
                persons.add(person);
            }
        }
        tag=null;
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
//        System.out.println("解析文档结束...");
    }
}