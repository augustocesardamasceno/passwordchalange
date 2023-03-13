import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'getPasswordStrength' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING_ARRAY common_words
     */

    public static List<String> getPasswordStrength(List<String> passwords, List<String> common_words) {
        // Write your code here

        List<String> results = new ArrayList<>();

        AtomicBoolean isWeak = new AtomicBoolean(false);

        passwords.forEach(password -> {
            Pattern pattern = Pattern.compile("^[0-9]+$");
            Matcher matcher = pattern.matcher(password);
            boolean containsNumbers = matcher.find();

            Pattern patternLetters = Pattern.compile("^[a-zA-Z]+$");
            Matcher matcherLetters = patternLetters.matcher(password);
            boolean containsLetters = matcherLetters.find();

            for (String word : common_words) {
                if (password.contains(word) || containsNumbers  || containsLetters || password.length() < 6) {
                    isWeak.set(true);
                }
            }

            if (isWeak.get()) {
                System.out.println("weak");
            } else {
                results.add(password);
                System.out.println("strong");
            }
            isWeak.set(false);
        });

        return results;
    }

}