import java.util.ArrayList;
import java.util.Random;

public class Board {
    //construct the Board
    private ArrayList<Space> spaces;

    public Board(){
        this.spaces = new ArrayList<>();
        //Number of Spaces on a Game
        int numSpace = 40;
        Random rand = new Random();
        //for each space randomly generate what each space is
        for(int i = 0; i < numSpace; i++){
            int randInt = rand.nextInt(3);
            //randomly initialize each space
            switch (randInt){
                case 0:
                    this.spaces.add(new Blue());
                    break;
                case 1:
                    this.spaces.add(new Green());
                    break;
                case 2:
                    //Generate a Red space that has a random behavior
                    int randIntRed = rand.nextInt(4);
                    Red red_space = new Red();
                    switch (randIntRed){
                        case 0:
                            this.spaces.add(new Children(red_space));
                            break;
                        case 1:
                            this.spaces.add(new BuyHome(red_space));
                            break;
                        case 2:
                            this.spaces.add(new Married(red_space));
                            break;
                        case 3:
                            this.spaces.add(new JobSearch(red_space));
                            break;
                    }
            }
        }
        //add final retire space
        this.spaces.add(new Black());
    }


    public Space getSpace(int space){
        return spaces.get(space);
    }


}
