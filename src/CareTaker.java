import java.util.ArrayList;

public class CareTaker {
    private ArrayList<Memento> mementoList;

    public CareTaker(){
        mementoList = new ArrayList<Memento>();
    }

    //https://www.tutorialspoint.com/design_pattern/memento_pattern.htm
    public void add(Memento state)
    {
        mementoList.add(state);
    }

    public Memento get(int index)
    {
        return mementoList.get(index);
    }
}