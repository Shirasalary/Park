import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Visitor extends Thread {

    private int id;
    private String name;
    private Map<Integer,Integer> preference;
    private  boolean isAvailbale;

    private static int ID_NUM = 1;

    public Visitor()
    {
        Random random = new Random();
        this.id = ID_NUM;
        this.name = String.valueOf(ID_NUM);
        ID_NUM++;
        this.preference = new HashMap<>();
        this.preference.put(1, random.nextInt(1,20));
        this.preference.put(2, random.nextInt(1,20));
        this.preference.put(3, random.nextInt(1,20));
        this.preference.put(4, random.nextInt(1,20));
        int distance = this.preference.get(1) + this.preference.get(2)+
                this.preference.get(3)+ this.preference.get(4);
        this.preference.put(1, 100 - distance);
        this.isAvailbale = true;

    }

    public void run () {
        while (true) {
            System.out.println(this.name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int favoriteRollerCoasterId () {
        return 1;
    }

    public boolean isAvailbale () {
        return this.isAvailbale;
    }

    public void setAvailable (boolean status)
    {
         this.isAvailbale = status;
    }


}
