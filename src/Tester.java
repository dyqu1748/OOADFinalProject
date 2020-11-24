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
        ArrayList<String> players = new ArrayList<>();
        PlayerFactory pf = new PlayerFactory();
        for (int i  = 1; i <= numPlayers; i++) {
            System.out.println("Please enter player " + i + "'s name.");
            String input = userInput.nextLine();
            players.add(input);
        }

        //Test board creation
        System.out.println("Testing Board Creation:");
        Board board = new Board();
        for (int sp = 0; sp < 41; sp++){
            Space curSpace = board.getSpace(sp);
            System.out.println(curSpace.getColor());
            System.out.println(curSpace.getMeaning());
        }

        GameState gameState = new GameState();
        for (String name: players){
            gameState.createPlayer(name);
        }
        gameState.setBoard(board);

        System.out.println("Check player creation:");
        ArrayList<Player> playerCheck = gameState.getPlayers();
        for (Player player: playerCheck){
            System.out.println(player.getName());
        }

        System.out.println("Check Job Creation");
        Job j1 = new Cashier();
        Job j2 = new Programmer();
        System.out.println("Job 1 Type: " + j1.getType());
        System.out.println("Job 1 Salary: " + j1.getSalary());
        System.out.println("Job 1 Degree Required: " + j1.getDegreeReq());
        System.out.println("Job 2 Type: " + j2.getType());
        System.out.println("Job 2 Salary: " + j2.getSalary());
        System.out.println("Job 2 Degree Required: " + j2.getDegreeReq());

        System.out.println("Check Home Creation");
        Home h1 = new Mansion();
        Home h2 = new FarmHouse();
        System.out.println("Home 1 Type: " + h1.getType());
        System.out.println("Home 1 Cost: " + h1.getCost());
        System.out.println("Home 2 Type: " + h2.getType());
        System.out.println("Home 2 Cost: " + h2.getCost());

        System.out.println("Insure home check");
        Home h1I = new HomeInsurance(h1);
        Home h2I = new HomeInsurance(h2);
        System.out.println("Insured Home 1 Type: " + h1I.getType());
        System.out.println("Insured Home 1 Cost: " + h1I.getCost());
        System.out.println("Insured Home 2 Type: " + h2I.getType());
        System.out.println("Insured Home 2 Cost: " + h2I.getCost());

        gameState.play();

    }
}
