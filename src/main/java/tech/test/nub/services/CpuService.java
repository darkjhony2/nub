package tech.test.nub.services;

import org.springframework.http.ResponseEntity;
import tech.test.nub.models.Cpu;


public interface CpuService {
    ResponseEntity<?> fetchAll();
    ResponseEntity<?> getById(Integer id);
    ResponseEntity<?> save(Cpu cpu);
    ResponseEntity<?> edit(Cpu cpu);
    ResponseEntity<?> delete(Integer id);
}
