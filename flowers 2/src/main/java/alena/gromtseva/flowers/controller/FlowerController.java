package alena.gromtseva.flowers.controller;

import alena.gromtseva.flowers.model.Item;
import alena.gromtseva.flowers.model.Order;
import alena.gromtseva.flowers.service.FlowerService;
import alena.gromtseva.flowers.service.FlowerServiceImpl;

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
