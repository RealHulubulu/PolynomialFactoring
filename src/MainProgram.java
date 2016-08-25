

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by karas_000 on 8/25/2016.
 */
public class MainProgram {

    public static void main(String[] args) {

        int a = 0;
        int b = 0;
        int c = 0;
        boolean userInput = false;
        boolean aInput = false;
        boolean bInput = false;
        boolean cInput = false;
        boolean imaginaryExists = false;
        char imaginary = Character.MIN_VALUE;
        Scanner scan = new Scanner(System.in);

        System.out.println("Solve a polynomial of the format ax^2 + bx + c.\nEnter integers a b c");
        while(!userInput) {
            try {
                while(aInput == false) {
                    System.out.print("Enter a value:\n");
                    a = scan.nextInt();
                    //scan.nextLine();
                    aInput = true;
                }while(bInput == false) {
                    System.out.print("Enter b value:\n");
                    b = scan.nextInt();
                    //scan.nextLine();
                    bInput = true;
                }while(cInput == false) {
                    System.out.print("Enter c value:\n");
                    c = scan.nextInt();
                    //scan.nextLine();
                    cInput = true;
                    userInput = true;
                }
                //scan.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Error: Must input integer values");
            }
            scan.nextLine();
        }

        //b +- root(b2 - 4ac)/2a

        double underRad = (b*b) - (4*a*c);
        if(underRad < 0){
            underRad = -underRad;
            imaginary = 'i';
            imaginaryExists = true;
        }
        double root = Math.sqrt(underRad);
        double topAndBottom = root/(2*a);
        if(imaginaryExists == true) {
            String imaginaryIncluded = Double.toString(topAndBottom);
            imaginaryIncluded = imaginaryIncluded + imaginary;
            System.out.println("The solutions include imaginary numbers and are:\nx = " + b + " + " + topAndBottom + imaginary + "\tx = " + b + " - " + topAndBottom + imaginary);
            System.out.println("Here is the output as a string/double combo:\nx = " + b + " + " + imaginaryIncluded + "\tx = " + b + " - " + imaginaryIncluded);
        } else {
            double wholeEquationAdd = b + topAndBottom;
            double wholeEquationSubtract = b - topAndBottom;

            System.out.println("The solutions are:\nx = " + wholeEquationAdd + "\tx = " + wholeEquationSubtract);
        }
    }
}
