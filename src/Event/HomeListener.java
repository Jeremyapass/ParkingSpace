package Event;
//untuk komunikasi View dan Model
import Model.HomeModel;

public interface HomeListener {
    public void onChange(HomeModel home);
}
//lalu deklarasikan di Model
