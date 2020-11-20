public abstract class Job {
    private String type;
    private int salary;
    private boolean degreeReq;

    public void setType(String type){
        this.type = type;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public String getType(){
        return this.type;
    }

    public int getSalary(){
        return this.salary;
    }

    public void setDegreeReq(Boolean deg){
        this.degreeReq = deg;
    }

    public Boolean getDegreeReq(){
        return this.degreeReq;
    }
}
