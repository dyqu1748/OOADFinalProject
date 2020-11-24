import java.util.ArrayList;

public class Memento {

    private final GameState state;
    private final ArrayList<Player> playersList;
    private final Board board;

    public Memento(GameState gs)
    {
        this.state = gs;
        //this.playersList = gs.getPlayers();
        this.playersList = new ArrayList<Player>();
        for (int i = 0; i < gs.getPlayers().size(); i++)
        {
            this.playersList.add(gs.getPlayerAt(i));
        }
        this.board = gs.getBoard();
    }

    public GameState getState()
    {
        GameState gs = new GameState();
        gs.setPlayers(playersList);
        gs.setBoard(board);
        return gs;
    }
}
