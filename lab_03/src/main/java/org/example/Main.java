package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        IO.println(String.format("Hello and welcome!"));
        int l_p = Integer.parseInt(IO.readln("Wczytaj liczbe poziomow w choince: "));
        IO.println("Wczytano: "+l_p);
        for (int i=0; i<l_p;i++){
            for (int j = 0;j<=i;j++)
                IO.print("#");
            IO.println("");
        }
    }
}
