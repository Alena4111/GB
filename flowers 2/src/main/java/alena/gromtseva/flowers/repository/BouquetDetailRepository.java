package alena.gromtseva.flowers.repository;

import alena.gromtseva.flowers.dto.BouquetDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BouquetDetailRepository extends JpaRepository<BouquetDetailDto, Integer> {
}