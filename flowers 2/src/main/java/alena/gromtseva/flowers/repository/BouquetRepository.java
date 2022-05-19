package alena.gromtseva.flowers.repository;

import alena.gromtseva.flowers.dto.BouquetDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BouquetRepository extends JpaRepository<BouquetDto, Integer> {
}