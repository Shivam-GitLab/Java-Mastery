class BankAccount{
    double balance;
    public BankAccount(double balance){
        this.balance = balance;
    }
    public void withdraw(double amount) throws InsufficientFundsException{
        if(amount > balance){
            throw new InsufficientFundsException();
        }
        balance -= amount;
    }
    public void deposit(double amount){
        balance += amount;
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        try{
            bankAccount.withdraw(2000);
        }catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
            System.out.println(e);
        }
        finally {
            try {
                int x = 50;
                //connection closed
            } catch (Exception e) {
                //connection not successfully closed
            }
        }
    }
}