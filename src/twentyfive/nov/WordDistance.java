package twentyfive.nov;

public class WordDistance {

 private String[] array;

        public WordDistance(String[] wordsDict) {
            this.array = wordsDict;
        }

        public int shortest(String word1, String word2) {
            int firstWord = 0;
            int secondWord = 0;
            int currentIndex = 0;
            int answer = -1;
            while (currentIndex < array.length ) {

                if (array[currentIndex] == word1) {
                    firstWord = currentIndex;
                } else if (array[currentIndex] == word2) {
                    secondWord = currentIndex;
                }
                answer = Math.min(firstWord, secondWord);
                currentIndex++;

            }
            return answer == -1 ? null : answer;
        }

}
