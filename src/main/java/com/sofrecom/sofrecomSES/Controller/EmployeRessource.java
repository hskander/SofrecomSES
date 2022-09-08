package com.sofrecom.sofrecomSES.Controller;

import com.sofrecom.sofrecomSES.Model.*;
import com.sofrecom.sofrecomSES.Service.CertificatDetailsServiceInterface;
import com.sofrecom.sofrecomSES.Service.DiplomeDetailsServiceInterface;
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
    private final CertificatDetailsServiceInterface certificatDetailsService;

    private final DiplomeDetailsServiceInterface diplomeDetailService;
    @Autowired
    public EmployeRessource(EmployeServiceInterface employeeService, CertificatDetailsServiceInterface certificatDetailsService, DiplomeDetailsServiceInterface diplomeDetailService) {
        this.employeeService = employeeService;
        this.certificatDetailsService = certificatDetailsService;
        this.diplomeDetailService = diplomeDetailService;
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
    @PutMapping("/editEmployeePole")
    public ResponseEntity<Employe> editEmployeePole(@RequestParam("employeeId") Long employeeId,@RequestParam("poleId") Long poleId)
    {
        return new ResponseEntity<>(this.employeeService.editEmployeePole(employeeId,poleId),HttpStatus.OK);
    }
    @GetMapping("/findEmployePole")
    public ResponseEntity<Pole> findEmployePole(@RequestParam("id") Long id){
        return  new ResponseEntity<>(this.employeeService.findEmployePole(id),HttpStatus.OK);
    }
    @GetMapping("/findEmployeDirectionManager")
    public ResponseEntity<Employe> findEmployeDirectionManager(@RequestParam("id") Long id){
        return  new ResponseEntity<>(this.employeeService.findEmployeDirectionManager(id),HttpStatus.OK);
    }

    @PutMapping("/editCertificatDetails")
    public ResponseEntity<CertificatDetails> updateCertificatDetails(@RequestBody CertificatDetails certifDetail,@RequestParam("id") Long id)
    {
        return new ResponseEntity<>(this.certificatDetailsService.updateCertificatDetails(certifDetail, id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteCertifDetails")
    public ResponseEntity<?> deleteCertificatDetail(@RequestParam("id") Long id){
        this.certificatDetailsService.deleteCertificatDetails(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/editDiplomeDetails")
    public ResponseEntity<DiplomeDetails> updateDiplomeDetails(@RequestBody DiplomeDetails diplomeDetails,@RequestParam("id") Long id)
    {
        return new ResponseEntity<>(this.diplomeDetailService.updateDiplomeDetails(diplomeDetails,id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteDiplomeDetails")
    public ResponseEntity<?> deleteDiplomeDetail(@RequestParam("id") Long id){
        this.diplomeDetailService.deleteDiplomeDetails(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/AffecterDiplomeEmployee")
    public ResponseEntity<Employe> AffecterDiplomeEmployee(@RequestBody DiplomeDetails diplomeDetails,@RequestParam("employeId") Long employeId
            ,@RequestParam("diplomeId")Long diplomeId,@RequestParam("institutId") Long institutId)
    {
        return new ResponseEntity<>(this.employeeService.AffecterDiplomeEmployee(diplomeDetails,employeId,diplomeId,institutId),HttpStatus.OK);
    }
    @PostMapping("/AffecterCertificatEmployee")
    public ResponseEntity<Employe> AffecterCertificatEmployee(@RequestBody CertificatDetails certificatDetails,@RequestParam("employeId") Long employeId
            ,@RequestParam("certificatId")Long certificatId,@RequestParam("centreFormationId") Long centreFomationId)
    {
        return new ResponseEntity<>(this.employeeService.AffecterCertificatEmployee(certificatDetails,employeId,certificatId,centreFomationId),HttpStatus.OK);
    }
    @PostMapping("/AffecterExperienceEmployee")
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

    @GetMapping("/getEmployeesByCentreFormation")
    public ResponseEntity<List<Employe>> getEmployeesByCentreFormation(@RequestParam("centreFormationId") Long centreFormationId){
        return new ResponseEntity<>(this.employeeService.findEmployeesByCentreFormation(centreFormationId), HttpStatus.OK);
    }
    @GetMapping("/getEmployeesByCertificat")
    public ResponseEntity<List<Employe>> getEmployeesByCertificat(@RequestParam("certificatId") Long certificatId){
        return new ResponseEntity<>(this.employeeService.findEmployeesByCertificat(certificatId), HttpStatus.OK);
    }
    @GetMapping("/getEmployeesByInstitut")
    public ResponseEntity<List<Employe>> getEmployeesByInstitut(@RequestParam("institutId") Long institutId){
        return new ResponseEntity<>(this.employeeService.findEmployeesByInstitut(institutId), HttpStatus.OK);
    }
    @GetMapping("/getEmployeesByDiplome")
    public ResponseEntity<List<Employe>> getEmployeesByDiplome(@RequestParam("diplomeId") Long diplomeId){
        return new ResponseEntity<>(this.employeeService.findEmployeesByDiplome(diplomeId), HttpStatus.OK);
    }
    @GetMapping("/getEmployeesByEntreprise")
    public ResponseEntity<List<Employe>> getEmployeesByEntreprise(@RequestParam("entrepriseId") Long entrepriseId){
        return new ResponseEntity<>(this.employeeService.findEmployeesByEntreprise(entrepriseId), HttpStatus.OK);
    }
    @GetMapping("/findMales")
    public ResponseEntity<List<Employe>> findMales(){
        return  new ResponseEntity<>(this.employeeService.findMales(Genre.MALE),HttpStatus.OK);
    }
    @GetMapping("/findFemales")
    public ResponseEntity<List<Employe>> findFemales(){
        return  new ResponseEntity<>(this.employeeService.findFemales(Genre.FEMALE),HttpStatus.OK);
    }
    @GetMapping("/findCelibataire")
    public ResponseEntity<List<Employe>> findCelibataire(){
        return  new ResponseEntity<>(this.employeeService.findCelibataire(SituationFamilale.CELIBATAIRE),HttpStatus.OK);
    }
    @GetMapping("/findMarie")
    public ResponseEntity<List<Employe>> findMarie(){
        return  new ResponseEntity<>(this.employeeService.findMarie(SituationFamilale.MARIE),HttpStatus.OK);
    }
    @GetMapping("/findEmployeByYearRecrut")
    public ResponseEntity<List<Employe>> findEmployeByYearRecrut(@RequestParam("year") int year){
        return  new ResponseEntity<>(this.employeeService.findEmployeByYearRecrut(year),HttpStatus.OK);
    }
    @GetMapping("/findEmployeByYearDepart")
    public ResponseEntity<List<Employe>> findEmployeByYearDepart(@RequestParam("year") int year){
        return  new ResponseEntity<>(this.employeeService.findEmployeByYearDepart(year),HttpStatus.OK);
    }
}
