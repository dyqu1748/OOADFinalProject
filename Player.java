import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private String job;
    private String spouse;
    private ArrayList<String> children;
    private int spaceLocation;

    public Player(){
        this.money = 0;
        this.children = new ArrayList<String>();
    }

    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return this.money;
    }

    public String getJob(){
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

    public void setMoney(int money){
        this.money += money;
    }

    public void setJob(String job){
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
}
