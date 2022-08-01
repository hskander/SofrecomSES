package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.*;
import com.sofrecom.sofrecomSES.Service.EmployeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeRessource {
    private final EmployeServiceInterface employeeService;
    @Autowired
    public EmployeRessource(EmployeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employe>> getAllEmployees(){
        List<Employe> employees=this.employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find")
    public ResponseEntity<Employe> findEmployeeByMatricule(@RequestParam("id") Long id){
        Employe employee= this.employeeService.getEmployeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<?> deleteEmployee(@RequestParam("id") Long id){
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employe> addEmployee(@RequestBody Employe employe,@RequestParam("posteId") Long posteId,@RequestParam("poleId") Long poleId){
        return new ResponseEntity<>(this.employeeService.addEmployee(employe,posteId,poleId), HttpStatus.CREATED);
    }

    @PutMapping("/editEmployee")
    public ResponseEntity<Employe> updateEmployee(@RequestBody Employe employee)
    {
        return new ResponseEntity<>(this.employeeService.updateEmployee(employee),HttpStatus.OK);
    }
    @PutMapping("/AffecterDiplomeEmployee")
    public ResponseEntity<Employe> AffecterDiplomeEmployee(@RequestBody DiplomeDetails diplomeDetails,@RequestParam("employeId") Long employeId
            ,@RequestParam("diplomeId")Long diplomeId,@RequestParam("institutId") Long institutId)
    {
        return new ResponseEntity<>(this.employeeService.AffecterDiplomeEmployee(diplomeDetails,employeId,diplomeId,institutId),HttpStatus.OK);
    }
    @PutMapping("/AffecterCertificatEmployee")
    public ResponseEntity<Employe> AffecterCertificatEmployee(@RequestBody CertificatDetails certificatDetails,@RequestParam("employeId") Long employeId
            ,@RequestParam("certificatId")Long certificatId,@RequestParam("centreFormationId") Long centreFomationId)
    {
        return new ResponseEntity<>(this.employeeService.AffecterCertificatEmployee(certificatDetails,employeId,certificatId,centreFomationId),HttpStatus.OK);
    }
    @PutMapping("/AffecterExperienceEmployee")
    public ResponseEntity<Employe> AffecterExperienceEmployee(@RequestBody Experience experience,@RequestParam("employeId") Long employeId
    ,@RequestParam("entrepriseId") Long entrepriseId)
    {
        return new ResponseEntity<>(this.employeeService.AffecterExperienceEmployee(experience,employeId,entrepriseId),HttpStatus.OK);
    }
    @GetMapping("/searchEmployeeByNomPrenom")
    public ResponseEntity<List<Employe>> searchEmployeeByNomPrenom(@RequestParam("nomPrenom") String nomPrenom){
        return new ResponseEntity<>(this.employeeService.findEmployeesByNomPrenomEmail(nomPrenom), HttpStatus.OK);
    }

    @GetMapping("/searchEmployeeByPoste")
    public ResponseEntity<List<Employe>> searchEmployeeByPoste(@RequestParam("poste") String poste){
        return new ResponseEntity<>(this.employeeService.findEmployeesByPoste(poste), HttpStatus.OK);
    }


}
