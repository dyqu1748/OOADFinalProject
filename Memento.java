public class Memento {

    private GameState state;

    public Memento(GameState gs){
        this.state = gs;
    }

    public GameState getState(){
        return this.state;
    }
}
