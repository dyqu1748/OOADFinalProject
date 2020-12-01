public abstract class Home {

    private String type;
    private int cost;

    //Getters and setters for the private attributes of Home

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    //Cost will be used to deduct the player's total amount of money when they buy a home
    public void setCost(int cost){
        this.cost = cost;
    }

    public int getCost(){
        return this.cost;
    }
}
