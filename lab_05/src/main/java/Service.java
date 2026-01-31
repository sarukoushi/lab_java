import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.regex.Matcher;
import java.util.regex.*;
public class Service {

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

  public Service(){
    ReadDB();
  }

  // public void remakeDatabase(int buffered_index,ArrayList<Student> stud_old_list){

  // }

  public static ArrayList<String> students_list;

  public Student initStudent = new Student(); 
  
  public void RemakeDB(ArrayList<Student> new_studs) {
    try{
      ArrayList<Student> stud_li = new_studs;
      var f = new FileWriter("db.txt", false);
      var b = new BufferedWriter(f);
      b.append(String.valueOf(initStudent.GetHighestIndex()));
      b.newLine();
      b.close();
      if(!(stud_li.isEmpty())){
        for (Student stud : stud_li){
          addStudent(stud);
        }
      }
    }catch(Exception e){
      IO.println(RED+"[OPINFO] [ERROR]: EXCEPTION OCCURED MSG:");
      IO.println(e);
      IO.println("[OPINFO] [ERROR]: EXCEPTION MSG END"+RESET);
    }
  }

  public void ReadDB() {
    try{
      ArrayList<Student> existing_db_students = getStudents();
      var f = new FileWriter("db.txt", false);
      var b = new BufferedWriter(f);
      b.append(String.valueOf(initStudent.GetHighestIndex()));
      b.newLine();
      b.close();
      if(!(existing_db_students.isEmpty())){
        for (Student stud : existing_db_students){
          addStudent(stud);
        }
      }
    }catch(Exception e){
      IO.println(RED+"[OPINFO] [ERROR]: EXCEPTION OCCURED MSG:");
      IO.println(e);
      IO.println("[OPINFO] [ERROR]: EXCEPTION MSG END"+RESET);
    }
  }

  public void addStudent(Student student, boolean append) throws IOException {
    var f = new FileWriter("db.txt", append);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public ArrayList<Student> getStudents() throws Exception {
    try{
      ArrayList<Student> ret = new ArrayList<Student>();
      var f = new FileReader("db.txt");
      var reader = new BufferedReader(f);
      String line = "";
      boolean index_buffer_line = true;
      int buffered_index = 0;
      // boolean remake_db = false;
      while (true) {
        if(index_buffer_line){
          line = reader.readLine();
          if(line==null){
            // initStudent.updateIndexBuffer(buffered_index);
            // remake_db = true;
            continue;
          }
          buffered_index = Integer.parseInt(line.trim());
          initStudent.updateIndexBuffer(buffered_index);
          index_buffer_line=false;
          continue;
        }
        line = reader.readLine();
        if(line==null)
          break;
        ret.add(Student.Parse(line));
      }
      reader.close();
      // remakeDatabase(buf);
      return ret;
    }catch(Exception e){
      IO.println(RED+"[OPINFO] [ERROR]: EXCEPTION OCCURED MSG:");
      IO.println(e);
      IO.println("[OPINFO] [ERROR]: EXCEPTION MSG END"+RESET);
      ArrayList<Student> ret = new ArrayList<Student>();
      return ret;
    }
  }

  public ArrayList<Object> findStudentByPattern(String patt) {
    try{
      int index = 0;
      List<Integer> line_indices = new ArrayList<>();
      int matches_count = 0;
      if (patt.trim().length() == 0){
        ArrayList<Object> return_list = new ArrayList<Object>();
        // ArrayList<String> found_students_matches = new ArrayList<>(); 
        return_list.add(matches_count);
        // return_list.add(found_students_matches);
        return return_list;
      }
      // ArrayList<String> name_list = new ArrayList<>(Arrays.asList(name.split("(?!^)")));
      Pattern pattern = Pattern.compile(patt.trim(),Pattern.CASE_INSENSITIVE);
      Matcher matcher;
      // Matcher matcher = name_pattern.matcher(name);
      // Service serve = new Service();
      // String student_data = "";
      ArrayList<String> found_students_matches = new ArrayList<>(); 
      ArrayList<String> students_ = new ArrayList<String>();
      var range = getStudents();
      for (Student current : range){
        students_.add(current.ToString());
      }
      for (String current : students_){
        index++;
        matcher = pattern.matcher(current);
        if(matcher.find()){
          matches_count++;
          line_indices.add(index);
          found_students_matches.add(current);
        }
      }
      ArrayList<Object> return_list = new ArrayList<Object>();
      if(matches_count==0){
        return_list.add(matches_count);
        return return_list;
      }
      return_list.add(matches_count);
      return_list.add(line_indices);
      return_list.add(found_students_matches);
      return return_list;
    }catch (Exception e){
      IO.println(RED+"-------------------------------");
      IO.println("[OPINFO] [ERROR]: EXCEPTION OCCURED MSG:");
      IO.println(e);
      IO.println("[OPINFO] [ERROR]: EXCEPTION MSG END");
      IO.println("-------------------------------");
      IO.readln("Press ENTER to proceed."+RESET);
      ArrayList<String> found_students_matches = new ArrayList<>();
      found_students_matches.clear();
      found_students_matches.add("error_match");
      ArrayList<Object> return_list = new ArrayList<Object>();
      return_list.add(0);
      return_list.add(found_students_matches);
      return return_list;
    }
  }
}