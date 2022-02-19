package backend;

// A Classe que implementar "InformationalData" poderá ser 
// vinculada a uma fatura (Invoice)

public interface InformationalData {

    // Getters ----------------------------------------------------------------
    public String getName();

    public String getCity();

    public String getEmail();

    public String getAddress();

    public String getTelephone();

}
