package microservice.vaccinationcenter.vaccinationcenter.controller;

import microservice.vaccinationcenter.vaccinationcenter.entity.VaccinationCenter;
import microservice.vaccinationcenter.vaccinationcenter.model.Citizen;
import microservice.vaccinationcenter.vaccinationcenter.repository.CenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationController {

    @Autowired
    CenterRepo repo;

    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vacCenter){
        VaccinationCenter vacCenterAdded = repo.save(vacCenter);
        return  new ResponseEntity<VaccinationCenter>(vacCenterAdded, HttpStatus.OK);
    }
}
