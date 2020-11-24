public abstract class Job {
    private String type;
    private int salary;
    private boolean degreeReq;

    //Setters and getters for Job private attributes
    public void setType(String type){
        this.type = type;
    }

    //Salary is how much the player will earn when landing on a payday space
    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getType(){
        return this.type;
    }

    public int getSalary(){
        return this.salary;
    }

    //Jobs that require a degree will require that the player has gone to college
    public void setDegreeReq(Boolean deg){
        this.degreeReq = deg;
    }

    public Boolean getDegreeReq(){
        return this.degreeReq;
    }
}
