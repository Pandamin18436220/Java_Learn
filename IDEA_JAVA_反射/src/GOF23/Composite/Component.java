package GOF23.Composite;

public interface Component {
    void operation();
}
interface Leaf extends Component{

}
interface Composit extends Component{
    void add(Component c);
    void remove(Component c);
    Component getChild(int index);
}
