import java.util.ArrayList;
public class User {
    private int ID;
    private int numberOfBooks;
    private String name;
    private ArrayList<Book>booksCarrying= new ArrayList<>();
    public User (String name, int ID){
        this.name=name;
        this.ID=ID;
    }
    
    //getter methods
    
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public int getNumberOfBooks(){
        return numberOfBooks;
    }
    
    
    // setter methods
    
     public void setID(int ID){
        this.ID= ID;
    }
    
    public void setName(String name){
        this.name=name;
    }
    public void setNumberOfBooks(int numberOfBooks){
        this.numberOfBooks=numberOfBooks;
    }
    
    //arraylist add and remove
    public void addBook(Book bookAdding){
        booksCarrying.add(bookAdding);
        sortBooksCarrying();
    }
    public void removeBook(Book bookRemoving){
        for (int i=0; i<booksCarrying.size();i++){
            if ((booksCarrying.get(i)).equals(bookRemoving)){
                booksCarrying.remove(booksCarrying.get(i));
                i=booksCarrying.size();
            }
        }
    }
    
    //sorting method
    
    public void sortBooksCarrying(){
        int n=booksCarrying.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                
                if ((booksCarrying.get(j)).getID() > (booksCarrying.get(j + 1)).getID()) {
                    
                    // Swap list.get(j) and list.get(j + 1)
                    Book temp = booksCarrying.get(j);
                    
                
                    booksCarrying.set(j, booksCarrying.get(j + 1));
                    booksCarrying.set(j + 1, temp);
                }
            }
        }
    }
    
    //printing method
    public void printBooksCarrying(){
        for (Book i: booksCarrying){
            System.out.println(i.getID() + ". " + i.getName()+   "   Copies: " + i.getNumberOfCopies());
        }
    }
    
}