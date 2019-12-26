package tdd.performancebill.infrastrucure;
import org.springframework.data.jpa.repository.JpaRepository;
import tdd.performancebill.domain.model.performancebill.PerformanceBill;

public interface PerformanceBillRepository extends JpaRepository<PerformanceBill, Long> {
}
