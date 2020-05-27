import org.junit.Test;

public class HelloTest {

    @Test
    public void testMain() {

        new Thread(() -> {




        }).start();

        Hello.main("1 2 3 4 5 6 7 8".split(" "));



    }
}
