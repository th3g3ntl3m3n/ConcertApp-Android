package th3g3ntl3m3n.concertapp.data;

import java.util.ArrayList;

/**
 * Created by th3g3ntl3m3n on 14/8/17.
 */

public class DemoUser {

    private String type, code, name;
    private String message;
    private String area;
    private ArrayList<String> list, employees;
    private ArrayList<String> data;


    public DemoUser(ArrayList<String> list, ArrayList<String> employees) {
        this.list = list;
        this.employees = employees;
    }

    public DemoUser(String type, String code, String name, String message) {
        this.type = type;
        this.code = code;
        this.name = name;
        this.message = message;
    }

    public DemoUser(String name) {
        this.name = name;
    }

    public DemoUser(String type, String code, String name) {
        this.type = type;
        this.code = code;
        this.name = name;
    }

    public DemoUser(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public ArrayList<String> getManagers() {
        return list;
    }

    public void setManagers(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<String> employees) {
        this.employees = employees;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DemoUser{" +
                "type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", list=" + list +
                ", employees=" + employees +
                ", data=" + data +
                '}';
    }
}
