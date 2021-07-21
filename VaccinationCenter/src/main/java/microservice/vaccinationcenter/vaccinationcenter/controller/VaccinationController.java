package microservice.vaccinationcenter.vaccinationcenter.controller;

import com.netflix.discovery.converters.Auto;
import microservice.vaccinationcenter.vaccinationcenter.entity.VaccinationCenter;
import microservice.vaccinationcenter.vaccinationcenter.model.Citizen;
import microservice.vaccinationcenter.vaccinationcenter.model.RequiredResponse;
import microservice.vaccinationcenter.vaccinationcenter.repository.CenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationController {

    @Autowired
    CenterRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addCitizen(@RequestBody VaccinationCenter vacCenter){
        VaccinationCenter vacCenterAdded = repo.save(vacCenter);
        return  new ResponseEntity<VaccinationCenter>(vacCenterAdded, HttpStatus.OK);
    }
    @GetMapping(path="/id/{id}")
    public ResponseEntity<RequiredResponse> getAllDataBasedonCenterId(@PathVariable Integer id){
        RequiredResponse requiredResponse = new RequiredResponse();
         VaccinationCenter vacCenter= repo.findById(id).get();
         requiredResponse.setCenter(vacCenter);
        List<Citizen> listofCitizen = restTemplate.getForObject("http://localhost:8081/citizen/id/"+id, List.class);
        requiredResponse.setCitizens(listofCitizen);
        return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
    }
}
