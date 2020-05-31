public class Robot {

    private Leg left, right;
    private int speed;

    Robot(int speed) {
        this.speed = speed;
        left = new Leg("Left", speed);
        right = new Leg("Right", speed);
    }

    public static void main(String[] args) {
        Robot r = new Robot(1);
        r.startWalking();
    }

    void startWalking() {

        left.start();
        right.start();

    }

    class Leg extends Thread {

        private String name;
        private int    speed;

        Leg(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                System.out.println(name);
                try {
                    sleep(1000 / speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
