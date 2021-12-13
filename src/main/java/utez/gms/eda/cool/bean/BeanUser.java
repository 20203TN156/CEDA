package utez.gms.eda.cool.bean;

public class BeanUser {
    private int id_user;
    private String user;
    private String password;

    public BeanUser(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
