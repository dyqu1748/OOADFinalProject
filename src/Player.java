import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private Job job;
    private String spouse;
    private ArrayList<String> children;
    private int spaceLocation;
    private boolean isTurn;
    private boolean retired;
    private Home home;
    private boolean degree;

    //Initialize player
    public Player(){
        this.money = 7500;
        this.isTurn = false;
        this.retired = false;
        this.degree = false;
        this.children = new ArrayList<String>();
        this.home=null;
    }

    //Getters and setters for all of the player's private attributes
    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return this.money;
    }

    //getJob will be used to add the appropriate amount of money to the player when they land on a payday space (get salary of the job)
    public Job getJob(){
        return this.job;
    }

    public String getSpouse(){
        return this.spouse;
    }

    public ArrayList<String> getChildren(){
        return this.children;
    }

    public int getLocation(){
        return this.spaceLocation;
    }

    public void setName(String name){
        this.name = name;
    }

    //Money will be added to the player's account. If money need to be taken away, provide a negative number as the argument.
    public void setMoney(int money){
        this.money += money;
    }

    public void setJob(Job job){
        this.job = job;
    }

    public void setSpouse(String spouse){
        this.spouse = spouse;
    }

    public void setChildren(String child){
        this.children.add(child);
    }

    public void setLocation(int location){
        this.spaceLocation = location;
    }

    //Set and get retired will be used to check whether a player is done with the game (will skip over them if true)
    public void setRetired(boolean ret){
        this.retired = ret;
    }

    public boolean getRetired(){
        return this.retired;
    }

    public void setIsTurn(boolean turn){
        this.isTurn = turn;
    }

    public boolean getIsTurn(){
        return this.isTurn;
    }

    //Set and get degree will be used when the player is choosing their career (some jobs require a degree)
    public void setDegree(boolean degree){
        this.degree =degree;
    }

    public boolean getDegree(){
        return this.degree;
    }


    public void setHome(Home home){
        this.home = home;
    }

    public Home getHome(){
        return this.home;
    }
}
