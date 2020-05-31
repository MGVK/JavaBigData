import java.io.*;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashSet;

public class NumberSet<T extends Number> extends HashSet<T> {


    public static void main(String[] args) {
        NumberSet set = new NumberSet();
        set.add(1);
        set.add(5);
        set.add(6);
        set.add(123);

        System.out.println(set);
        System.out.println(set.getNearestNumber(100));
    }

    void save(Path path) throws IOException {

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()));

        outputStream.writeObject(this);

    }

    NumberSet load(Path path) throws IOException, ClassNotFoundException {

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path.toFile()));

        NumberSet set = (NumberSet) inputStream.readObject();

        return set;
    }

    T getNearestNumber(T number) {

        return stream().min(Comparator.comparingDouble(o -> Math.abs(o.doubleValue() - number.doubleValue())))
                .orElseThrow(() -> new NullPointerException("Badrock"));

    }


}
