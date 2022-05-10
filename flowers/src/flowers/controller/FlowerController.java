package flowers.controller;

import flowers.model.Item;
import flowers.model.Order;
import flowers.service.FlowerService;
import flowers.service.FlowerServiceImpl;

import java.util.List;

public class FlowerController {
    private final FlowerService service;

    public String createOrder(Order order) {
        return service.createOrder(order);
    }

    public List<Item> findItems(String name) {
        return service.findItems(name);
    }

    public Item getItem(String code) {
        return service.getItem(code);
    }

    public FlowerController(FlowerServiceImpl service) {
        this.service = service;
    }
}
