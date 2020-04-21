package GOF23.Observer;

public class ObserverA implements Obser {

    private int myState;

    public int getMyState(){
        return myState;
    }
    public void setMyState(int myState){
        this.myState = myState;
    }
    @Override
    public void update(Sub subject) {
        myState = ((ConcreteSubject)subject).getState();
    }
}
