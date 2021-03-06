import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
     Map<Long,Long> po=new HashMap<>();
     Map<Long,Long> co=new HashMap<>();
     long count=0;
     for(int i=0;i<arr.size();i++){
         long a= arr.get(i);
         long key=a/r;
        if(co.containsKey(key)&&a%r==0)
         {
             count +=co.get(key);
         }
           if(po.containsKey(key)&&a%r==0)
           {
               long c=po.get(key);
               co.put(a,co.getOrDefault(a,0L)+c);
           }
           po.put(a,po.getOrDefault(a,0L)+1);
     }
     return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
