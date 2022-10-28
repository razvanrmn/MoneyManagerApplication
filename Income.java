public class Income extends Accounts implements Cont{
    private double amount;
    private String category;
    private String account;
    public static double balance;

    public Income() {
        this.category = "Undefined";
        this.account = "Undefined";
        this.amount = -1;
    }

    public Income (Income i) {
        this.amount = i.amount;
        this.account = i.account;
        this.category = i.category;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public void setAccount(String account){
        this.account=account;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getCategory(){
        return this.category;
    }

    public String getAccount(){
        return  this.account;
    }

    public double getBalance(){
        return balance;
    }


    @Override
    public double convert() {
        return 0;
    }

    @Override
    public void transaction() {
        System.out.println("Income balance " +balance + " " + amount);
        balance+=amount;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append(account);
        str.append(" ");
        str.append(amount);
        str.append(" ");
        str.append(category);
        str.append(" ");
        return str.toString();
    }

    @Override
    public void total() {

    }
}
