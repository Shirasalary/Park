import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RollerCoaster extends Thread {

    private int id;
    private String name;
    private int time;
    private int children;
    private List<Visitor> waiting;
    private boolean running;

    private static int ID_NUM = 1;
    private static String[] NAMES = {"A", "B", "C", "D", "E"};

    public RollerCoaster() {
        Random random = new Random();
        this.id = ID_NUM;
        ID_NUM++;
        this.name = NAMES[this.id - 1];
        this.time = random.nextInt(10000, 30000);
        this.children = random.nextInt(1, 6);
        this.waiting = new ArrayList<>();
    }

    public void run () {
        while (true) {
            if (!this.running) {
                List<Visitor> boarded = new ArrayList<>();
                for (Visitor visitor : this.waiting) {
                    visitor.setAvailable(false);
                    boarded.add(visitor);
                    this.waiting.remove(visitor);
                }
                this.running = true;

            }
            try {
                Thread.sleep(this.time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //להמשיך
        }
    }

    public void register (Visitor visitor) {
        this.waiting.add(visitor);
    }

    public int getIdNum(){
        return this.id;
    }
}
