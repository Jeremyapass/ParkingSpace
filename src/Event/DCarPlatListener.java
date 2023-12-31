package Event;
//untuk komunikasi View dan Model
import Model.DCarPlatModel;

public interface DCarPlatListener {
    public void onChange(DCarPlatModel DCarPlat);
}
//lalu deklarasikan di Model
