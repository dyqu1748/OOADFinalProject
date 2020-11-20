public class Blue extends Space{

    public Blue(){
        this.setColor("Blue");
        //create a list of instructions that class Blue will be able to access
        Instructions list = new Instructions();
        //call selectInsturction and set it as the meaning
        String instruct = list.selectInstruction();
        //set the meaning of the tile
        this.setMeaning(instruct);
    }
}
