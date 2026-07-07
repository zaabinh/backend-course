public class Income extends Transaction {

    public Income(double amount, String category, String description) {

        super(amount, category, description);
    }

    @Override
    public String getType() {
        return "INCOME";
    }
}