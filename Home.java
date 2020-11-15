public abstract class Home {

    private String type;
    private int cost;

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public int getCost(){
        return this.cost;
    }
}
