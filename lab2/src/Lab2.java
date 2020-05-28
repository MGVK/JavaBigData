import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lab2 {


//    private Comparator lengthComparator = Comparator.comparingInt(String::length);


    private String minStr, maxStr;
    private int minStrLen = 0, maxStrLen = 0, aveStrLen = 0;

    public static void main(String[] args) {

        Lab2 l = new Lab2();

//        List<String> strings = l.readStrings();
        List<String> strings = Arrays.asList("abc","bla", "blabla", "sjdfhlasjhdflkajsdf", "khjdkh", "sdjsdf", "eeee",
                "s", "44");


        for (Method method : Lab2.class.getDeclaredMethods()) {
            if (method != null && method.getName().contains("print") && !method.getName().contains("lambda")) {
                System.out.println("\\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/\n\n~$: " + method.getName());
                try {
                    method.invoke(l, strings);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


    List<String> readStrings() {
        System.out.println("Input count of strings");
        int n = Integer.parseInt(new Scanner(System.in).nextLine());
        return new BufferedReader(new InputStreamReader(System.in))
                .lines().limit(n).collect(Collectors.toList());
    }

    void print1_MaxMin(List<String> lines) {

        System.out.println(
                (maxStr = lines.stream().max(Comparator.comparingInt(String::length)).orElse(""))
                + " with len:" + (maxStrLen = maxStr.length()));
        System.out.println(
                (minStr = lines.stream().min(Comparator.comparingInt(String::length)).orElse(""))
                + " with len:" + (minStrLen = minStr.length()));
    }

    void print2_Sorted(List<String> lines) {

        lines.sort(Comparator.comparingInt(String::length));
        lines.forEach(System.out::println);

    }

    void print3_AveMinMax(List<String> lines) {

        aveStrLen = (minStrLen + maxStrLen) / lines.size();

        System.out.println();

        System.out.println("More then Ave");
        lines.stream().filter(s -> s.length() > aveStrLen).map(s -> s + " : " + s.length())
                .forEach(System.out::println);
        System.out.println("Less then Ave");
        lines.stream().filter(s -> s.length() < aveStrLen).map(s -> s + " : " + s.length())
                .forEach(System.out::println);
    }


    void print4_MinUniq(List<String> lines) {


        Object[] minUniq = lines.stream()
                .map(s -> new Object[]{s, Stream.of(s.split(""))
                        .collect(Collectors.toMap(o -> o, o -> 1, Integer::sum)).size()})
                .min(Comparator.comparingInt(o -> (int) o[1])).get(),
                maxUniq = lines.stream()
                        .map(s -> new Object[]{s, Stream.of(s.split(""))
                                .collect(Collectors.toMap(o -> o, o -> 1, Integer::sum)).size()})
                        .max(Comparator.comparingInt(o -> (int) o[1])).get();

        System.out.println("MinUniq");
        System.out.println(minUniq[0] + " with " + minUniq[1] + " uniq symbols count");

        System.out.println("MaxUniq");
        System.out.println(maxUniq[0] + " with " + maxUniq[1] + " uniq symbols count");

    }

    void print5_ASCSymbolsCodes(List<String> lines) {

        System.out.println(lines.stream().map(s -> new Object[]{s, Stream.of(s.split(""))
                            .map(ss -> ((int) ss.charAt(0)))
                            .reduce((integer, integer2) -> (integer >= integer2 ? 0 : 1) * integer)
                            .filter(integer -> integer != 0).isPresent()})
                .filter(objects -> (boolean) objects[1])
                .map(objects -> objects[0])
                .collect(Collectors.toList()));

    }

}
