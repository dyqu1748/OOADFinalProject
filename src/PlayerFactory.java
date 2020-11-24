public class PlayerFactory {

    public Player createPlayer(String name){
        //Create a new player and assign them the name provided
        Player p = new Player();
        p.setName(name);
        return p;
    }
}
