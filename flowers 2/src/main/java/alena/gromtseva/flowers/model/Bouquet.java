package alena.gromtseva.flowers.model;

import java.math.BigDecimal;
import java.util.List;

public class Bouquet extends Item {
    private List<Flower> flowers;
    private Pack pack;

    public Bouquet(String code, BigDecimal price, String name, List<Flower> flowers, Pack pack) {
        super(code, price, name);
        this.flowers = flowers;
        this.pack = pack;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }
}
