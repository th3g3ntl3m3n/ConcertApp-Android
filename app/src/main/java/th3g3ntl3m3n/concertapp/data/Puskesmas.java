package th3g3ntl3m3n.concertapp.data;

import java.util.ArrayList;

/**
 * Created by th3g3ntl3m3n on 29/8/17.
 */

public class Puskesmas {
    private ArrayList<String> data;
    private String areaname;

    public Puskesmas(ArrayList<String> list, String areaname) {
        this.data = list;
        this.areaname = areaname;
    }

    public Puskesmas(String areaname) {
        this.areaname = areaname;
    }

    public ArrayList<String> getList() {
        return data;
    }

    public void setList(ArrayList<String> list) {
        this.data = list;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }
}
