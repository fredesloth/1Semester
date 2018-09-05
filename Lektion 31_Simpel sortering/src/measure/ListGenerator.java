package measure;

import java.util.*;

public class ListGenerator {
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzæøå";
    private static Random random = new Random(42);
    private static int MIN_WORD_SIZE = 5;
    
    /**
     * Generates a list of random Strings. 
     * @param listSize The size of the generated list.
     * @param maxWordSize The maximum size of each word. Must be larger than 5.
     * @return the generated list.
     */
    public static ArrayList<String> generateString(int listSize, int maxWordSize) {
        ArrayList<String> result = new ArrayList<String>();
        
        for (int j = 0; j < listSize; j++) {
            StringBuilder sb = new StringBuilder();
            int wordSize = random.nextInt(maxWordSize - MIN_WORD_SIZE) + MIN_WORD_SIZE;
            for (int i = 0; i < wordSize; i++) {
                sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
            }
            result.add(sb.toString());
        }
        
        return result;
    }
}
