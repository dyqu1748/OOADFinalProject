public class JobSearch extends RedDecorator{
    public JobSearch(Red red){
        this.red = red;
    }

    public String getMeaning(){
        return(this.red.getMeaning() + "; Select a Job");
    }
}
