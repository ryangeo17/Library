import java.util.Scanner;
public class MyProgram
{
    public static void main(String[] args)
    {
        Library myLibrary= new Library();
     //Default Admins, contains name, user ID, followed by other information

        myLibrary.addAdmin("Primary", 105,true );
        myLibrary.addAdmin("Adam", 101,true );
        myLibrary.addGeneralUser("Bobby", 110, 107, 0 , 0);
        myLibrary.addAdmin("Secondary", 102,true );
        myLibrary.addAdmin("Tertiary", 108,false );
        myLibrary.addGeneralUser("Nitty", 100, 100, 0 , 0);

    //Default Books
    
        myLibrary.addFiction(103, "Harry Potter", 103, 3, "JK");
        myLibrary.addNonfiction(102, "Bible", 700, 3, 100);
        myLibrary.addFiction(110, "Percy Jackson", 103, 0, "RR");
        myLibrary.addFiction(100, "Geronimo Stilton", 103, 0, "ED");
        myLibrary.addNonfiction(101, "Frogs", 700, 0, 200);
        myLibrary.addFiction(108, "Spongebob", 103, 0, "SH");

        

        Scanner sc = new Scanner(System.in);
        
        while (true){
            System.out.println("Welcome to the Library");
            System.out.println("Enter your User ID or type 0 to exit");

            int userID= sc.nextInt();
            
        //Admin
            if (myLibrary.findAdmin(userID)==true){
                System.out.println("Welcome Admin");
                
                
                while(true){
                    System.out.println("Menu: Enter the option number you want to select.");
                    System.out.println("1. Add a book");
                    System.out.println("2. Add a user");
                    System.out.println("3. Log out");
    
                    
                    int adminOption=sc.nextInt();
                    
                //Adding books
                    
                    if(adminOption==1){
                        
                        
                        System.out.println("Write the name of the book");
                        sc.nextLine();
                        String name=sc.nextLine();
    
                        System.out.println("How many pages are in the book?");
                        
                        int pages=sc.nextInt();
                        
                        sc.nextLine();
                        
                        System.out.println("How many books are you adding");
                        
                        int numberOfCopies=sc.nextInt();
                        
                        sc.nextLine();
                        
                        
                    //Adding fiction books
                        
                        while(true){
                            
                            System.out.println("Is this fiction or nonfiction?");
                            String fictionOrNot=sc.nextLine();
                    
                            if (fictionOrNot.equals("fiction")){
                                
                                System.out.println("What is the name of the Author?");
                                String author=sc.nextLine();
                                myLibrary.sortBooks();
                                int ID= myLibrary.getBookListSize()*100;
                                myLibrary.addFiction(ID, name, pages, numberOfCopies, author);
                                break;
                                
                            }
                            
                        //Adding nonfiction books
                            else if (fictionOrNot.equals("nonfiction")){
        
                                System.out.println("What is the serial number?");
                                int serial=sc.nextInt();
                                myLibrary.sortBooks();
                                int ID= myLibrary.getBookListSize()+100;
                                myLibrary.addNonfiction(ID, name, pages, numberOfCopies, serial);
                                break;
                                
                            }
                            
                            else{
                                System.out.println("Invalid Option");
                            }
                        }
                            
                    }
                    
                //Adding Users
                    
                    else if (adminOption==2){
                        System.out.println("Write the name of the user");
                        sc.nextLine();
                        String userName=sc.nextLine();
                        
                        System.out.println("Are you adding a General User or an Admin?");
                        
                        String userType=sc.nextLine();
                        
                        sc.nextLine();
                        
                        while(true){
                        
                            if(userType.equals("General User")){
                                System.out.println("How old is the user?");
                                int age= sc.nextInt();
                                sc.nextLine();
                                int numberOfBooks=0;
                                int overdueBooks=0;
                                int generalUserID=myLibrary.getUserListSize()*100;
                                myLibrary.addGeneralUser(userName, generalUserID, age, numberOfBooks, overdueBooks);
                                break;
                            }
                            
                            else if(userType.equals("Admin")){
                                System.out.println("Does this admin have partial or full access?");
                                String access= sc.nextLine();
                                int generalUserID=myLibrary.getUserListSize()*100;
                                break;
                                
                            }
                            
                            else{
                                System.out.println("Invalid Option");
                                
                            }
                        
                        }
                    }
                    
                    else if (adminOption==3){
                        System.out.println("Logging out");
                        break;
                    }
                    
                    else{
                        System.out.println("Invalid option");
                    }
                }
            }
            
            
            
        //General User
            else if (myLibrary.findGeneralUser(userID)==true){
                System.out.println("Welcome General User");
                while (true){
                    System.out.println("Menu: Enter the option number you want to select.");
                    System.out.println("1. Check out a book");
                    System.out.println("2. Return a book");
                    System.out.println("3.Log out");
                
                    int generalOption=sc.nextInt();
                    sc.nextLine();
                //checking out books
                    if (generalOption==1){
                        while(true){
                            System.out.println("Would you like a fiction or nonfiction book?");
                            String bookTypeChoice=sc.nextLine();
                            if(bookTypeChoice.equals("fiction")){
                                myLibrary.printFictionList();
                                System.out.println("Write the ID of the book you want.");
                                int fictionChoiceID=sc.nextInt();
                                sc.nextLine();
                                System.out.println("Write the date in yymmdd format with no slashes");
                                int fictionCheckOutDate= sc.nextInt();
                                sc.nextLine();
                                myLibrary.addBorrowBook(fictionChoiceID, userID, fictionCheckOutDate);
                                
                                break;
                            }
                            else if (bookTypeChoice.equals("nonfiction")){
                                myLibrary.printNonfictionList();
                                System.out.println("Write the ID of the book you want.");
                                int nonfictionChoiceID=sc.nextInt();
                                sc.nextLine();
                                System.out.println("Write the date in yymmdd format with no slashes");
                                int nonfictionCheckOutDate= sc.nextInt();
                                sc.nextLine();
                                myLibrary.addBorrowBook(nonfictionChoiceID, userID, nonfictionCheckOutDate);
    
                                break;
                                
                            }
                            else{
                                System.out.println("Invalid option");
        
                            }
                        
                        }
                        
                    }
                //returning books
                    else if (generalOption==2){
                        System.out.println("Write the ID of the book you want to return.");
                        int returnID=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Write the date in yymmdd format with no slashes");
                        int checkOutDate= sc.nextInt();
                        sc.nextLine();
                        myLibrary.addReturnBook(returnID, userID, checkOutDate);
                    }
                    else if (generalOption==3){
                        System.out.println("Logging out");
                        break;
                    }
                    else{
                        System.out.println("Invalid option");
                    }
                    
                }
                
            }
        //end program
            else if(userID==0){
            
                break;
            }
                
        //exception   
            else{
                System.out.println("Invalid User ID");
            }
        
        }
        
    }
}