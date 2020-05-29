import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Lab3 {


    public static void main(String[] args) {

        proccessFractions();

        proccessStudents();

    }

    private static void proccessStudents() {


        List<Student> list = StudentGenerator.generateStudents(10);

        if (list == null) {
            System.out.println("no students!:(");
            return;
        }


        System.out.println("All students");

        list.forEach(System.out::println);

        System.out.println("In department 1");

        list.stream().filter(student -> student.getDepartment().equals("1")).forEach(System.out::println);


        int year = (int) (Math.random() * 10 + 1990);
        System.out.println("After year " + year);


        list.stream().filter(student -> {
            try {
                return student.getDate().after(new SimpleDateFormat("YYYY").parse("" + year));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        }).forEach(System.out::println);


    }

    private static void proccessFractions() {
        int n = 3;
        System.out.println("Generating " + n + " fractions");

        List<NumericFraction> fractions  = new ArrayList<>();
        List<NumericFraction> fractions2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int denumerator = (int) (Math.random() * 10 + 3);
            int numerator   = (int) (Math.random() * (denumerator - 1) + 1);
            fractions.add(new NumericFraction(numerator, denumerator));
            denumerator = (int) (Math.random() * 10 + 3);
            numerator = (int) (Math.random() * (denumerator - 1) + 1);
            fractions2.add(new NumericFraction(numerator, denumerator));
        }

        for (int i = 0; i < fractions.size(); i++) {

            NumericFraction f1 = fractions.get(0);
            NumericFraction f2 = fractions2.get(0);

            System.out.printf("%s + %s = %s\n", f1, f2, f1.add(f2));
            System.out.printf("%s - %s = %s\n", f1, f2, f1.sub(f2));
            System.out.printf("%s * %s = %s\n", f1, f2, f1.multiply(f2));
            System.out.printf("%s / %s = %s\n\n", f1, f2, f1.devide(f2));

        }

    }


}
