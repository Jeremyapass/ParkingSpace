package Event;
//untuk komunikasi View dan Model
import Model.LoginModel;

public interface LoginListener {
    public void onChange(LoginModel login);
}
//lalu deklarasikan di Model
