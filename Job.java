public class Job {
    private String type;
    private int salary;

    public Job(String type, int salary){
        this.type = type;
        this.salary = salary;
    }

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
}
