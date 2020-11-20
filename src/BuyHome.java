public class BuyHome extends RedDecorator{
    public BuyHome(Red red){
        this.red = red;
    }
    public String getMeaning(){
        return( this.red.getMeaning() + "; Buy Home!");
    }
}
