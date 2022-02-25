package backend;

public class Supplier {

    private InformationalData information = new InformationalData();
    private String cnpj = "";

    public Supplier(String name, String cnpj) {
        this.setName(name);
        this.setCnpj(cnpj);
    }

    // Getters ----------------------------------------------------------------
    public String getCnpj() {
        return this.cnpj;
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
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
        return String.format("Nome: %10s | CNPJ: %18s", this.getName(), this.getCnpj());
    }

    public String toStringDetailed() {
        String text = String.format("|Nome: %s\n", this.getName())
                + String.format("|CNPJ: %s\n", this.getCnpj())
                + String.format("|Cidade: %s\n", this.getCity())
                + String.format("|Email: %s\n", this.getEmail())
                + String.format("|Endereco: %s\n", this.getAddress())
                + String.format("|Telefone: %s\n", this.getTelephone());

        return text;
    }

}
