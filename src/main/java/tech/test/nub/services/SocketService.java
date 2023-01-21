package tech.test.nub.services;

import org.springframework.http.ResponseEntity;
import tech.test.nub.models.Socket;

public interface SocketService {
    ResponseEntity<?> fetchAll();
    ResponseEntity<?> getById(Integer id);
    ResponseEntity<?> save(Socket socket);
    ResponseEntity<?> edit(Socket socket);
    ResponseEntity<?> delete(Integer id);
}
