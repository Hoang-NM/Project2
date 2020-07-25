package Model;

public class Account {
    private int eId;
    private int aId;
    private String username;
    private String password;

    public Account(int eId, String username, String password) {
        this.eId = eId;
        this.username = username;
        this.password = password;
    }

    public Account(int eId, int aId, String username, String password) {
        this.eId = eId;
        this.aId = aId;
        this.username = username;
        this.password = password;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
