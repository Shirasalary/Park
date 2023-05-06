import java.util.ArrayList;
import java.util.List;

public class Park {

    private List<RollerCoaster> rollerCoasters;
    private List<Visitor> visitors;

    public Park() {
        this.rollerCoasters = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            RollerCoaster rollerCoaster = new RollerCoaster();
            rollerCoaster.start();
            this.rollerCoasters.add(rollerCoaster);
        }

        this.visitors = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            Visitor visitor = new Visitor();
            visitor.start();
            this.visitors.add(visitor);
        }

        new Thread(() -> {
            while (true) {
                try {
                    for (Visitor visitor : this.visitors) {
                        if (visitor.isAvailbale()) {
                            int selectedId = visitor.favoriteRollerCoasterId();
                            RollerCoaster selectedObject = getRollerCoasterById(selectedId);
                            selectedObject.register(visitor);
                        }
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private RollerCoaster getRollerCoasterById (int id) {
        RollerCoaster rollerCoaster = null;
        for (RollerCoaster r : this.rollerCoasters) {
            if (r.getIdNum() == id) {
                rollerCoaster = r;
                break;
            }
        }
        return rollerCoaster;
    }

}
