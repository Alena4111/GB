package alena.gromtseva.flowers.model;

public class Client {
    private String id;
    private String fio;
    private String phone;

    public Client(String id, String fio, String phone) {
        this.id = id;
        this.fio = fio;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
