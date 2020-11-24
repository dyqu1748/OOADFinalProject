import javax.print.Doc;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class GameState {
    private ArrayList<Player> playersList;
    private Board board;
    private int wheel;
    private PlayerFactory playerFactory;

    //Need to finish
    public GameState(){
        this.playersList = new ArrayList<Player>();
        this.wheel = 10;
        this.playerFactory = createPlayerFactory();
    }

    public void addPlayer(Player p){
        this.playersList.add(p);
    }

    public ArrayList<Player> getPlayers(){
        return this.playersList;
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public Board getBoard(){
        return this.board;
    }

    public int getWheelValue()
    {
        return this.wheel;
    }

    //Spin the wheel and go forward 1 - 10 spaces
    public int spinWheel(){
        Random rand = new Random();
        return rand.nextInt(this.getWheelValue()) + 1;
    }

    public void play()
    {
        Scanner userInput = new Scanner(System.in);
        int maxPlayerCount = this.playersList.size();
        int retiredPlayers = 0;
        String input;
        boolean validInput;
        Random rand = new Random();
        while(retiredPlayers != maxPlayerCount)
        {
            for(Player curPlayer: this.playersList) {
                if (curPlayer.getRetired() == false && curPlayer.getIsTurn()) {
                    System.out.println("It is now " + curPlayer.getName() + "'s turn!");
                    if (curPlayer.getLocation() == 0) {
                        validInput = false;
                        while (!validInput) {
                            System.out.println("Do you want to go to college and get a degree (Y or N)? If you do, you will start the game with no money.");
                            input = userInput.nextLine();
                            if (input.equals("Y")) {
                                validInput = true;
                                curPlayer.setDegree(true);
                                curPlayer.setMoney(-curPlayer.getMoney());
                            }
                            else if (input.equals("N")){
                                validInput = true;
                            }
                        }
                        if (curPlayer.getDegree()) {
                            System.out.println("Your job options are (1) Doctor, (2) Lawyer, (3) Programmer, (4) Scientist. Which job do you want?");
                        } else {
                            System.out.println("Your job options are (1) Cashier, (2) Construction Worker, (3) Fast Food Worker, (4) Mail Man. Which job do you want?");
                        }
                        int choice = 0;
                        validInput = false;
                        while (!validInput) {
                            input = userInput.nextLine();
                            try {
                                choice = Integer.parseInt(input);
                                if (choice == (int) choice && choice > 0 && choice <= 4) {
                                    validInput = true;
                                } else {
                                    System.out.println("Please enter a valid choice.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Please enter a valid choice.");
                            }
                        }
                        if (curPlayer.getDegree()) {
                            switch (choice) {
                                case 1:
                                    curPlayer.setJob(new Doctor());
                                    break;
                                case 2:
                                    curPlayer.setJob(new Lawyer());
                                    break;
                                case 3:
                                    curPlayer.setJob(new Programmer());
                                    break;
                                case 4:
                                    curPlayer.setJob(new Scientist());
                                    break;
                            }
                        } else {
                            switch (choice) {
                                case 1:
                                    curPlayer.setJob(new Cashier());
                                    break;
                                case 2:
                                    curPlayer.setJob(new ConstructionWorker());
                                    break;
                                case 3:
                                    curPlayer.setJob(new FastFoodWorker());
                                    break;
                                case 4:
                                    curPlayer.setJob(new MailMan());
                                    break;
                            }
                        }
                    }

                    System.out.println("Press any button to spin the wheel!");
                    input = userInput.nextLine();
                    System.out.println("Spinning the wheel!");
                    int forward = spinWheel();
                    int newSpace = curPlayer.getLocation() + forward;
                    if (newSpace >= 40){
                        curPlayer.setLocation(40);
                    }
                    else{
                        curPlayer.setLocation(newSpace);
                    }
                    System.out.println("You move forward " + forward + " spaces, you're now on space " + curPlayer.getLocation());

                    Space spaceDesc = board.getSpace(curPlayer.getLocation());
                    System.out.println("Space Description: " + spaceDesc.getMeaning());
                    switch (spaceDesc.getColor()) {
                        case "Green":
                            curPlayer.setMoney(curPlayer.getJob().getSalary());
                            if (curPlayer.getMoney() >= 0){
                                System.out.println(curPlayer.getName() + " now has $"+ curPlayer.getMoney());
                            }
                            else{
                                System.out.println(curPlayer.getName() + " now has -$"+ -1*curPlayer.getMoney());
                            }
                            break;
                        case "Black":
                            curPlayer.setRetired(true);
                            retiredPlayers++;
                            break;
                        case "Red":
                            switch (spaceDesc.getMeaning().substring(6, spaceDesc.getMeaning().length())) {
                                case "Get Married!":
                                    if (curPlayer.getSpouse() == "") {
                                        String wifeHus = "";
                                        int randNum = rand.nextInt(2);
                                        if (randNum == 0) {
                                            wifeHus = "Wife";
                                        } else {
                                            wifeHus = "Husband";
                                        }
                                        curPlayer.setSpouse(wifeHus);
                                    } else {
                                        System.out.println("You're already married!");
                                    }
                                    break;
                                case "You're having a Child!":
                                    String boyGirl = "";
                                    int randNum = rand.nextInt(2);
                                    if (randNum == 0) {
                                        boyGirl = "Boy";
                                    } else {
                                        boyGirl = "Girl";
                                    }
                                    curPlayer.setChildren(boyGirl);
                                    break;
                                case "Buy Home!":
                                    System.out.println("The available houses are (1) a suburban house for $5000, (2) a farm house for $3000, or (3) a mansion for $10000. Which one do you want?");
                                    int choice = 0;
                                    validInput = false;
                                    while (!validInput) {
                                        input = userInput.nextLine();
                                        try {
                                            choice = Integer.parseInt(input);
                                            if (choice == (int) choice && choice > 0 && choice <= 3) {
                                                validInput = true;
                                            } else {
                                                System.out.println("Please enter a valid choice.");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Please enter a valid choice.");
                                        }
                                    }
                                    validInput = false;
                                    String input2 = "";
                                    while (!validInput) {
                                        System.out.println("Would you like to add insurance to your home (Y or N)? It costs $100 for the farm house, $500 for the suburban house, and $1000 for the mansion.");
                                        input2 = userInput.nextLine();
                                        if (input2.equals("Y")) {
                                            validInput = true;
                                        }
                                        else if (input2.equals("N")){
                                            validInput = true;
                                        }
                                    }
                                    Home home = null;
                                    switch (choice) {
                                        case 1:
                                            home = new SuburbanHome();
                                            break;
                                        case 2:
                                            home = new FarmHouse();
                                            break;
                                        case 3:
                                            home = new Mansion();
                                            break;
                                    }
                                    if (input2.equals("Y")){
                                        curPlayer.setHome(new HomeInsurance(home));
                                    }
                                    else {
                                        curPlayer.setHome(home);
                                    }
                                    curPlayer.setMoney(-1 * curPlayer.getHome().getCost());
                                    if (curPlayer.getMoney() >= 0){
                                        System.out.println(curPlayer.getName() + " now has $"+ curPlayer.getMoney());
                                    }
                                    else{
                                        System.out.println(curPlayer.getName() + " now has -$"+ curPlayer.getMoney());
                                    }
                                    break;
                                case "Select a Job":
                                    if (curPlayer.getDegree()) {
                                        System.out.println("Your job options are (1) Doctor, (2) Lawyer, (3) Programmer, (4) Scientist. Which job do you want?");
                                    } else {
                                        System.out.println("Your job options are (1) Cashier, (2) Construction Worker, (3) Fast Food Worker, (4) Mail Man. Which job do you want?");
                                    }
                                    String curJob = curPlayer.getJob().getType();
                                    int curJobOpt = 0;
                                    switch (curJob){
                                        case "Doctor":
                                        case "Cashier":
                                            curJobOpt = 1;
                                            break;
                                        case "Lawyer":
                                        case "ConstructionWorker":
                                            curJobOpt = 2;
                                            break;
                                        case "Programmer":
                                        case "FastFoodWorker":
                                            curJobOpt = 3;
                                            break;
                                        case "Scientist":
                                        case "MailMan":
                                            curJobOpt = 4;
                                            break;
                                    }
                                    choice = 0;
                                    validInput = false;
                                    while (!validInput) {
                                        input = userInput.nextLine();
                                        try {
                                            choice = Integer.parseInt(input);
                                            if (choice == (int) choice && choice > 0 && choice <= 4 && choice != curJobOpt) {
                                                validInput = true;
                                            } else {
                                                System.out.println("Please enter a valid choice that is a new job (don't pick the same job you already have).");
                                            }
                                        } catch (NumberFormatException e) {
                                            System.out.println("Please enter a valid choice that is a new job (don't pick the same job you already have).");
                                        }
                                    }
                                    if (curPlayer.getDegree()) {
                                        switch (choice) {
                                            case 1:
                                                curPlayer.setJob(new Doctor());
                                                break;
                                            case 2:
                                                curPlayer.setJob(new Lawyer());
                                                break;
                                            case 3:
                                                curPlayer.setJob(new Programmer());
                                                break;
                                            case 4:
                                                curPlayer.setJob(new Scientist());
                                                break;
                                        }
                                    } else {
                                        switch (choice) {
                                            case 1:
                                                curPlayer.setJob(new Cashier());
                                                break;
                                            case 2:
                                                curPlayer.setJob(new ConstructionWorker());
                                                break;
                                            case 3:
                                                curPlayer.setJob(new FastFoodWorker());
                                                break;
                                            case 4:
                                                curPlayer.setJob(new MailMan());
                                                break;
                                        }
                                    }
                            }
                            break;
                        case "Blue":
                            switch (spaceDesc.getMeaning().substring(0, 3)) {
                                case "Pay":
                                    int findDollar = spaceDesc.getMeaning().indexOf('$');
                                    int amount = Integer.parseInt(spaceDesc.getMeaning().substring(findDollar + 1, spaceDesc.getMeaning().length()));
                                    curPlayer.setMoney(-1 * amount);
                                    if (curPlayer.getMoney() >= 0){
                                        System.out.println(curPlayer.getName() + " now has $"+ curPlayer.getMoney());
                                    }
                                    else{
                                        System.out.println(curPlayer.getName() + " now has -$"+ -1*curPlayer.getMoney());
                                    }
                                    break;
                                case "Go ":
                                    curPlayer.setIsTurn(false);
                            }
                            break;
                    }
                }
                else if (curPlayer.getIsTurn() == false && curPlayer.getRetired() == false){
                    curPlayer.setIsTurn(true);
                }
            }
        }
        String winPlayerName = "";
        int winPlayerAmount = 0;
        System.out.println("Final Game Results");
        for (Player player: this.playersList){
            System.out.println(player.getName() + "'s results:");
            System.out.println("Job: " + player.getJob().getType());
            System.out.println("Number of children: " + player.getChildren().size());
            if (player.getSpouse().equals("Husband") || player.getSpouse().equals("Wife")){
                System.out.println("Married");
            }
            else{
                System.out.println("Not Married");
            }
            if (player.getHome() != null){
                System.out.println("Home Info: " + player.getHome().getType());
            }
            else{
                System.out.println("Didn't own a home.");
            }
            if (player.getMoney() < 0){
                System.out.println("Final Cash Balance: -$" + -1*player.getMoney());
            }
            else{
                System.out.println("Final Cash Balance: $"+ player.getMoney());
            }
            if (winPlayerName == ""){
                winPlayerName = player.getName();
                winPlayerAmount = player.getMoney();
            }
            else if (winPlayerAmount < player.getMoney()){
                winPlayerName = player.getName();
                winPlayerAmount = player.getMoney();
            }
        }
        if (winPlayerAmount < 0){
            System.out.println(winPlayerName + " wins with -$" + -1*winPlayerAmount + " in debt!");
        }
        else {
            System.out.println(winPlayerName + " wins with $" + winPlayerAmount + " in the bank!");
        }
    }

    public PlayerFactory createPlayerFactory(){
        return new PlayerFactory();
    }

    public void createPlayer(String name){
        Player p = this.playerFactory.createPlayer(name);
        addPlayer(p);
    }

}