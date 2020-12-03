public class Children extends RedDecorator{
    public Children(Red red){
        this.red = red;
    }

    public String getMeaning(){
        return(this.red.getMeaning() + "; You're having a Child!");
    }
}
