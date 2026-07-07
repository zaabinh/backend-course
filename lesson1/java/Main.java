import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinanceService service = new FinanceService();

        while (true) {
            System.out.println("\n===== Finance Manager =====");
            System.out.println("1. Add income");
            System.out.println("2. Add expense");
            System.out.println("3. Show all transactions");
            System.out.println("4. Show summary");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1 || choice == 2) {
                System.out.print("Amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Category: ");
                String category = scanner.nextLine();

                System.out.print("Description: ");
                String description = scanner.nextLine();

                boolean type = choice == 1;
                Transaction transaction;
                if(choice == 1)
                    transaction = new Income(amount, category, description);
                else transaction = new Expense(amount, category, description);
                service.addTransaction(transaction);

                System.out.println("Transaction added successfully.");
            } else if (choice == 3) {
                service.showAllTransactions();
            } else if (choice == 4) {
                System.out.println("Total income: " + service.calculateIncome());
                System.out.println("Total expense: " + service.calculateExpense());
                System.out.println("Balance: " + service.calculateBalance());
            } else if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}