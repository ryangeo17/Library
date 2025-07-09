public class Fiction extends Book {
    private String author;
    public Fiction(int ID, String name, int pages, int numberOfCopies, String author){
        super(ID, name, pages, numberOfCopies);
        this.author=author;
    }
    //getter methods
    public String getAuthor(){
        return author;
    }
    
    // setter methods
    public void setAuthor(String author){
        this.author=author;

    }
    
}