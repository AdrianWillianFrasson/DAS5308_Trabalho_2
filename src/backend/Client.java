package backend;

// Classes filhas:
//     - ClientVip

public class Client implements InformationalData {

    private String name = "";
    private String cpf = "";
    private String city = "";
    private String email = "";
    private String address = "";
    private String telephone = "";

    public Client(String name, String cpf) {
        this.setName(name);
        this.setCpf(cpf);
    }

    // Getters ----------------------------------------------------------------
    @Override
    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
        return String.format("Nome: %10s | CPF: %10s", this.getName(), this.getCpf());
    }

}
