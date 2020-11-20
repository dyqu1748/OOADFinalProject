import java.util.ArrayList;

public class Memento {

    private final GameState state;

    public Memento(GameState gs)
    {
        this.state = gs;
    }

    public GameState getState(){
        return this.state;
    }
}
