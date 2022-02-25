package backend;

public class InformationalData {

    private String name = "";
    private String city = "";
    private String email = "";
    private String address = "";
    private String telephone = "";

    // Getters ----------------------------------------------------------------
    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public String getTelephone() {
        return this.telephone;
    }

    // Setters ----------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
