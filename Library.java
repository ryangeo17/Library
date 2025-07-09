import java.util.ArrayList;
public class Library {
    private ArrayList<User>userList=new ArrayList<>(); 
    private ArrayList<Book>bookList=new ArrayList<>();
    private ArrayList<Transaction>transactionHistory=new ArrayList<>();
    private ArrayList<Fiction>fictionList=new ArrayList<>();
    private ArrayList<Nonfiction>nonfictionList=new ArrayList<>();
    
    //getter methods
    
    public int getBookListSize(){
        return bookList.size();
    }
    
    public int getUserListSize(){
        return userList.size();
    }
    
    //printing methods
    
    
    public void printUserList(){
        for (User i: userList){
            System.out.println(i.getName()+ " " + i.getID());
        }
    }
    
    public void printFictionList(){
        for (Fiction i:fictionList){
            System.out.println(i.getID() + ". " + i.getName()+ "  Author: "+ i.getAuthor() + "  Copies: " + i.getNumberOfCopies());
        }
    }
    
    public void printNonfictionList(){
        for (Nonfiction i:nonfictionList){
            System.out.println(i.getID() + ". " + i.getName()+ "  Serial: "+ i.getSerial() + "  Copies: " + i.getNumberOfCopies());
        }
    }
    public void printBookList(){
        for (Book i: bookList){
            System.out.println(i.getName()+ " " + i.getID());
        }
    }
    
    public void printBooksUserCarrying(int userID){
        for (User i: userList){
            if (i.getID()==userID){
                i.printBooksCarrying();
            }
        }
    }
    
    //adding transaction methods
    public void addBorrowBook(int bookID, int userID, int dateBorrowed){

        for (Book i: bookList){
            if(i.getID()==bookID){
                if(i.getNumberOfCopies()>0){
                    i.setNumberOfCopies(i.getNumberOfCopies()-1);
                    
                    for (User j: userList){
                        
                        if(j.getID()==userID){
                            j.setNumberOfBooks(j.getNumberOfBooks()+1);
                            j.addBook(i);
                            BorrowBook borrow= new BorrowBook(bookID, userID, dateBorrowed);
                            transactionHistory.add(borrow);
                        }
                    }
                    
                }
                else{
                    System.out.println("There are no copies of this book avalible.");
                }
            }
        }
        
        
    }
    public void addReturnBook(int bookID, int userID, int dateReturned){
        for (User i:userList){
            if(i.getID()==userID){
                if(i.getNumberOfBooks()>0){
                    i.setNumberOfBooks(i.getNumberOfBooks()-1);
                    for(Book j: bookList){
                        if(j.getID()==bookID){
                            j.setNumberOfCopies(j.getNumberOfCopies()+1);
                            i.removeBook(j);
                            ReturnBook bookreturn = new ReturnBook(bookID, userID, dateReturned);
                        }
                    }
                }
                else{
                    System.out.println("You don't have this book.");
                }
            }
        }
    }
    //adding user methods
    
    public void addGeneralUser(String name, int ID, int age, int numberOfBooks, int overdueBooks) {
        GeneralUser person = new GeneralUser(name, ID, age, numberOfBooks, overdueBooks);
        userList.add(person);
        sortUsers();

    }
    
    public void addAdmin (String name, int ID, boolean access) {
        Admin administrator = new Admin(name, ID, access);
        userList.add(administrator);
        sortUsers();
    }
    
    //adding book methods
    
    public void addFiction(int ID, String name, int pages, int numberOfCopies, String author){
        Fiction story = new Fiction (ID, name, pages, numberOfCopies, author);
        bookList.add(story);
        fictionList.add(story);
        sortBooks();
        
    }
    
    public void addNonfiction(int ID, String name, int pages, int numberOfCopies, int serial){
        Nonfiction text = new Nonfiction (ID, name, pages, numberOfCopies, serial);
        bookList.add(text);
        nonfictionList.add(text);
        sortBooks();
    }
    
    //sort methods
    
    public void sortUsers(){
        int n=userList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if ((userList.get(j)).getID() > (userList.get(j + 1)).getID()) {
                    
                    // Swap list.get(j) and list.get(j + 1)
                    User temp = userList.get(j);
                    
                
                    userList.set(j, userList.get(j + 1));
                    userList.set(j + 1, temp);
                }
            }
        }
        
    }
    
    public void sortBooks(){
        int n=bookList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if ((bookList.get(j)).getID() > (bookList.get(j + 1)).getID()) {
                    
                    // Swap list.get(j) and list.get(j + 1)
                    Book temp = bookList.get(j);
                    
                
                    bookList.set(j, bookList.get(j + 1));
                    bookList.set(j + 1, temp);
                }
            }
        }
    }
    
    public void sortTransactions(){
        int n=transactionHistory.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if ((transactionHistory.get(j)).getDateBorrowed() > (transactionHistory.get(j + 1)).getDateBorrowed()) {
                    
                    // Swap list.get(j) and list.get(j + 1)
                    Transaction temp = transactionHistory.get(j);
                    
                
                    transactionHistory.set(j, transactionHistory.get(j + 1));
                    transactionHistory.set(j + 1, temp);
                }
            }
        }
    }
    
    //search methods
    
    public boolean findAdmin(int ID){
        int low=0;
        int high=userList.size()-1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if ((userList.get(mid)).getID()== ID){
                if (userList.get(mid) instanceof Admin){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if ((userList.get(mid)).getID()< ID){
                low = mid + 1;
            }
            else if ((userList.get(mid)).getID()> ID){
                high = mid - 1;
            }
        }
        return false;
        
    }
    
    public boolean findGeneralUser(int ID){
        int low=0;
        int high=userList.size()-1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if ((userList.get(mid)).getID()== ID){
                if (userList.get(mid) instanceof GeneralUser){
                    return true;
                }
                else{
                    return false;
                }
            }
            else if ((userList.get(mid)).getID()< ID){
                low = mid + 1;
            }
            else if ((userList.get(mid)).getID()> ID){
                high = mid - 1;
            }
        }
        return false;
        
    }
    
    
    

}