package flowers.service;

import flowers.model.Item;
import flowers.model.Order;

import java.util.List;

public interface FlowerService {
    String createOrder(Order order);

    List<Item> findItems(String name);

    Item getItem(String code);
}
