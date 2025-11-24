package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void ex3_1(){
        IO.println(String.format("Hello and welcome!"));
        int l_p = Integer.parseInt(IO.readln("Wczytaj liczbe poziomow w choince: "));
        IO.println("Wczytano: "+l_p);
        for (int i=0; i<l_p;i++){
            for (int j = 0;j<=i;j++)
                IO.print("#");
            IO.println(""); 
        }
    }

    public static void kwadrat(){
        IO.println(String.format("Hello and welcome!"));
        int l_p = Integer.parseInt(IO.readln("Wczytaj liczbe poziomow w choince: "));
        IO.println("Wczytano: "+l_p);
        for (int i=0; i<l_p;i++){
            if (i==0){
                for (int j = 0;j<l_p;j++){
                    IO.print("#");
                }
            }
            
            if (i<(l_p-1) && i!=0){
                IO.println(" ");
                IO.print("#");
                for (int j = 0; j<(l_p-2); j++){
                    IO.print(" ");
                }
                IO.print("#");
            }else if (i==(l_p-1)){
                IO.println(" ");
                for (int j = 0;j<l_p;j++)
                    IO.print("#");

            }
        }
        IO.println(" ");
    }
    
    public static void trojkat(){
        IO.println(String.format("Hello and welcome!"));
        int l_p = Integer.parseInt(IO.readln("Wczytaj liczbe poziomow w choince: "));
        IO.println("Wczytano: "+l_p);
        for (int i = 0; i<l_p; i++){
            if(i==0){
                for (int j = 0; j<(l_p-1); j++){
                    IO.print(" ");
                }
                IO.print("#");
            }
            if(i!=0 && i<(l_p-1)){
                IO.println("");
                for(int j = 0; j<(l_p-i-1) ;j++){
                    IO.print(" ");
                }
                IO.print("#");
                for(int j = 0; j<(i-1); j++){
                    IO.print(" ");
                }
                IO.print("#");
            }
            if(i==(l_p-1)){
                IO.println("");
                for(int j = 0; j<l_p; j++){
                    IO.print("#");
                }
                IO.println("");
            }
        }
    }
    static void main() {
        // ex3_1();
        // kwadrat();
        trojkat();
    }
}
