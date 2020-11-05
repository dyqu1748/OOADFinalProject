public class PlayerFactory {

    public Player createPlayer(String name){
        Player p = new Player();
        p.setName(name);
        return p;
    }
}
