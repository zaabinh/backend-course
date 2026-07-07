public class Expense extends Transaction{
    public Expense(double amount, String category, String description){
        super(amount, category, description);
    }

    @Override
    public String getType() {
        return "EXPENSE";
    }
}
