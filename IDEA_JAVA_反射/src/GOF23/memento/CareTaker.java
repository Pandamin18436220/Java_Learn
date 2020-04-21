package GOF23.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责人类
 * 负责管理备忘录对象
 */
public class CareTaker {
    private EmpMemeto memento;
//    private List<EmpMemeto> list = new ArrayList<>();
    public EmpMemeto getMemento() {
        return memento;
    }

    public void setMemento(EmpMemeto memento) {
        this.memento = memento;
    }
}
