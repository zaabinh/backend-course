import java.util.ArrayList;

public class FinanceService {
    private ArrayList<Transaction> transactions = new ArrayList <> ();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void showAllTransactions() {
        for(Transaction t : transactions) {
            t.displayInfo();
        }
    }

    public double calculateIncome() {
        double total = 0;
        for(Transaction t : transactions) {
            if(t instanceof Income) total += t.getAmount();
        }
        return total;
    }

    public double calculateExpense() {
        double total = 0;
        for(Transaction t : transactions) {
            if(t instanceof Expense) total += t.getAmount();
        }
        return total;
    }

    public double calculateBalance() {
        return calculateIncome() - calculateExpense();
    }

}