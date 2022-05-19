package alena.gromtseva.flowers.repository;

import alena.gromtseva.flowers.dto.PackageDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<PackageDto, Integer> {
}