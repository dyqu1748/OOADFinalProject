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
    private int loans;
    private int stocks;
    private boolean carInsurance;
    private Home home;
    private String degree;

    public Player(){
        this.money = 0;
        this.loans = 0;
        this.stocks = 0;
        this.isTurn = false;
        this.retired = false;
        this.carInsurance = false;
        this.degree = "";
        this.children = new ArrayList<String>();
    }

    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return this.money;
    }

    public Job getJob(){
        return this.job;
    }

    public void setJob(Job job){
        this.job = job;
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

    public void setSpouse(String spouse){
        this.spouse = spouse;
    }

    public void setChildren(String child){
        this.children.add(child);
    }

    public void setLocation(int location){
        this.spaceLocation = location;
    }

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

    public void setDegree(String degree){
        this.degree =degree;
    }

    public String getDegree(){
        return this.degree;
    }

    //Loan and stock amounts will be a constant; attributes will track how many of each the player has
    public void setLoans(){
        this.loans++;
    }

    public int getLoans(){
        return this.loans;
    }

    public void setStocks(){
        this.stocks++;
    }

    public int getStocks(){
        return this.stocks;
    }

    public void setCarInsurance(boolean bought){
        this.carInsurance = bought;
    }

    public boolean getCarInsurance(){
        return this.carInsurance;
    }

    public void setHome(Home home){
        this.home = home;
    }

    public Home getHome(){
        return this.home;
    }
}
