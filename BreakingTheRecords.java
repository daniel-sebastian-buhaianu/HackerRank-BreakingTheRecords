import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int minRecordBreaks = 0;
        int maxRecordBreaks = 0;
        
        int minScore = scores.get(0);
        int maxScore = scores.get(0);
        
        for (int i = 1, n = scores.size(); i < n; i++)
        {
            int score = scores.get(i);
            
            if (score > maxScore)
            {
                maxScore = score;
                maxRecordBreaks++;
            }
            
            if (score < minScore)
            {
                minScore = score;
                minRecordBreaks++;
            }
        }
        
        return Arrays.asList(maxRecordBreaks, minRecordBreaks);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] scoresTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresTemp[i]);
            scores.add(scoresItem);
        }

        List<Integer> result = Result.breakingRecords(scores);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
