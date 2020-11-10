import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args){

        //Test making players

        Scanner userInput = new Scanner(System.in);
        System.out.println("How many players would you like? (max 4)");
        boolean gotInput = false;
        int numPlayers = 0;


        while (!gotInput) {
            String input = userInput.nextLine();
            try {
                numPlayers = Integer.parseInt(input);
//                    https://stackoverflow.com/questions/5502548/checking-if-a-number-is-an-integer-in-java
                if (numPlayers == (int) numPlayers && numPlayers > 0 && numPlayers <= 4) {
                    gotInput = true;
                } else {
                    System.out.println("Please enter a valid number for number of players.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number for number of players.");
            }
        }
        ArrayList<Player> players = new ArrayList<>();
        PlayerFactory pf = new PlayerFactory();
        for (int i  = 1; i <= numPlayers; i++){
            System.out.println("Please enter player " + i + "'s name.");
            String input = userInput.nextLine();
            players.add(pf.createPlayer(input));
        }

        //Check if player creation was successful
        int i = 1;
        for(Player p: players){
            System.out.println("Player " + i + "'s name: "+p.getName());
            i++;
        }

        //Test Home Creation
        //Uninsured home
        Home h1 = new Mansion();

        //Insured home
        Home h2 = new SuburbanHome();
        Home h2i = new HomeInsurance(h2);

        System.out.println("House 1 description: "+h1.getDescription());
        System.out.println("House 2 description: "+ h2i.getDescription());


        //Test Job Creation
        Job j1 = new Job("Surgeon",500);
        System.out.println("Job type: "+j1.getType());
        System.out.println("Job salary: "+j1.getSalary());

    }
}
