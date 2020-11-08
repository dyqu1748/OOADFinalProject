public class HomeInsurance extends HomeDecorator{

    public HomeInsurance(Home home){
        this.home = home;
    }

    public String getDescription(){
        return (home.getDescription() + "; Insured");
    }

    public int getCost(){
        if (home.getClass() == SuburbanHome.class){
            return (home.getCost() + 500);
        }
        else if (home.getClass() == FarmHouse.class){
            return (home.getCost() + 100);
        }
        else{
            return (home.getCost() + 1000);
        }
    }
}
