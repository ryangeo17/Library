public class Nonfiction extends Book {
    private int serial;
    public Nonfiction(int ID, String name, int pages, int numberOfCopies, int serial){
        super(ID, name, pages, numberOfCopies);
        this.serial=serial;
    }
    
    //getter methods
    public int getSerial(){
        return serial;
    }
    
    // setter methods
    public void setSerial(int serial){
        this.serial=serial;

    }
}