package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.Certificat;
import com.sofrecom.sofrecomSES.Model.Diplome;
import com.sofrecom.sofrecomSES.Model.Employe;
import com.sofrecom.sofrecomSES.Model.Experience;
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

    /* @PostMapping("/addEmployee")
    public ResponseEntity<Employe> addEmployee(@RequestBody Employe employe,@RequestParam("posteMatricule") Long posteMatricule,@RequestParam("poleMatricule") Long poleMatricule,
                                               List<Experience> experiences, List<Diplome> diplomes, List<Certificat> certificats,
                                               @RequestParam("entrepriseMatricule") Long entrepriseMatricule,@RequestParam("instituMatricule") Long instituMatricule,@RequestParam("cfMatricule") Long cfMatricule){

        return new ResponseEntity<>(this.employeeService.addEmployee(employe,posteMatricule,poleMatricule,
                experiences,diplomes,certificats,entrepriseMatricule,instituMatricule,cfMatricule
                ), HttpStatus.CREATED);
    }*/

    @PutMapping("/editEmployee")
    public ResponseEntity<Employe> updateEmployee(@RequestBody Employe employee)
    {
        return new ResponseEntity<>(this.employeeService.updateEmployee(employee),HttpStatus.OK);
    }
}
