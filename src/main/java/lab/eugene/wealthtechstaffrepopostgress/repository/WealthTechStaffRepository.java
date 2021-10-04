package lab.eugene.wealthtechstaffrepopostgress.repository;

import lab.eugene.wealthtechstaffrepopostgress.entity.WealthTechStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WealthTechStaffRepository extends
        JpaRepository<WealthTechStaff, Integer> {
}
