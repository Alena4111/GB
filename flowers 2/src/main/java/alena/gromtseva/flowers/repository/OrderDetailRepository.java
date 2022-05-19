package alena.gromtseva.flowers.repository;

import alena.gromtseva.flowers.dto.OrderDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailDto, Integer> {
}