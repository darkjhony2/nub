package tech.test.nub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.test.nub.models.Cpu;
import tech.test.nub.services.CpuService;

@RestController
@RequestMapping("/api/v1/cpus")
public class CpuController {

    @Autowired
    private CpuService cpuService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return cpuService.fetchAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return cpuService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Cpu cpu) {
        return cpuService.save(cpu);
    }

    @PutMapping
    public ResponseEntity<?> edit(@RequestBody Cpu cpu) {
        return cpuService.edit(cpu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return cpuService.delete(id);
    }
}
