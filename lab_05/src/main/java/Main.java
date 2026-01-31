/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.lang.classfile.instruction.ArrayLoadInstruction;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
  // color
  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = "\u001B[0;38;2;192;28;40;49m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";
  public static final String ORANGE = "\u001B[0;38;2;198;70;0;49m";
  // color end


  public static void main(String[] args) {
    // Pattern pattern_main_1 = Pattern.compile("+");
    // Pattern pattern_main_1 = Pattern.compile("([yY][eE][sS])+");
    Matcher matcher_main;
    Service s = new Service();
    while(true){
      try {
        IO.println(YELLOW+
          "\n-------------------------------\n"+
          " Choose what to do:\n"+
          "-------------------------------\n"+
          " (1) Input new student.\n"+
          " (2) Read whole students database.\n"+
          " (3) Update student data.\n"+
          " (4) Delete student by specyfying a pattern (valid patterns same as for the option (4)).\n"+
          " (5) Find students based on pattern (not case sensitive):\n"+
          "     Database stores student data in the following format:\n"+
          "         [[index] name surname [age] (date of birth [dd-mm-yy])]\n"+
          "       Any leading or following whitespaces will be cut off.\n"+
          "       example of the database format:\n"+
          "         [178 Kira Yoshikage 10 12-12-1830]\n"+
          "       examples:\n"+
          "         [Donald Retusz 59] -> Will look for anything with [(...)donald retusz 59(...)].\n"+
          "         [12-12-1999] -> Will look for anything with [(...)12-12-1999(...)].\n"+
          "         [    18] -> Will look for anything with [(...)18(...)].\n"+
          "         [kora  ] -> Will look for anything with [(...)kora(...)].\n"+
          "         [Seb Mitsuki] -> Will look for anything with [(...)seb mitsuki(...)].\n"+
          "         [Sebastian M] -> Will look for anything with [seb m(...)].\n"+
          "         [an M] -> Will look for anything with [(...)an m(...)].\n"+
          "-------------------------------\n"+
          " (x) Close the app.\n"+
          "-------------------------------\n"+RESET
        );
        String act = IO.readln(YELLOW+"Choose option: "+RESET);
        IO.println(YELLOW+"Option you have choosen: "+ act+RESET);
        if(act.equals("x")) {
          IO.println(YELLOW+"-------------------------------"+RESET);
          IO.println(YELLOW+"Exiting app(...)"+RESET);
          IO.println(YELLOW+"-------------------------------"+RESET);
          break;
        }
        else{
          int num = Integer.parseInt(act);
          switch(num){
            case 1:{
              Pattern pattern = Pattern.compile("[0-9]+");
              Matcher matcher;
              // matcher = pattern.matcher(current);
              IO.println(YELLOW+"-------------------------------"+RESET);
              String ne = IO.readln(YELLOW+"Input first name: "+RESET).trim();
              matcher = pattern.matcher(ne);
              if(matcher.find()){
                throw new IOException("Name cannot contain numbers.");
              }
              String se = IO.readln(YELLOW+"Input last name: "+RESET).trim();
              matcher = pattern.matcher(se);
              if(matcher.find()){
                throw new IOException("Surame cannot contain numbers.");
              }
              int ag = Integer.parseInt(IO.readln(YELLOW+"Input his/her age: "+RESET).trim());
              int dd = Integer.parseInt(IO.readln(YELLOW+"Input day of birth: "+RESET).trim());
              int mm = Integer.parseInt(IO.readln(YELLOW+"Input month of birth: "+RESET).trim());
              int yy = Integer.parseInt(IO.readln(YELLOW+"Input year of birth: "+RESET).trim());
              s.addStudent(new Student(ne,se,ag,dd,mm,yy));
              IO.println(YELLOW+"-------------------------------"+RESET);
              s.ReadDB();  
              break;
            }
            case 2:
                  IO.println(YELLOW+"-------------------------------"+RESET);
              IO.println(YELLOW+"Students list:"+RESET);
              var students = s.getStudents();
              if(students.size()==0){
                IO.println(YELLOW+"Students list: is EMPTY"+RESET);
              IO.readln(YELLOW+"Press ENTER to proceed."+RESET);
                break;
              }
              for(Student current : students) {
                System.out.println(CYAN+"  "+current.ToString()+RESET);
              }
                  IO.println(YELLOW+"-------------------------------"+RESET);
              IO.readln(YELLOW+"Press ENTER to proceed."+RESET);
                  IO.println(YELLOW+"-------------------------------"+RESET);
              break;
            case 3:{
              IO.println(YELLOW+"-------------------------------"+RESET);
              IO.println(YELLOW+" Updating student data."+RESET);
              IO.println(YELLOW+"-------------------------------"+RESET);
              String nom = IO.readln(YELLOW+"  Specify student's database index + name + surname, in the following format: [index name surname].\n  If don't know them, go back and choose \"Find students...\" option.\n  -->:"+RESET);
              var find_echo = s.findStudentByPattern(nom);
              ArrayList<Integer> up_line_indices = new ArrayList<>();
              ArrayList<String> up_line_studs = new ArrayList<>();
              int matchs = 0;
              for(Object obj : find_echo){
                if(obj instanceof Integer matches_count){
                  IO.println(CYAN+"  Found matches: ["+matches_count+"]"+RESET);// matches number
                  if(matches_count==0 || matches_count>1){
                    IO.println(YELLOW+"  Wrong number of matches, it has to be only a single match.\n  If you are not sure about student's index/name/surname, check them by choosing \"Find students...\" option in main menu."+RESET);// matches number
                    matchs=matches_count;
                    break;
                  }
                    matchs=matches_count;
                }else if(obj instanceof ArrayList < ? >){
                  // IO.println("Class: "+obj.getClass());
                  ArrayList<?> lili = (ArrayList<?>)obj;
                  if(lili.get(0) instanceof Integer){
                    up_line_indices = (ArrayList<Integer>)obj;
                  }else if(lili.get(0) instanceof String){
                    up_line_studs = (ArrayList<String>)obj;
                  }
                }
              }
              if(matchs==1){
              IO.println("Data of student: "+up_line_studs+" will be updated.");
              int op = Integer.parseInt(IO.readln(
                "  Choose what student data to update:\n"+
                "  (1) Name\n"+
                "  (2) Surname\n"+
                "  (3) Age\n"+
                "  -->:"
              ));

              switch(op){
                case 1:{
                  String nm = IO.readln(
                    "New name: "
                  );
                  ArrayList<Student> new_st = s.getStudents();
                  new_st.remove(up_line_indices.get(0)-1);
                  s.RemakeDB(new_st);
                  s.addStudent(Student.ParseNewName(up_line_studs.get(0),nm));                 
                  break;}
                case 2:{
                  String sm = IO.readln(
                    "New surname: "
                  );
                  ArrayList<Student> new_st = s.getStudents();
                  new_st.remove(up_line_indices.get(0)-1);
                  s.RemakeDB(new_st);
                  s.addStudent(Student.ParseNewSurname(up_line_studs.get(0),sm)); 
                  break;}
                case 3:{
                  int ae = Integer.parseInt(IO.readln(
                    "New age: "
                  ));
                  ArrayList<Student> new_st = s.getStudents();
                  new_st.remove(up_line_indices.get(0)-1);
                  s.RemakeDB(new_st);
                  s.addStudent(Student.ParseNewAge(up_line_studs.get(0),ae)); 
                  break;}
              }
              s.ReadDB();
              }
              IO.readln(YELLOW+"Press ENTER to proceed."+RESET);
              IO.println(YELLOW+"-------------------------------"+RESET);
              break;}
            case 4:{
              IO.println(YELLOW+"-------------------------------"+RESET);
              String the_nome = IO.readln(ORANGE+"  Input a pattern that specifies a student/students for removal from database:\n  pattern-->: "+RESET);
              var find_echo = s.findStudentByPattern(the_nome);
              ArrayList<Integer> del_line_indices = new ArrayList<>();
              ArrayList<String> del_line_studs = new ArrayList<>();
              for(Object obj : find_echo){
                if(obj instanceof Integer matches_count){
                  IO.println(CYAN+"   Found matches: ["+matches_count+"]"+RESET);// matches number
                  if(matches_count==0){break;}
                }else if(obj instanceof ArrayList < ? >){
                  // IO.println("Class: "+obj.getClass());
                  ArrayList<?> lili = (ArrayList<?>)obj;
                  if(lili.get(0) instanceof Integer){
                    del_line_indices = (ArrayList<Integer>)obj;
                  }else if(lili.get(0) instanceof String){
                    del_line_studs = (ArrayList<String>)obj;
                  }
                }
              }
              // IO.println("Indices: "+del_line_indices);
              IO.println(ORANGE+"  Removing following students from database:"+RESET);
              for(var st : del_line_studs){
                IO.println(CYAN+"   "+st+RESET);
              }
              String ans = IO.readln(ORANGE+"  Do you want to proceed? [Default:N,Yes]: "+RESET).trim();
              Pattern pattern1 = Pattern.compile("([yY][eE][sS])+");
              // Pattern pattern2 = Pattern.compile("[^yY]+");
              Matcher matcher;
              matcher = pattern1.matcher(ans.trim());
              ArrayList<Student> neu_studs = s.getStudents();
              int del_count=0;
              if(matcher.find()){ // yes, delete
                IO.println(ORANGE+"  Removal approved."+RESET);
                // IO.println("  "+del_line_indices);

                for(var i : del_line_indices){
                  // IO.println(neu_studs);
                  neu_studs.remove(i-1-del_count);
                  del_count++;
                }
              }else{
                IO.println(ORANGE+"  Removal not approved."+RESET);
              }
              s.RemakeDB(neu_studs);
              IO.readln(ORANGE+"  Press ENTER to proceed."+RESET);
              break;
            }
            case 5:{
                  IO.println(YELLOW+"-------------------------------");
                  String the_name = IO.readln("  Input pattern for which to look for inside database:\n  your pattern: ");
                  var find_echo = s.findStudentByPattern(the_name);
                  ArrayList<String> found_studds = new ArrayList<>();
                  for(Object obj : find_echo){
                    if(obj instanceof Integer matches_count){
                      IO.println(CYAN+"   Found matches: ["+matches_count+"]"+RESET);// matches number
                      if(matches_count==0){break;}
                    }else if(obj instanceof ArrayList < ? >){
                      // IO.println("Class: "+obj.getClass());
                      ArrayList<?> lili = (ArrayList<?>)obj;
                      if(lili.get(0) instanceof String){
                        found_studds = (ArrayList<String>)obj;
                      }
                    }
                  }

                  IO.println(YELLOW+"  Found students:"+RESET);// matches number
                  for(var curr: found_studds){
                    IO.println(CYAN+"   ["+curr+"]"+RESET);// matches number
                  }
                  IO.println(YELLOW+"-------------------------------");
                  IO.readln("Press ENTER to proceed."+RESET);

              break;
            }
            default:
              throw new IOException("Invalid option specified.");
          }
        }

      } catch (Exception e) {
                  IO.println(RED+"-------------------------------");
        IO.println("[OPINFO] [ERROR]: EXCEPTION OCCURED MSG:");
        IO.println(e);
        IO.println("[OPINFO] [ERROR]: EXCEPTION MSG END");
                  IO.println("-------------------------------");
                  IO.readln("Press ENTER to proceed."+RESET);
      }
    }
  }
}