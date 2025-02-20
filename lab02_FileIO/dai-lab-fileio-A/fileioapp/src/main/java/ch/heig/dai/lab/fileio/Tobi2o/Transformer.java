package ch.heig.dai.lab.fileio.Tobi2o;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with 
     * and the number of words per line to use when wrapping the text.
     * @param newName the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        return source.replace("Chuck Norris", newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) { 
        String[] words = source.split("\\s+");
        StringBuilder result = new StringBuilder();
    
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return result.toString().trim();
    }

/**
 * Wrap the text so that there are at most numWordsPerLine words per line.
 * Number the lines starting at 1.
 * @param source the string to transform
 * @return the transformed string
 */
public String wrapAndNumberLines(String source) {

    StringBuilder result = new StringBuilder();
    String[] words = source.split("\\s+");
    int currentWordCount = 0;
    int currentLineNumber = 1;

    result.append(currentLineNumber).append(". ");

    for (int i = 0; i < words.length; i++) {
        String word = words[i];
        result.append(word);

        currentWordCount++;

        boolean isLastWord = (i == words.length - 1);
        boolean shouldWrap = (currentWordCount >= numWordsPerLine);

        if (shouldWrap || isLastWord) {
            if (!isLastWord) {
                result.append("\n");
                result.append(++currentLineNumber).append(". ");
                currentWordCount = 0;
            } else {
                result.append("\n");
            }
        } else {
            result.append(" ");
        }
    }
    return result.toString();
}
    
}