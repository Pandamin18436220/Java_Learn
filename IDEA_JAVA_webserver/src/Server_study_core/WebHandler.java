package Server_study_core;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class WebHandler extends DefaultHandler {
    private List<Entity> entitys;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    private String tag;//存储操作标签
    private  boolean isMapping=false;

    public List<Entity> getEntitys() {
        return entitys;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
//        System.out.println("解析文档开始...");
        entitys=new ArrayList<Entity>();
        mappings=new ArrayList<Mapping>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        System.out.println(qName+"--->解析开始");
        if(null!=qName) {
            tag = qName;//存储标签名
        }
        if(tag.equals("servlet")){
            entity = new Entity();
            isMapping = false;
        }else if(tag.equals("servlet-mapping")){
            mapping = new Mapping();
            isMapping = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String contents = new String(ch,start,length);
        if(null!=tag) {//处理空
            if(isMapping){
                if(tag.equals("servlet-name")){
                    mapping.setName(contents);
                }else if (tag.equals("url-pattern")){
                    if(contents.length()>0) {
                        mapping.addPattern(contents);
                    }
                }
            }else{
                if(tag.equals("servlet-name")){
                    entity.setName(contents);
                }else if (tag.equals("servlet-class")){
                    if(contents.length()>0) {
                        entity.setCiz(contents);
                    }
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(null!=qName){
            System.out.println(qName+"--->解析结束");
            if(qName.equals("servlet")){
                entitys.add(entity);
            }else if(qName.equals("servlet-mapping")){
                mappings.add(mapping);
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
