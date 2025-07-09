public class ReturnBook extends Transaction{
    private int returnDate;
    public ReturnBook (int bookID, int userID, int returnDate){
        super(bookID,userID,returnDate-14);
        this.returnDate=returnDate;
    }
    
    
}