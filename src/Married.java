public class Married extends RedDecorator{
    public Married(Red red){
        this.red = red;
    }

    public String getMeaning(){
        return(this.red.getMeaning() + "; Get Married!");
    }
}
