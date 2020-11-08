public abstract class Home {

    private String description;
    private int cost;

    public void setDescription(String desc){
        this.description = desc;
    }

    public String getDescription(){
        return this.description;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public int getCost(){
        return this.cost;
    }
}
