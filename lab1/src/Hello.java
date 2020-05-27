import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.stream.Stream;

public class Hello {

    public Hello() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        Hello h = new Hello();


        h.printAges(args);

        h.printNStrings((int) (Math.random() * 20));

        h.processPassword();

        h.processArgs(args);

        h.printDeveloperInfo();


    }

    public void printAges(String[] args) {

        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }


    }

    private void printNStrings(int n) {

        System.out.println("Printing " + n + " numbers");
        for (int i = 0; i < n; i++) {
            System.out.print(i + (Math.random() < 0.5 ? "\n" : ""));
        }

    }

    private void printDeveloperInfo() {

        System.out.printf("Michael Bayandin, %s\n", new SimpleDateFormat("yyyy.MMM.dd")
                .format(new GregorianCalendar(2020, Calendar.FEBRUARY, 14).getTime()));

        System.out.printf("Michael Bayandin, %s\n", new SimpleDateFormat("yyyy.MMM.dd  HH:mm:ss")
                .format(new GregorianCalendar(2020, Calendar.FEBRUARY, 14, 17, 30, 00).getTime()));

    }

    private void processArgs(String[] args) {
        System.out.println("Args count:" + args.length);
        System.out.println(Stream.of(args).map(Integer::parseInt).reduce(Math::multiplyExact).orElse(0));
        System.out.println(Stream.of(args).map(Integer::parseInt).reduce(Math::addExact).orElse(0));
    }

    private void processPassword() {
        System.out.println("Input a password");
        String pass = new Scanner(System.in).nextLine();
        System.out.println(pass.equals("HARDCODEDPASSWORD") ? "Correct password!" : "Password incorrect");
    }
}
