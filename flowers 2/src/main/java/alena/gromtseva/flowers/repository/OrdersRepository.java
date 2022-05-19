package alena.gromtseva.flowers.repository;

import alena.gromtseva.flowers.dto.OrdersDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersDto, Integer> {
}