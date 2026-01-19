import java.lang.classfile.BootstrapMethodEntry;
import java.util.Collection;

public class Student {

  private String Name;
  private String Nazwisko;
  private int Age;
  private int DzienUro;
  private int MiesiacUro;
  private int RokUro;
  private String BirthDate;

  public Student(String name, String nazwisko, int age, int dzien_uro, int miesiac_uro, int rok_uro) {
    Name = name;
    Age = age;
    Nazwisko = nazwisko;
    DzienUro = dzien_uro;
    MiesiacUro = miesiac_uro;
    RokUro = rok_uro;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetBirthDate() {
    BirthDate = Integer.toString(DzienUro)+ "-" + Integer.toString(MiesiacUro) + "-" + Integer.toString(RokUro);
    return BirthDate;
  }


  public String ToString() {
    return Name + " " + Nazwisko + " " + Integer.toString(Age) + " " +GetBirthDate();
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    String[] birthdate = data[3].split("-");
    if(data.length != 4)
      return new Student("Parse ", "Error", 0, 0,0,0);
    return new Student(data[0], data[1],Integer.parseInt(data[2]),Integer.parseInt(birthdate[0]),Integer.parseInt(birthdate[1]),Integer.parseInt(birthdate[2]));
  }
}