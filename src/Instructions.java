import java.util.ArrayList;
import java.util.Random;
//This class holds all possible insturcitons
public class Instructions {
    private ArrayList<String> instructs;
    private Random randomGenerator = new Random();

    public Instructions(){
        //All possible events that can occur on a blue space
        instructs = new ArrayList<>();
        instructs.add("Pay Salesclerk $15");
        instructs.add("Pay Waiter $50");
        instructs.add("Pay Tutor $150");
        instructs.add("Pay Lawyer $500");
        instructs.add("Pay Taxes $300");
        instructs.add("Go to Europe. Miss a Turn");
    }
    //randomly select an instruction
    public String selectInstruction(){
        int index = randomGenerator.nextInt(instructs.size());
        return instructs.get(index);
    }
}
