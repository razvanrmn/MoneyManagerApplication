
    public class Expense extends Accounts {
        private double amount;
        private String category;
        private String account;
        public static double balance;
        private final double EUR = 4.90;
        private final double USD = 4.96;
        private final double HUF = 1.18;

        public Expense() {
            this.category = "Undefined";
            this.account = "Undefined";
            this.amount = -1;
        }

       // @Override
        public double convert(String option) {
            if (option.equals("EUR")) {
                return amount * EUR;
            } else if (option.equals("USD")) {
                return amount * USD;
            } else if (option.equals("HUF")) {
                return amount * HUF;
            } else {
                return -1;
            }
        }

        @Override
        public double convert() {
            return 0;
        }

        @Override
        public void transaction() {
            System.out.println("Expense balance " + balance + " " + amount);
            balance-=amount;
        }

        @Override
        public String toString() {
            StringBuffer str = new StringBuffer();
            str.append("You spent : ");
            str.append(amount);
            str.append(" on ");
            str.append(category);
            return str.toString();
        }

        @Override
        public void total() {

        }

        public double getAmount() {
            return amount;
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

        public void setBalance(double balance) {
            balance = balance;
        }

        public void setCategory(String category) {
            this.category = category;
        }

    }

