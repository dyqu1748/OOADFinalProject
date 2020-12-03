import java.util.ArrayList;
import java.util.Random;

public class GameState {
    private ArrayList<Player> playersList;
    private Board board;
    private int wheel;
    private PlayerFactory playerFactory;

    public GameState(){
        playersList = new ArrayList<Player>();
        wheel = 10;
    }

    //add Player object to current playerlist
    public void addPlayer(Player p){
        this.playersList.add(p);
    }

    //If we need to override the playerlist with one from a previous state, this will allow us to do so
    public void setPlayers(ArrayList<Player> pl){
        this.playersList = pl;
    }

    public ArrayList<Player> getPlayers(){
        return this.playersList;
    }

    //Get player object at a specific index (i.e get player 1)
    public Player getPlayerAt(int i)
    {
        return this.playersList.get(i);
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public Board getBoard(){
        return this.board;
    }

    public int getWheelValue()
    {
        return this.wheel;
    }

    //Spin the wheel and go forward 1 - 10 spaces
    public int spinWheel(){
        Random rand = new Random();
        int moves = rand.nextInt(this.getWheelValue()) + 1;
        return moves;
    }

    public PlayerFactory createPlayerFactory(){
        return new PlayerFactory();
    }

    public void createPlayer(String name){
        //create and add player to the list of players
        this.playersList.add(this.playerFactory.createPlayer(name));
    }

}
