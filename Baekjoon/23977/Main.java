import java.util.*;
import java.util.stream.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] kAndN = reader.readLine().split(" ");
        long k = Long.parseLong(kAndN[0]);
        int n = Integer.parseInt(kAndN[1]);

        long[] numbers = Stream.of(reader.readLine().split(" "))
            .mapToLong(Long::parseLong)
            .toArray();

        long lcm = numbers[0];
        for (int i = 1; i < n; i++) {
            lcm = lcm(lcm, numbers[i]);
        }

        long password = lcm - k;
        writer.write(String.valueOf(password));
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
