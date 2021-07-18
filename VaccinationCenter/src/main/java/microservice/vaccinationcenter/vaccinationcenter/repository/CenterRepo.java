package microservice.vaccinationcenter.vaccinationcenter.repository;

import microservice.vaccinationcenter.vaccinationcenter.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {
}
