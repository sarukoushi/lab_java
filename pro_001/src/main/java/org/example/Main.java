package org.example;

public class Main {
  public int counter = 0;
  public void main() {
    Greet();
    input();
    Suma();
    Kalkulator();
    Parzyste();
    Pierwsza();
  }
  public void Greet(){
    counter++;
    IO.println(String.format("Hello world!"));
    IO.println(counter);
  }
  public void input(){
    counter = Integer.parseInt(IO.readln("Input a number: "));
    IO.println("Your number: "+counter);
  }
  public void Suma(){
    IO.println("Enter a and b and program will output sum:");
    double a = Double.parseDouble(IO.readln("Enter a="));
    double b = Double.parseDouble(IO.readln("Enter b="));
    IO.println("Sum: " + (a+b));
  }
  public void Kalkulator() {
    while (true) {
      int op = 9;
      IO.println("Calculator choose an option:");
      IO.println(" [0]: Exit calc.");
      IO.println(" [1]: Suma");
      IO.println(" [2]: Różnica");
      IO.println(" [3]: Iloczyn");
      IO.println(" [4]: Iloraz");
      IO.println(" [5]: Pole prostokąta");
      IO.println(" [6]: Pole trójkąta");
      IO.println(" [7]: c^2=[?]=a^2+b^2");
      IO.println(" [8]: Najmniejsza liczba z podanych a,b i c");
      try {
        op = Integer.parseInt(IO.readln("Option: "));
      }catch(Exception e){
        IO.println("ERROR: "+e);
        continue;
      }
      switch (op) {
      case 0:
        IO.println("Closing calc...");
        return;
      case 1:
        IO.println("Suma:");
        try {
          double a = Double.parseDouble(IO.readln(" a ="));
          double b = Double.parseDouble(IO.readln(" b ="));
          IO.println("Suma a+b=" + (a + b));
        }catch (Exception e){
          IO.print("ERROR: "+e);
          break;
        }
        break;
      case 2:
        try {
        IO.println("Różnica:");
        double a = Double.parseDouble(IO.readln(" a ="));
        double b = Double.parseDouble(IO.readln(" b ="));
        IO.println("Suma a-b="+(a-b));
        }catch (Exception e){
          IO.print("ERROR: "+e);
          break;
        }
        break;
      case 3:
        try {
        IO.println("Iloczyn:");
          double a = Double.parseDouble(IO.readln(" a ="));
          double b = Double.parseDouble(IO.readln(" b ="));
        IO.println("Suma a*b="+(a*b));
        }catch (Exception e){
          IO.print("ERROR: "+e);
          break;
        }
        break;
      case 4:
        try {
        IO.println("Iloraz:");
          double a = Double.parseDouble(IO.readln(" a ="));
          double b = Double.parseDouble(IO.readln(" b ="));
        if (b==0) IO.println("Nie dzieli się przez zero!!");
        else IO.println("Suma a/b="+(a/b));
        }catch (Exception e){
          IO.print("ERROR: "+e);
          break;
        }
        break;
      case 5:
        try {
        IO.println("Pole prostokąta:");
          double a = Double.parseDouble(IO.readln(" bok a ="));
          double b = Double.parseDouble(IO.readln(" bok b ="));
        IO.println("Pole="+(a*b)+"[j^2]");
        }catch (Exception e){
          IO.print("ERROR: "+e);
          break;
        }
        break;
      case 6:
        try {
        IO.println("Pole trójkąta:");
          double a = Double.parseDouble(IO.readln(" bok a ="));
          double b = Double.parseDouble(IO.readln(" bok b ="));
        double c = Double.parseDouble(IO.readln(" bok c ="));
        if (a<=0 || b<=0 || c<=0){
          IO.println("Side of a triangle can't be zero or lesser than zero.");
          break;
        }
        double p = (a+b+c)/2;
        IO.println("Pole="+(Math.sqrt(p*(p-a)*(p-b)*(p-c)))+"[j^2]");
        }catch (Exception e){
          IO.print("ERROR: "+e);
          break;
        }
        break;
      case 7:
        try {
        IO.println("a^2+b^2=c^2:");
          double a = Double.parseDouble(IO.readln(" a ="));
          double b = Double.parseDouble(IO.readln(" b ="));
        IO.println("a^2+b^2="+((Math.pow(a,2))+(Math.pow(b,2))));
        }catch (Exception e){
          IO.print("ERROR: "+e);
          break;
        }
        break;
      case 8:
        try {
        IO.println("Najmniejsza liczba:");
          double a = Double.parseDouble(IO.readln(" a ="));
          double b = Double.parseDouble(IO.readln(" b ="));
          double c = Double.parseDouble(IO.readln(" c ="));
        double d = a;
        if (b>a) d=b;
        if (c>a) d=c;
        IO.println("Najmniejsza liczba = ["+d+"]");
        }catch (Exception e){
          IO.print("ERROR: "+e);
          break;
        }
        break;
      default:
        IO.println("Wrong option, choose one from [0,1,2,3,4,5,6,7,8]");
        break;
      }
    }
  }
  public void Parzyste(){
    IO.println("Liczby parzyste od zera do 100:");
    IO.print("[");
    for (int i=0;i<=100;i=i+2){
      IO.print(i+", ");
    }
    IO.print("]");
  }
  public void Pierwsza(){
    IO.println("Check whether a number is a prime:");
    double n = 0;
    while(true) {
      try {
        n = Integer.parseInt("Input a number: ");
        break;
      } catch (Exception e) {
        IO.println("ERROR: "+e);
      }
    }
    if (n <= 1)
      IO.println("Not a prime number");
    // Check divisibility from 2 to n-1
    for (int i = 2; i < n; i++)
    {
      if (n % i == 0) IO.println("Not a prime number");
    }
    IO.println("It is a prime number!");
  }
}
