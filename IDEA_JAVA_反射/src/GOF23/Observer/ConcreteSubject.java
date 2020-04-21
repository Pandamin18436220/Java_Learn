package GOF23.Observer;

public class ConcreteSubject extends Sub {
    private int state;
    public int getState(){
        return state;
    }
    public void setState(int state){
        this.state = state;
        this.notifyAllObservers();
    }
}
