package alena.gromtseva.flowers.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String id;
    private BigDecimal price;
    private LocalDateTime dateTime;
    private Client client;
    private List<Item> items;

    public Order(String id, BigDecimal price, LocalDateTime dateTime, Client client, List<Item> items) {
        this.id = id;
        this.price = price;
        this.dateTime = dateTime;
        this.client = client;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
