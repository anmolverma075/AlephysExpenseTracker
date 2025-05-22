import java.util.Scanner;

public class AlephysExpenseTrackerApp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AlephysManager manager = new AlephysManager();

        while(true){
            System.out.println("\n-------- Welcome to Alephys Expense Tracker --------");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Monthly Summary");
            System.out.println("4. Save Records to File");
            System.out.println("5. Load Records from File");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 1){
                System.out.print("Enter income source: ");
                String cat = sc.nextLine();
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                manager.add("income", cat, amt);
            }
            else if(choice == 2){
                System.out.print("Enter expense type : ");
                String cat = sc.nextLine();
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                manager.add("expense", cat, amt);
            }
            else if(choice == 3){
                System.out.print("Enter month number: ");
                int m = sc.nextInt();
                manager.summary(m);
            }
            else if(choice == 4){
                System.out.print("Enter filename to save: ");
                String file = sc.nextLine();
                manager.save(file);
            }
            else if(choice == 5){
                System.out.print("Enter filename to load : ");
                String file = sc.nextLine();
                manager.load(file);
            }
            else if(choice == 6){
                System.out.println("Thank you for using Alephys Expense Tracker!");
                break;
            }
            else{
                System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }
}
