public class BorrowBook extends Transaction{
    private int dueDate;
    
    public BorrowBook (int bookID, int userID, int dateBorrowed){
        super(bookID,userID,dateBorrowed);
        this.dueDate=dateBorrowed+14;
    }
}