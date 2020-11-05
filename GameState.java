import java.util.ArrayList;
import java.util.Random;

public class GameState {
    private ArrayList<Player> playersList;
    private Board board;
    private int wheel;
    private PlayerFactory playerFactory;

    //Need to finish
    public GameState(){

    }

    public void addPlayer(Player p){
        this.playersList.add(p);
    }

    public ArrayList<Player> getPlayers(){
        return this.playersList;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public Board getBoard(){
        return this.board;
    }

    //Spin the wheel and go forward 1 - 10 spaces
    public int spinWheel(){
        Random rand = new Random();
        int moves = rand.nextInt(10) + 1;
        return moves;
    }

    //Need to finish
    public void useIterator(){

    }

    public PlayerFactory createPlayerFactory(){
        return new PlayerFactory();
    }

}
