import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("password"));

        int passwordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> passwords = IntStream.range(0, passwordsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int common_wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> common_words = IntStream.range(0, common_wordsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.getPasswordStrength(passwords, common_words);

        bufferedWriter.write(
                String.join("\n", result)
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}