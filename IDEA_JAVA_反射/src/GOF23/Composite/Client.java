package GOF23.Composite;

public class Client {
    public static void main(String[] args) {
        AbstractFile f2,f3,f4,f5,f6;
        Folder f1 = new Folder("1");
        f2 = new ImageFile(".jpg");
        f3 = new TextFile(".txt");

        f1.add(f2);
        f1.add(f3);
        f1.killVirus();

    }
}
