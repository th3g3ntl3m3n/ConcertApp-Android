package th3g3ntl3m3n.concertapp.data;

/**
 * Created by th3g3ntl3m3n on 10/8/17.
 */

public class POJOResponse {
    private String name, code, area, pusk;
    private int type;

    public POJOResponse(String name, String code, String area, String pusk, int type) {
        this.name = name;
        this.code = code;
        this.area = area;
        this.pusk = pusk;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPusk() {
        return pusk;
    }

    public void setPusk(String pusk) {
        this.pusk = pusk;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "POJOResponse{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", area='" + area + '\'' +
                ", pusk='" + pusk + '\'' +
                ", type=" + type +
                '}';
    }
}
