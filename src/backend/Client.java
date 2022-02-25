package backend;

// Classes filhas:
//     - ClientVip

public class Client {

    private InformationalData information = new InformationalData();
    private String cpf = "";

    public Client(String name, String cpf) {
        this.setName(name);
        this.setCpf(cpf);
    }

    // Getters ----------------------------------------------------------------
    public String getCpf() {
        return this.cpf;
    }

    public String getName() {
        return this.information.getName();
    }

    public String getCity() {
        return this.information.getCity();
    }

    public String getEmail() {
        return this.information.getEmail();
    }

    public String getAddress() {
        return this.information.getAddress();
    }

    public String getTelephone() {
        return this.information.getTelephone();
    }

    // Setters ----------------------------------------------------------------
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.information.setName(name);
    }

    public void setCity(String city) {
        this.information.setCity(city);
    }

    public void setEmail(String email) {
        this.information.setEmail(email);
    }

    public void setAddress(String address) {
        this.information.setAddress(address);
    }

    public void setTelephone(String telephone) {
        this.information.setTelephone(telephone);
    }

    // ------------------------------------------------------------------------
    public String toString() {
        return String.format("Nome: %7s | CPF: %14s", this.getName(), this.getCpf());
    }

    public String toStringDetailed() {
        String text = String.format("|Nome: %s\n", this.getName())
                + String.format("|CPF: %s\n", this.getCpf())
                + String.format("|Cidade: %s\n", this.getCity())
                + String.format("|Email: %s\n", this.getEmail())
                + String.format("|Endereco: %s\n", this.getAddress())
                + String.format("|Telefone: %s\n", this.getTelephone());

        return text;
    }

}
