package GOF23.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pandamin
 */
public class Sub {
    protected List<Obser> list = new ArrayList<>();

    public void register(Obser obs){
        list.add(obs);
    }
    public void registerObserver(Obser obs){
        list.add(obs);
    }
    public void notifyAllObservers(){
        for(Obser obs:list){
            obs.update(this);
        }
    }

}
