import java.util.HashMap;
import java.util.Map;

public class Lab6 {

    public static void main(String[] args) {


        Map<Integer, Double> map  = new HashMap<>();
        Map<Integer, Double> map2 = new HashMap<>();
        Map<Integer, Double> sum  = new HashMap<>();

        int n = 10;

        for (int i = 0; i <= n; i++) {
            map.put(i, (Math.random() * 100));
        }

        for (int i = 0; i <= n; i++) {
            map2.put(i, (Math.random() * 100));
        }

        print(map);
        print(map2);

        for (int i = 0; i <= n; i++) {
            sum.put(i, map.get(i) + map2.get(i));
        }
        System.out.println("sum:");
        print(sum);

    }

    static void print(Map<Integer, Double> map) {
        System.out.println(
                map.entrySet().stream().map(integerDoubleEntry -> String.format("%.2f", integerDoubleEntry.getValue())
                                                                  + (integerDoubleEntry.getKey() == 0 ?
                        "" : integerDoubleEntry.getKey() == 1 ? "x" : "x^")
                                                                  + (integerDoubleEntry.getKey() <= 1 ?
                        "" : integerDoubleEntry.getKey()))
                        .reduce((s, s2) -> s + "+" + s2).get());
    }


}
