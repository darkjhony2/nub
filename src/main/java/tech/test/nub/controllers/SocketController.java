package tech.test.nub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.test.nub.models.Socket;
import tech.test.nub.services.SocketService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/sockets")
public class SocketController {

    @Autowired
    private SocketService socketService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return socketService.fetchAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return socketService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Socket socket) {
        return socketService.save(socket);
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody Socket socket) {
        return socketService.edit(socket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return socketService.delete(id);
    }
}
