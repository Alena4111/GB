package alena.gromtseva.flowers.service;

import alena.gromtseva.flowers.model.Item;
import alena.gromtseva.flowers.model.Order;

import java.util.List;

public interface FlowerService {
    String createOrder(Order order);

    List<Item> findItems(String name);

    Item getItem(String code);
}
