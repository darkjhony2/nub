package tech.test.nub.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.test.nub.models.Cpu;
import tech.test.nub.repositories.CpuRepository;
import tech.test.nub.services.CpuService;

import java.util.List;

@Service
public class CpuServiceImpl implements CpuService {

    @Autowired
    private CpuRepository cpuRepository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> fetchAll() {
        try {
            List<Cpu> cpuList = cpuRepository.findAll();
            return new ResponseEntity<>(cpuList, HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when fetching all the cpus", HttpStatus.OK);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<?> getById(Integer id) {
        try {
            Cpu cpu = cpuRepository.findById(id).orElse(null);
            return new ResponseEntity<>(cpu, HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when looking for the cpu with id: " + id, HttpStatus.OK);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> save(Cpu cpu) {
        try {
            cpuRepository.save(cpu);
            return ResponseEntity.ok("Cpu saved");
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when saving the cpu", HttpStatus.OK);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> edit(Cpu cpu) {
        try {
            Cpu cpuDb = cpuRepository.findById(cpu.getId()).orElse(null);
            if(cpuDb != null) {
                cpu.setUpdated(true);
                cpuRepository.save(cpu);
            } else {
                return new ResponseEntity<>("Cpu not found", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok("Cpu edited");
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when editing the cpu", HttpStatus.OK);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> delete(Integer id) {
        try {
            Cpu cpuDb = cpuRepository.findById(id).orElse(null);
            if(cpuDb != null) {
                cpuDb.setDeleted(true);
                cpuRepository.save(cpuDb);
            } else {
                return new ResponseEntity<>("Cpu not found", HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok("Cpu deleted");
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong happened when deleting the cpu", HttpStatus.OK);
        }
    }
}
