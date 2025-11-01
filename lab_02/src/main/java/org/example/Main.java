package org.example;
import java.security.spec.ECField;
import java.util.Arrays;

public class Main {
  /*
   * Main function
   */
  public void main() {
    Greet();
    input();
    Sum();
    Calculator();
    Even();
    isAPrime();
  }

  /*
   * Greeting function:
   * Just greets when called.
   */
  public void Greet(){
    if (expand_ex_sol("Zadanie2_1. Hello World")){
      IO.println("  Hello World!!!");
    }
  }

  /*
   * User input function:
   * Asks for an integer input and echoes it. 
   */
  public void input(){
    if (expand_ex_sol("Zadanie2_2. Wypisywanie liczby")){
      while (true){
        try{
          int num = Integer.parseInt(IO.readln("Input a integer: "));
          IO.println("  Your integer: "+ num);
          break;
        }catch (Exception e){
          IO.println("Exception catched: "+e);
        }
      }
    }
  }

  /*
   * Output sum of a and b numbers
   */
  public void Sum(){
    if (expand_ex_sol("Zadanie2_3. Suma")){
      IO.println("Enter a and b and program will output sum:");
      while (true){
        try{
          double a = Double.parseDouble(IO.readln(" a = "));
          double b = Double.parseDouble(IO.readln(" b = "));
          IO.println("  a + b: " + (a+b));
          break;
        }catch(Exception e){
          IO.println("Exception catched: " + e);
        }
      }
    }
  }

  /*
   * Simple calculator
   */
  public void Calculator() {
    if (expand_ex_sol("Zadanie2_4. Kalkulator")){
      while (true) {
        int op = 9;
        IO.println("Calculator: choose an option:");
        IO.println(" [0]: Exit calc.");
        IO.println(" [1]: Sum");
        IO.println(" [2]: Subtraction");
        IO.println(" [3]: Product");
        IO.println(" [4]: Quotient");
        IO.println(" [5]: Rectangle area");
        IO.println(" [6]: Triangle area");
        IO.println(" [7]: Sum of squares = a^2 + b^2 ");
        IO.println(" [8]: Smallest number");
        try {
          op = Integer.parseInt(IO.readln("Option: "));
        }catch(Exception e){
          IO.println("Exception catched: "+e);
          continue;
        }
        switch (op) {
          case 0:
            IO.println("Closing calc...");
            return;
          case 1:
            IO.println("Sum:");
            try {
              double a = Double.parseDouble(IO.readln(" a = "));
              double b = Double.parseDouble(IO.readln(" b = "));
              IO.println("  a + b = " + (a + b));
            }catch (Exception e){
              IO.println("Exception catched: "+e);
              break;
            }
            break;
          case 2:
            try {
              IO.println("Subtraction:");
              double a = Double.parseDouble(IO.readln(" a = "));
              double b = Double.parseDouble(IO.readln(" b = "));
              IO.println("  a - b = "+(a-b));
            }catch (Exception e){
              IO.println("Exception catched: "+e);
              break;
            }
            break;
          case 3:
            try {
              IO.println("Product:");
              double a = Double.parseDouble(IO.readln(" a = "));
              double b = Double.parseDouble(IO.readln(" b = "));
              IO.println("  a * b = "+(a*b));
            }catch (Exception e){
              IO.println("Exception catched: "+e);
              break;
            }
            break;
          case 4:
            try {
              IO.println("Quotient:");
              double a = Double.parseDouble(IO.readln(" a = "));
              double b = Double.parseDouble(IO.readln(" b = "));
              if (b==0) throw new Exception("Division by zero");
              else IO.println(" a / b = "+(a/b));
            }catch (Exception e){
              IO.println("Exception catched: "+e);
              break;
            }
            break;
          case 5:
            try {
              IO.println("Rectangle area:");
              double a = Double.parseDouble(IO.readln(" side a = "));
              double b = Double.parseDouble(IO.readln(" side b = "));
              if ( a <= 0 || b <= 0 ) throw new Exception("Side length has to be greater than zero.");
              IO.println("  Area = "+(a*b));
            }catch (Exception e){
              IO.println("Exception catched: "+e);
              break;
            }
            break;
          case 6:
            try {
              IO.println("Triangle area:");
              double a = Double.parseDouble(IO.readln(" side a ="));
              double b = Double.parseDouble(IO.readln(" side b ="));
              double c = Double.parseDouble(IO.readln(" side c ="));
              if ( a <= 0 || b <= 0 || c <= 0 ) throw new Exception("Side length has to be greater than zero.");
              double p = ( a + b + c ) / 2;
              IO.println("  Area = " + ( Math.sqrt( p * ( p - a ) * ( p - b ) * ( p - c ) ) ) );
            }catch (Exception e){
              IO.println("Exception catched: "+e);
              break;
            }
            break;
          case 7:
            try {
              IO.println("Sum of squares:");
              double a = Double.parseDouble(IO.readln(" a = "));
              double b = Double.parseDouble(IO.readln(" b = "));
              IO.println("  a^2 + b^2 = " + ( ( Math.pow(a, 2) ) + ( Math.pow(b, 2) ) ) );
            }catch (Exception e){
              IO.println("Exception catched: "+e);
              break;
            }
            break;
          case 8:
            try {
              IO.println("Smallest number:");
              double a = Double.parseDouble(IO.readln(" a = "));
              double b = Double.parseDouble(IO.readln(" b = "));
              double c = Double.parseDouble(IO.readln(" c = "));
              double d = a;
              if (b<d) d=b;
              if (c<d) d=c;
              IO.println("  Smallest number = "+d);
            }catch (Exception e){
              IO.println("Exception catched: "+e);
              break;
            }
            break;
          default:
            IO.println("Wrong option, choose one from [0,1,2,3,4,5,6,7,8]");
            break;
        }
      }
    }

  }

