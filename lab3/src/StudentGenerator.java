import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StudentGenerator {


    public static List<Student> generateStudents(int n) {

        List students = new ArrayList();

        for (int i = 0; i < n; i++) {
            students.add(generateStudent(i, findMan()));
        }


        return students;


    }

    static List<String[]> findFIO(int count) {
        try {
            final Content getResult = Request
                    .Post("http://freegenerator.ru/fio")
                    .bodyForm(Form.form()
                            .add("fam", "1")
                            .add("imya", "1")
                            .add("otch", "1")
                            .add("pol", "0")
                            .add("count", count + "").build())
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64; rv:78.0) Gecko/20100101 Firefox/78.0")
                    .execute().returnContent();

            return Arrays.stream(getResult.asString().split(" <br> "))
                    .map(s -> s.split(" "))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();


    }

    static List<String> findMan() {
        Pattern p = Pattern.compile("<(input type=\"\\w+\" |name=\"\\w+\" |onclick=\"select\\(this\\);\" |"
                                    + "class=\"form-control\" )+value=\"(.*?)\"");
        try {
            final Content getResult = Request
                    .Get("http://randus.org")
                    .execute().returnContent();

            Matcher m = p.matcher(getResult.asString().replace("\n", ""));


            List<String> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                if (m.find()) {
                    list.add(m.group(2));
                }
            }
            System.out.println(list);

            return list;


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    public static void main(String[] args) throws IOException {
//        System.out.println(findFIO(10));
        findMan();

    }

    public static Student generateStudent(long id, List<String> data) {
        if (data == null) return null;

        String[] fio = data.get(0).split(" ");
//
        return new Student(
                id,
                fio[1],
                fio[2],
                fio[0],
                data.get(1),
                data.get(2),
                data.get(3),
                getRandomDepartment(),
                (int) (Math.random() * 5 + 1) + "",
                (int) (Math.random() * 2 + 1) + ""
        );
    }

    private static String getRandomDepartment() {
        return (int) (Math.random() * 6 + 1) + "";
    }


}
