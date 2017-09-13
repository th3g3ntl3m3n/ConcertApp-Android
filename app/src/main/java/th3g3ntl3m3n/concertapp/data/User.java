package th3g3ntl3m3n.concertapp.data;

/**
 * Created by th3g3ntl3m3n on 28/8/17.
 */

public class User {
    private String username, password, fullname;
    private Boolean locked, active;
    private int type;
    private String area, puskesmas;

    public User(String username, String password, String fullname, Boolean locked, Boolean active, int type, String area, String puskesmas) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.locked = locked;
        this.active = active;
        this.type = type;
        this.area = area;
        this.puskesmas = puskesmas;
    }

    public User(String username, String password, String fullname, Boolean locked, Boolean active, int type, String area) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.locked = locked;
        this.active = active;
        this.type = type;
        this.area = area;
    }

    public User(String username, String password, String fullname, Boolean locked, Boolean active, int type) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.locked = locked;
        this.active = active;
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPuskesmas() {
        return puskesmas;
    }

    public void setPuskesmas(String puskesmas) {
        this.puskesmas = puskesmas;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
