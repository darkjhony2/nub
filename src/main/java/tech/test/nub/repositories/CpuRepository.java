package tech.test.nub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.test.nub.models.Cpu;

public interface CpuRepository extends JpaRepository<Cpu, Integer> {
}
