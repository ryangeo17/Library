public class GeneralUser extends User{
    private int age;
    private int numberOfBooks;
    private int overdueBooks;
    public GeneralUser (String name, int ID, int age, int numberOfBooks, int overdueBooks){
        super(name, ID);
        this.age=age;
        this.numberOfBooks=numberOfBooks;
        this.overdueBooks=overdueBooks;
    }
    
    //getter methods
    
    public int getAge(){
        return age;
    }
    public int getNumberOfBooks(){
        return numberOfBooks;
    }
    
    public int getOverdueBooks(){
        return overdueBooks;
    }
    
    
    // setter methods
    
     public void setAge(int Age){
        this.age=age;
    }
    
    public void setNumberOfBooks(int numberOfBooks){
        this.numberOfBooks=numberOfBooks;
    }
    public void setOverdueBooks(int overdueBooks){
        this.overdueBooks=overdueBooks;
    }
    
}