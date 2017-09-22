package th3g3ntl3m3n.concertapp.data;

/**
 * Created by th3g3ntl3m3n on 14/8/17.
 */

public class Demo {
    private String emp_name, month, report, clinic_no, area, puskesmas;

    public Demo(String area) {
        this.area = area;
    }

    public Demo(String emp_name, String month, String report, String clinic_no, String area, String puskesmas) {
        this.emp_name = emp_name;
        this.month = month;
        this.report = report;
        this.clinic_no = clinic_no;
        this.area = area;
        this.puskesmas = puskesmas;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getClinic_no() {
        return clinic_no;
    }

    public void setClinic_no(String clinic_no) {
        this.clinic_no = clinic_no;
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
}
