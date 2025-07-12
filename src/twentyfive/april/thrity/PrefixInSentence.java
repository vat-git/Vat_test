package twentyfive.april.thrity;

public class PrefixInSentence {

  public int isPrefixOfWord(String sentence, String searchWord) {
    if (sentence == null || searchWord == null) {
      return -1;
    }

    String[] array = sentence.split(" ");
    int index = 1;
    for (String string : array) {
      if (string.startsWith(searchWord)) {
        return index;
      }
      index++;
    }
    return -1;
  }

}
