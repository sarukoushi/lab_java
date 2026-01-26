//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
  List<Integer> int_list = new ArrayList<Integer>();  //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
  // to see how IntelliJ IDEA suggests fixing it.
  for (int i=0;i<10;i++)
  {
    int_list.add(i+1);
  }
  IO.println("1. Int list:");
  IO.println(int_list);

  float srednia= 0.00f;

  for (int i =0;i<int_list.size();i++)
  {
    srednia += int_list.get(i);
    //IO.println(i+1);
    //IO.println(srednia);
  }
  srednia=srednia/int_list.size();
  IO.println("Średnia z listy:");
  IO.println(int_list);
  IO.println("--------------");
  IO.println(String.format("2. Średnia: %.2f",srednia));
  IO.println("--------------");

  List<Integer> w_n_s = new ArrayList<Integer>();  //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text

  for (int i=0; i<int_list.size();i++){
    if( ( (float)int_list.get(i) ) > srednia ){
      w_n_s.add(int_list.get(i));
    }
  }

  IO.println("3. Lista liczb większych od średniej z liczb listy: int_list, zawartych w liście: int_list.:");
  IO.println(w_n_s);
}
