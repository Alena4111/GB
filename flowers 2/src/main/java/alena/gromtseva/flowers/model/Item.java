package alena.gromtseva.flowers.model;

import java.math.BigDecimal;

public abstract class Item {
    private String code;
    private BigDecimal price;
    private String name;

    public Item(String code, BigDecimal price, String name) {
        this.code = code;
        this.price = price;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
