package backend;

import java.io.Serializable;

public class PersonalData implements Serializable {

    private String cnpj = "";
    private String city = "";
    private String email = "";
    private String address = "";
    private String telephone = "";

    // Setters-----------------------------------------------------------------
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    // Getters ----------------------------------------------------------------
    public String getCnpj() {
        return this.cnpj;
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

}
