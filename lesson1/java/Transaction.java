public abstract class Transaction {
    private int id;
    private double amount;
    private String category;
    private String description;

    public Transaction(double amount, String category, String description) {
        this.amount = amount;
        this.category = category;
        this.description = description;
    }

    public double getAmount() {
        return this.amount;
    }

    public abstract String getType();

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public void displayInfo() {
        String type = this.getType();
        System.out.println("Transaction ID: " + this.id + "Type: " + type);
        System.out.println("Amount: " + this.amount + "| Category: " + this.category);
        System.out.println("Description: " + this.description);
    }
}