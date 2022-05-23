package giezz.jdbc_jfx.models;

public class Client extends Model {
    private int client_id;
    private String last_name;
    private String first_name;
    private String middle_name;
    private String company_name;
    private String phone;
    private String address;

    public Client(int client_id, String last_name, String first_name, String middle_name, String company_name, String phone, String address) {
        this.client_id = client_id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.company_name = company_name;
        this.phone = phone;
        this.address = address;
    }

    public Client(String last_name, String first_name, String middle_name, String company_name, String phone, String address) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.company_name = company_name;
        this.phone = phone;
        this.address = address;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
