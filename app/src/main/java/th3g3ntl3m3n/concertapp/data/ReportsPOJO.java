package th3g3ntl3m3n.concertapp.data;

/**
 * Created by th3g3ntl3m3n on 14/9/17.
 */

public class ReportsPOJO {
    private String emp_name, report, month, clinic_no, area_name, pusk_name;
    private String area;
    private String name;

    public ReportsPOJO(String name) {
        this.area = name;
    }


    public ReportsPOJO(String emp_name, String report, String month, String clinic_no, String area_name, String pusk_name) {
        this.emp_name = emp_name;
        this.report = report;
        this.month = month;
        this.clinic_no = clinic_no;
        this.area_name = area_name;
        this.pusk_name = pusk_name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getClinic_no() {
        return clinic_no;
    }

    public void setClinic_no(String clinic_no) {
        this.clinic_no = clinic_no;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getPusk_name() {
        return pusk_name;
    }

    public void setPusk_name(String pusk_name) {
        this.pusk_name = pusk_name;
    }
}
