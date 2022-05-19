package alena.gromtseva.flowers.repository;

import alena.gromtseva.flowers.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientDto, Integer> {
}