import java.util.ArrayList;
import java.util.Random;

public class GameState {
    private ArrayList<Player> playersList;
    private Board board;
    private int wheel;
    private PlayerFactory playerFactory;

    //Need to finish
    public GameState(){
        playersList = new ArrayList<Player>();
        wheel = 10;
    }

    public void addPlayer(Player p){
        this.playersList.add(p);
    }

    public void setPlayers(ArrayList<Player> pl){
        this.playersList = pl;
    }

    public ArrayList<Player> getPlayers(){
        return this.playersList;
    }

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

    /*public void play()
    {
        while(getPlayers().size())
        {
            ArrayList<Player> playerList = this.getPlayers();
            for(int i = 0; i < getPlayers().size(); i++)
            {
                int roll = this.spinWheel();
                playerList[i].setLocation(playerList[i].getLocation() + roll);

            }
        }
    }*/

    public PlayerFactory createPlayerFactory(){
        return new PlayerFactory();
    }

}
