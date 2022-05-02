package giezz.jdbc_jfx.tables;

public class EEP {
    private int id_employee;
    private String first_name;
    private String last_name;
    private String name;
    private String salary;

    public EEP(int id_employee, String first_name, String last_name, String name, String salary) {
        this.id_employee = id_employee;
        this.first_name = first_name;
        this.last_name = last_name;
        this.name = name;
        this.salary = salary;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
