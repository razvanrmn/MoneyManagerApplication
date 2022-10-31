
    public class Expense extends Accounts implements Cont{
        private double amount;
        private String category;
        private String account;
        public static double balance;
        public static double total;

        public Expense() {
            this.category = "NULL";
            this.account = "NULL";
            this.amount = -1;

        }
        public Expense(String category, String account, double amount) {
            this.category = category;
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void transaction() {
            balance -= amount;
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
        public double getAmount() {
            return this.amount;
        }

        public double getBalance() {
            return balance;
        }

        public String getAccount() {
            return account;
        }

        public String getCategory() {
            return category;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        @Override
        public void total() {
            total+=amount;
        }
    }

