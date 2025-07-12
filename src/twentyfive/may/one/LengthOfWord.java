package twentyfive.may.one;

public class LengthOfWord {

  public static void main(String[] args) {
    lengthOfLastWord("HELLO WORLD");
  }

  public static int lengthOfLastWord(String s) {
    if(s==null){
      return 0;
    }
    String[] split =s.split(" ");

    int counter = split.length-1;
    while(counter>=0){
      if(split[counter].trim().length()>0){
        split[counter].trim().length();
      }
      counter++;
    }
    return 0;
  }

}
