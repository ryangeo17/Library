public class Book {
    
    private int ID;
    private String name;
    private int pages;
    private boolean isAvalible=true;
    private int numberOfCopies;
    
    public Book(int ID, String name, int pages, int numberOfCopies){
        this.ID=ID;
        this.name=name;
        this.pages=pages;
        this.numberOfCopies=numberOfCopies;
    }
    
    //getter methods
    
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public int getPages(){
        return pages;
    }
    public boolean getIsAvalible(){
        if (numberOfCopies==0){
            isAvalible=false;
        }
        else{
            isAvalible=true;
        }
        return isAvalible;
    }
    public int getNumberOfCopies(){
        return numberOfCopies;
    }
    
    //setter methods
    
    public void setID(int ID){
        this.ID= ID;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setPages(int pages){
        this.pages=pages;
    }
    
    public void setNumberOfCopies(int numberOfCopies){
        this.numberOfCopies=numberOfCopies;
    }
    
}