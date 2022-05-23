package giezz.jdbc_jfx.models;

public class Employee extends Model {

    private int id_employee;
    private String inn;
    private String date_of_birth;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String phone;
    private String email;
    private String driver_license_category;

    public Employee(int id_employee, String inn, String date_of_birth, String first_name,
                    String middle_name, String last_name, String phone, String email,
                    String driver_license_category) {
        this.id_employee = id_employee;
        this.inn = inn;
        this.date_of_birth = date_of_birth;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.driver_license_category = driver_license_category;
    }

    public Employee(String inn, String date_of_birth, String first_name,
                    String middle_name, String last_name, String phone, String email,
                    String driver_license_category) {
        this.inn = inn;
        this.date_of_birth = date_of_birth;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.driver_license_category = driver_license_category;
    }

    public Employee() {

    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriver_license_category() {
        return driver_license_category;
    }

    public void setDriver_license_category(String driver_license_category) {
        this.driver_license_category = driver_license_category;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", inn='" + inn + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", driver_license_category='" + driver_license_category + '\'' +
                '}';
    }
}
