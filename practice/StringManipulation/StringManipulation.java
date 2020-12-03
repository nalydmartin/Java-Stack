public class StringManipulation {
    public String trimAndConcat(String word1, String word2) {
        String combinedWord = word1.trim().concat(word2.trim());
        return combinedWord;
    }

    public Integer getIndexOrNull(String word, char letter) {
        if (word.indexOf(letter) == -1) {
            return null;
        } else {
            return word.indexOf(letter);
        }
    }

    public Integer getIndexOrNull(String word1, String word2) {
        if (word1.indexOf(word2) == -1) {
            return null;
        } else {
            return word1.indexOf(word2);
        }
    }

    String concatSubstring(String word, int start, int end, String word2) {
        return word.substring(start, end).concat(word2);
    }

}
