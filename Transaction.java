public class Transaction {
    private int bookID;
    private int userID;
    private int dateBorrowed;
    
    public Transaction (int bookID, int userID, int dateBorrowed){
        this.bookID=bookID;
        this.userID=userID;
        this.dateBorrowed=dateBorrowed;
    }
    
    //getter methods
    
    public int getBookID(){
        return bookID;
    }
    public int getUserID(){
        return userID;
    }
    
    public int getDateBorrowed(){
        return dateBorrowed;
    }
    
    
    // setter methods
    
     public void setBookID(int bookID){
        this.bookID=bookID;
    }
    
    public void setUserID(int userID){
        this.userID=userID;
    }
    public void setDateBorrowed(int dateBorrowed){
        this.dateBorrowed=dateBorrowed;
    }
}