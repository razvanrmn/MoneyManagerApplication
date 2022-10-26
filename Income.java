public class Income extends Accounts{
    private double amount;
    private String category;
    private String account;
    private double balance;

    public void setAmount(double amount){
        this.amount=amount;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public void setAccount(String account){
        this.account=account;
    }
    public void setBalance(double balance){
        this.balance=balance;
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
        return this.balance;
    }


    @Override
    public double convert() {
        return 0;
    }

    @Override
    public void transaction() {
        balance+=amount;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("");

        return str.toString();
    }

    @Override
    public void total() {

    }
}
