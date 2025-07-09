public class Admin extends User {
    private boolean access;
    public Admin(String name, int ID, boolean access){
        super(name, ID);
        this.access=access;
    }
    
    public boolean getAccess(){
        return access;
    }
    public void setAccess(boolean access){
        this.access=access;
    }
}