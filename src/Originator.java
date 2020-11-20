import java.util.ArrayList;

public class Originator {
    private GameState state;

    public void setState(GameState gs)
    {
        this.state = gs;
    }

    public GameState getState()
    {
        return this.state;
    }

    public Memento saveStateToMemento()
    {
        return new Memento(this.state);
    }

    //Need to finish/clarify; unsure if implementation is correct; good to go
    public void getStateFromMemento(Memento memento)
    {
        this.state = memento.getState();
    }

}
