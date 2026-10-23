import java.util.Scanner;

public class WeightConversionProgram {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Weight Conversion Program");
        System.out.println("1: Convert lbs to kgs");
        System.out.println("2: Convert kgs to lbs");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        if (option == 1){
            System.out.print("Enter the weight in lbs: ");
            double weightInLbs;
            double kg;
            weightInLbs = scanner.nextDouble();
            kg = weightInLbs * 0.4536;
            System.out.printf("The new weight in kg is: %.2f", kg);
        }
        else if (option == 2){
            System.out.print("Enter the weight in kgs: ");
            double weightInLbs;
            double kg;
            kg = scanner.nextDouble();
            weightInLbs = kg / 0.4536;
            System.out.printf("The new weight in kg is: %.2f", weightInLbs);
        }

    }
}