  /*
   * Output a sequence of even numbers in 0 to 100 range.
   */
  public void Even(){
    if (expand_ex_sol("Zadanie2_5. Liczby parzyste")){
      IO.println("Even numbers inside 0 to 100 range:");
      IO.print("  [");
      for (int i=0;i<=100;i=i+2){
        IO.print(i+", ");
      }
      IO.println("]");
    }
  }

  /*
   * Check whether input number is a prime
   */
  public void isAPrime(){
    if (expand_ex_sol("Zadanie2_6. Test liczby pierwszej.")){
      IO.println("Check whether a number is a prime:");
      int n = 0;
      while(true) {
        try {
          n = Integer.parseInt(IO.readln("Input a integer: "));
          break;
        } catch (Exception e) {
          IO.println("Exception catched: "+e);
        }
      }
      if (n <= 1){ // Prime number is greater than 1
        IO.println("  Lesser than or equal to 1 is not a prime number!");
        return;
      }
        // trial division method but with non prime denominators included so the program is not optimized
      for (int i = 2; i < n; i++){
        if (n % i == 0){ 
          IO.println("  It is not a prime number.");
          return;
        }
      }
      IO.println("  It is a prime number!");
    }
  }

  /*
   * Ask if to expand solution.
   */
  public boolean expand_ex_sol(String ex){
    while(true){
      try{
        String c = IO.readln("Do you want to execute a solution to ["+ex+"] exercise: [Y|y] [N|n]? => ").toLowerCase();
        if (c.equals("n")) {
          IO.println("Skipping solution to ["+ex+"] exercise.");
          return false;
        }else if ( !(c.equals("y")) ){
          throw new Exception("Input error: Wrong input, expected [N|n|Y|y] statement, got:["+c+"]");
        }
        IO.println("Executing solution:");
        break;
      }catch(Exception e){
        IO.println("Catched exception: " + e);
      }
    }
    return true;
  }
}
