import java.util.HashMap;
import java.util.stream.Stream;

public class Lab7 {

    public static void main(String[] args) {

        System.out.println(proccessText1("sdfsdf sdf sdfsdfsdf sdf sdf", 2, "ttt"));
        System.out.println(proccessText2("sdfsdf sdf sdfsdfsdf sdf sdf"));
        System.out.println(proccessText3(
                "Самый лучший файлообменник Skype получил большое обновление. Ничего не хочу сказать, но Microsoft уже не успевают в хайповоз.\n"
                + "Теперь там можно располагать участников видеозвонков в формате сетки 3х3 (как в Zoom) и создавать группы с модерацией, где можно раздавать роли (как в Discord). Всё это приправлено большим количеством новых сочетаний клавиш и красивыми эмоджи в текстовом чате. Обновление получат все платформы, но полную функциональность сначала выдадут только пекабоярам.\n"));

        System.out.println(proccessText4("sdf sdf sdf sdf sdf", "sdf"));

    }

    static String proccessText1(String text, int k, String replaceText) {

        return Stream.of(text.split(" "))
                .map(s -> s.substring(0, k - 1) + replaceText + s.substring(k))
                .reduce((s, s2) -> s + " " + s2).get();

    }

    static HashMap<String, Integer> proccessText2(String text) {

        HashMap<String, Integer> map = new HashMap<>();

        Stream.of(text.split("\\.?\\s+"))
                .forEach(s -> map.put(s, map.get(s) == null ? 1 : map.get(s) + 1));

        return map;

    }

    static String proccessText3(String text) {

        String[] sentences = text.split("\\.\\s");

        for (int i = 0; i < sentences.length; i++) {

            String[] words = sentences[i].split(" ");
            sentences[i] = words[words.length - 1];
            for (int i1 = 1; i1 < words.length - 1; i1++) {
                sentences[i] += " " + words[i1];
            }
            sentences[i] += " " + words[0];
        }

        return Stream.of(sentences).reduce((s, s2) -> s + ". " + s2).orElse("");
    }


    static int proccessText4(String text, String word) {

        return text.split(word).length;

    }

}
