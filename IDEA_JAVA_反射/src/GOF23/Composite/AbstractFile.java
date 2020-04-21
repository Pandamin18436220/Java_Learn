package GOF23.Composite;

import java.util.ArrayList;
import java.util.List;

//抽象构建
public interface AbstractFile {
    void killVirus();
}

//叶子
class ImageFile implements AbstractFile{
    private String name;
    public ImageFile(String name){
        this.name=name;
    }
    @Override
    public void killVirus() {
        System.out.println("图像文件："+name+",进行杀毒");
    }
}
class TextFile implements AbstractFile{
    private String name;
    public TextFile(String name){
        this.name=name;
    }
    @Override
    public void killVirus() {
        System.out.println("文本文件："+name+",进行杀毒");
    }
}
class VideoFile implements AbstractFile{
    private String name;
    public VideoFile(String name){
        this.name=name;
    }
    @Override
    public void killVirus() {
        System.out.println("视频文件："+name+",进行杀毒");
    }
}
//容器
class Folder implements AbstractFile{
    private String name;

    public Folder(String name) {
        this.name = name;
    }

    private List<AbstractFile> list = new ArrayList<AbstractFile>();

    public String getName() {
        return name;
    }
    public void add(AbstractFile file){
        list.add(file);
    }
    public void remove(AbstractFile file){
        list.remove(file);
    }
    public AbstractFile getChild(int index){
        return list.get(index);
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("文件夹"+name+"进行杀毒");
        for(AbstractFile file:list){
            file.killVirus();
        }
    }
}

