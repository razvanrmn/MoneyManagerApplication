package Application;

public abstract class Accounts implements Cont {
    private double amount;
    private String category;
    private String account;

    public Accounts(){
        amount=-1;
        category="Null";
        account="Null";
    }
    public abstract void transaction ();
    public abstract String toString();
    public abstract void total();

}
