package alena.gromtseva.flowers.repository;

import alena.gromtseva.flowers.dto.FlowerDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlowerRepository extends JpaRepository<FlowerDto, Integer> {
}