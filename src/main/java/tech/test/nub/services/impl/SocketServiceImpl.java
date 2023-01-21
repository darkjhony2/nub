package tech.test.nub.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.test.nub.models.Socket;
import tech.test.nub.repositories.SocketRepository;
import tech.test.nub.services.SocketService;

import java.util.List;

@Service
public class SocketServiceImpl implements SocketService {

    @Autowired
    private SocketRepository socketRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> fetchAll() {
        try {
            List<Socket> socketList = socketRepository.findAll();
            return new ResponseEntity<>(socketList, HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when fetching all the sockets", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getById(Integer id) {
        try {
            Socket socket = socketRepository.findById(id).orElse(null);
            return new ResponseEntity<>(socket, HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when looking for the socket with id: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(Socket socket) {
        try {
            socketRepository.save(socket);
            return ResponseEntity.ok("Socket saved");
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when saving the socket", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> edit(Socket socket) {
        try {
            Socket socketDb = socketRepository.findById(socket.getId()).orElse(null);
            if(socketDb != null) {
                socket.setUpdated(true);
                socketRepository.save(socket);
            } else {
                return new ResponseEntity<>("Socket not found", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok("Socket edited");
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when editing the socket", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Integer id) {
        try {
            Socket socketDb = socketRepository.findById(id).orElse(null);
            if(socketDb != null) {
                socketDb.setDeleted(true);
                socketRepository.save(socketDb);
            } else {
                return new ResponseEntity<>("Socket not found", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok("Socket deleted");
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when deleting the socket", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
