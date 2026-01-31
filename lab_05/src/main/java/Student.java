import java.lang.classfile.BootstrapMethodEntry;
import java.util.Collection;

public class Student {

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

  private int Index;
  private String Name;
  private String Nazwisko;
  private int Age;
  private int DzienUro;
  private int MiesiacUro;
  private int RokUro;
  private String BirthDate;

  // private static int Index_buffer = 0;
  public static int Highest_index = 0;

  public void updateIndexBuffer(int buffered_index){
    if(buffered_index>Highest_index){
      Highest_index=buffered_index;
    }
  }
  public int GetHighestIndex(){
    return Highest_index;
  }

  public Student() {}

  public Student(String name, String nazwisko, int age, int dzien_uro, int miesiac_uro, int rok_uro) {
    Highest_index++;
    Index = Highest_index;
    Name = name;
    Age = age;
    Nazwisko = nazwisko;
    DzienUro = dzien_uro;
    MiesiacUro = miesiac_uro;
    RokUro = rok_uro;
  }

  public Student(int index,String name, String nazwisko, int age, int dzien_uro, int miesiac_uro, int rok_uro) {
    Index = index;
    Name = name;
    Age = age;
    Nazwisko = nazwisko;
    DzienUro = dzien_uro;
    MiesiacUro = miesiac_uro;
    RokUro = rok_uro;
    if(index>Highest_index){
      Highest_index=index;
    }
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetBirthDate() {
    BirthDate = Integer.toString(DzienUro)+ "-" + Integer.toString(MiesiacUro) + "-" + Integer.toString(RokUro);
    return BirthDate;
  }


  public String ToString() {
    return Index + " " + Name + " " + Nazwisko + " " + Integer.toString(Age) + " " +GetBirthDate();
  }

  public static Student Parse(String str) {
    String[] data = (str.trim()).split(" ");
    String[] birthdate = data[4].split("-");
    if(data.length != 5)
      return new Student(0,"Parse ", "Error", 0, 0,0,0);
    return new Student(Integer.parseInt(data[0]), data[1], data[2],Integer.parseInt(data[3]),Integer.parseInt(birthdate[0]),Integer.parseInt(birthdate[1]),Integer.parseInt(birthdate[2]));
  }

  public static Student ParseNewName(String str,String newname) {
    String[] data = (str.trim()).split(" ");
    String[] birthdate = data[4].split("-");
    if(data.length != 5)
      return new Student(0,"Parse ", "Error", 0, 0,0,0);
    return new Student(Integer.parseInt(data[0]), newname, data[2],Integer.parseInt(data[3]),Integer.parseInt(birthdate[0]),Integer.parseInt(birthdate[1]),Integer.parseInt(birthdate[2]));
  }
  public static Student ParseNewSurname(String str,String newsurname) {
    String[] data = (str.trim()).split(" ");
    String[] birthdate = data[4].split("-");
    if(data.length != 5)
      return new Student(0,"Parse ", "Error", 0, 0,0,0);
    return new Student(Integer.parseInt(data[0]), data[1], newsurname,Integer.parseInt(data[3]),Integer.parseInt(birthdate[0]),Integer.parseInt(birthdate[1]),Integer.parseInt(birthdate[2]));
  }
    public static Student ParseNewAge(String str, int newage) {
    String[] data = (str.trim()).split(" ");
    String[] birthdate = data[4].split("-");
    if(data.length != 5)
      return new Student(0,"Parse ", "Error", 0, 0,0,0);
    return new Student(Integer.parseInt(data[0]), data[1], data[2],newage,Integer.parseInt(birthdate[0]),Integer.parseInt(birthdate[1]),Integer.parseInt(birthdate[2]));
  }
}