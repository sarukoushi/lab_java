/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;

class Main {
  public static void main(String[] args) {
    Service s = new Service();
    while(true){
      try {
        IO.println(
          "\n################################\n"+
          "# Choose what to do:\n"+
          "################################\n"+
          "# (1) Input new student.\n"+
          "# (2) Wyczytaj zapisanych studentów..\n"+
          "#-------------------------------\n"+
          "# (x) Close the app.\n"+
          "################################\n"
        );
        String act = IO.readln("Choose option: ");
        IO.println("Option you have choosen: "+ act);
        if(act.equals("x")) {
          IO.println("Exiting app...");
          break;
        }
        else{
          switch(Integer.parseInt(act)){
            case 1:
              s.addStudent(new Student(
                  IO.readln("Input first name: "),
                  IO.readln("Input last name: "),
                  Integer.parseInt(IO.readln("Input his/her age: "))
                  )
              );
              break;
            case 2:
              IO.println("Students list:");
              var students = s.getStudents();
              for(Student current : students) {
                System.out.println("  "+current.ToString());
              }
              IO.readln("Press ENTER to proceed.");
              break;
            default:
          }
        }

      } catch (IOException e) {
        IO.println(e);
      }
    }
  }
}