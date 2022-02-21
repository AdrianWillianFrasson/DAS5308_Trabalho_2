package backend;

public class Supplier implements InformationalData {

    private String name = "";
    private String cnpj = "";
    private String city = "";
    private String email = "";
    private String address = "";
    private String telephone = "";

    public Supplier(String name, String cnpj) {
        this.setName(name);
        this.setCnpj(cnpj);
    }

    // Getters ----------------------------------------------------------------
    @Override
    public String getName() {
        return this.name;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getTelephone() {
        return this.telephone;
    }

    // Setters ----------------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

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

    // ------------------------------------------------------------------------
    public String toString() {
        return String.format("Nome: %10s | CNPJ: %10s", this.getName(), this.getCnpj());
    }

}
