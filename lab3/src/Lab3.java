import java.util.ArrayList;
import java.util.List;

public class Lab3 {


    public static void main(String[] args) {


//        int n = (int) (Math.random() * 5);

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

        fractions.forEach(fraction -> {
        });

    }


}
