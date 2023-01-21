package tech.test.nub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.test.nub.models.Socket;

public interface SocketRepository extends JpaRepository<Socket, Integer> {
}
