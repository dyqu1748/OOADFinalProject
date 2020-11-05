import java.util.ArrayList;

public class Board {
    private ArrayList<String> spaces;

    public Board(){
        this.spaces = new ArrayList<String>();
//        Add spaces to the arraylist

    }

    public String getSpace(int space){
        return this.spaces.get(space);
    }
}
