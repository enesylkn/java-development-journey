import java.util.Scanner;

public class BankingProgram {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double bank_wallet = 0;
        boolean exit = false;
        menu();

        while(!exit){
            choice = scanner.nextInt();
            if(choice == 1){
                System.out.printf("$ %.1f\n",bank_wallet);
                menu();
                exit = false;
            }
            else if (choice == 2){
                System.out.print("How many cash you want to deposit?");
                double deposit_amount = scanner.nextDouble();
                bank_wallet += deposit_amount;
                menu();
            }
            else if(choice == 3){
                System.out.print("How many cash you want to withdraw?");
                double withdraw_amount = scanner.nextDouble();
                if(bank_wallet >= withdraw_amount){
                    bank_wallet -= withdraw_amount;
                }
                else{
                    System.out.println("You don't have enough money!");
                    for (int i = 5; i >= 0 ; i--){
                        System.out.println(i);
                        Thread.sleep(1000);
                    }
                    System.out.println("BOOM! \uD83D\uDD95");
                    break;
                }
                menu();
            }
            else if(choice == 4){
                exit = true;
            }
            else {
                System.out.println("Invalid Order!");
                menu();
            }
        }

    }
    static void menu(){
        System.out.println("***************");
        System.out.println("BANKING PROGRAM");
        System.out.println("***************");
        System.out.println("1. Show Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("***************");
        System.out.print("Enter your choice (1-4): ");
    }
}