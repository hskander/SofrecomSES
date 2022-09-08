package com.sofrecom.sofrecomSES.Service;

import com.sofrecom.sofrecomSES.Exeption.UserNotFoundException;
import com.sofrecom.sofrecomSES.Model.*;
import com.sofrecom.sofrecomSES.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeService implements EmployeServiceInterface {
    //Repositories
    private final EmployeeRepository employeeRepo;
    private final PoleRepository poleRepo;
    private final DirectionRepository directionRepo;
    private final PosteRepository posteRepo;

    //Services

   private final ExperienceServiceInterface experienceService;
    private final DiplomeDetailsServiceInterface diplomeDetailsService;
    private final CertificatDetailsServiceInterface certificatDetailsService;
    private final CentreFormationRepository centreFormationRepository;
    private final CertificatRepositry certificatRepositry;
    private final InstitutRepository institutRepository;
    private final DiplomeRepository diplomeRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final ExperienceRepository experienceRepository;
    private final DiplomeDetailsRepository diplomeDetailsRepository;
    private final CertificatDetailsRepository certificatDetailsRepository;

    @Autowired
    public EmployeService(EmployeeRepository employeeRepo,PoleRepository poleRepo,DirectionRepository directionRepo,PosteRepository posteRepo,
                          ExperienceServiceInterface experienceService, DiplomeDetailsServiceInterface diplomeDetailsService, CertificatDetailsServiceInterface certificatDetailsService
                          ,CentreFormationRepository centreFormationRepository, InstitutRepository institutRepository,
                          EntrepriseRepository entrepriseRepository,ExperienceRepository experienceRepository,
                          DiplomeDetailsRepository diplomeDetailsRepository,CertificatDetailsRepository certificatDetailsRepository,
                          DiplomeRepository diplomeRepository, CertificatRepositry certificatRepositry) {
        this.employeeRepo = employeeRepo;
        this.poleRepo=poleRepo;
        this.directionRepo=directionRepo;
        this.posteRepo=posteRepo;
        this.experienceService=experienceService;
        this.certificatDetailsService=certificatDetailsService;
        this.diplomeDetailsService=diplomeDetailsService;
        this.centreFormationRepository=centreFormationRepository;
        this.certificatRepositry=certificatRepositry;
        this.institutRepository=institutRepository;
        this.diplomeRepository=diplomeRepository;
        this.entrepriseRepository=entrepriseRepository;
        this.experienceRepository=experienceRepository;
        this.diplomeDetailsRepository=diplomeDetailsRepository;
        this.certificatDetailsRepository=certificatDetailsRepository;
    }
    @Override
    public Employe addEmployee(Employe employe, Long posteId, Long poleId){
        if(poleId!=0){
            Pole pole = this.poleRepo.findPoleById(poleId).
                    orElseThrow(()->new UserNotFoundException("Pole with ID "+poleId+" was not found" ));
            employe.setPole(pole);
        }
        Poste poste= this.posteRepo.findPosteById(posteId).
                orElseThrow(()->new UserNotFoundException("Poste with ID "+posteId+" was not found" ));

        employe.setPoste(poste);
        employe.setEmployeCode(UUID.randomUUID().toString());

        return this.employeeRepo.save(employe);
    }
    @Override
    public Employe AffecterDiplomeEmployee(DiplomeDetails diplomeDetails,Long employeId,Long diplomeId, Long institutId){
        this.diplomeDetailsService.addDiplomeDetails(diplomeDetails,diplomeId,institutId,employeId);
        return this.employeeRepo.findEmployeById(employeId).
                orElseThrow(()->new UserNotFoundException("Employe with ID "+employeId+" was not found" ));
    }
    @Override
    public Employe AffecterCertificatEmployee(CertificatDetails certificatDetails,Long employeId,Long certificatId,Long centreFormationId){
        this.certificatDetailsService.addCertificatDetails(certificatDetails,certificatId,centreFormationId,employeId);
        return this.employeeRepo.findEmployeById(employeId).
                orElseThrow(()->new UserNotFoundException("Employe with ID "+employeId+" was not found" ));

    }
    @Override
    public Employe AffecterExperienceEmployee(Experience experience,Long employeId,Long entrepriseId){

       this.experienceService.addExperience(experience,entrepriseId,employeId);
       return this.employeeRepo.findEmployeById(employeId).
                orElseThrow(()->new UserNotFoundException("Employe with ID "+employeId+" was not found" ));

    }
    @Override
    public List<Employe> getAllEmployees(){
        return this.employeeRepo.findAll();
    }
    @Override
    public Employe getEmployeById(Long id){
        return this.employeeRepo.findEmployeById(id)
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+id+" was not found" ));
    }
    @Override
    public Employe updateEmployee(Employe e){
        Employe employe =this.employeeRepo.findEmployeById(e.getId())
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+e.getId()+" was not found" ));
        e.setPole(employe.getPole());
        e.setListCertificatDetails(employe.getListCertificatDetails());
        e.setListDiplomeDetails(employe.getListDiplomeDetails());
        e.setExperiences(employe.getExperiences());
        return this.employeeRepo.save(e);
    }
    @Override
    public Employe editEmployeePole(Long employeeId,Long  poleId){
        Employe employe =this.employeeRepo.findEmployeById(employeeId)
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+employeeId+" was not found" ));
        Pole pole =this.poleRepo.findPoleById(poleId)
                .orElseThrow(()->new UserNotFoundException("Pole with ID "+poleId+" was not found" ));
        employe.setPole(pole);
        return this.employeeRepo.save(employe);
    }
    @Override
    public void deleteEmployee(Long id){
       Direction direction= this.directionRepo.findDirectionByManager(id);
       Pole pole = this.poleRepo.findPoleByManager(id);
       if(direction!=null){
           direction.setManager(null);
       }
       if(pole!=null){
           pole.setManager(null);
       }
        this.employeeRepo.deleteEmployeById(id);
    }

    @Override
    public Pole findEmployePole(Long id) {
        Pole testPole=new Pole();
        Employe employe =this.employeeRepo.findEmployeById(id)
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+id+" was not found" ));
        if(employe.getPole()!=null){
            return employe.getPole();
        }else{
            return testPole;
        }

    }

    @Override
    public Employe findEmployeDirectionManager(Long emlpoyeId){
        Employe testEmploye=new Employe();
        Employe employe =this.employeeRepo.findEmployeById(emlpoyeId)
                .orElseThrow(()->new UserNotFoundException("Employe with ID "+emlpoyeId+" was not found" ));
        if(employe.getPole()!=null&&employe.getPole().getDirection()!=null&&employe.getPole().getDirection().getManager()!=null){

            return employe.getPole().getDirection().getManager();
        }else{
            return testEmploye;
        }

    }

    @Override
    public List<Employe> findEmployeesByNomPrenomEmail(String nomPrenom) {
        return this.employeeRepo.findEmployeesByNomPrenomEmail(nomPrenom);
    }

    @Override
    public List<Employe> findEmployeesByPoste(String poste) {
        return this.employeeRepo.findEmployeesByPoste(poste);
    }

    @Override
    public List<Employe> findEmployeesByCentreFormation(Long centreFormationId) {
        CentreFormation centreFormation=this.centreFormationRepository.findCentreFormationById(centreFormationId).
                orElseThrow(()->new UserNotFoundException("CentreFormation with ID "+centreFormationId+" was not found" ));
        return this.certificatDetailsRepository.findEmployeesByCentreFormation(centreFormation);

    }
    @Override
    public List<Employe> findEmployeesByCertificat(Long certificatId) {
        Certificat certificat=this.certificatRepositry.findCertificatById(certificatId).
                orElseThrow(()->new UserNotFoundException("certificat with ID "+certificatId+" was not found" ));
        return this.certificatDetailsRepository.findEmployeesByCertificat(certificat);
    }

    @Override
    public List<Employe> findEmployeesByInstitut(Long institutId) {
        Institut institut=this.institutRepository.findInstitutById(institutId).
                orElseThrow(()->new UserNotFoundException("institut with ID "+institutId+" was not found" ));
        return this.diplomeDetailsRepository.findEmployeesByInstitut(institut);
    }
    @Override
    public List<Employe> findEmployeesByDiplome(Long diplomeId) {
        Diplome diplome=this.diplomeRepository.findDiplomeById(diplomeId).
                orElseThrow(()->new UserNotFoundException("diplome with ID "+diplomeId+" was not found" ));
        return this.diplomeDetailsRepository.findEmployeesByDiplome(diplome);
    }

    @Override
    public List<Employe> findEmployeesByEntreprise(Long entrepriseId) {
        Entreprise entreprise=this.entrepriseRepository.findEntrepriseById(entrepriseId).
                orElseThrow(()->new UserNotFoundException("entreprise with ID "+entrepriseId+" was not found" ));
        return this.experienceRepository.findEmployeesByEntreprise(entreprise);
    }

    @Override
    public List<Employe> findMales(Genre genre) {
        return this.employeeRepo.findMales(genre);
    }
    @Override
    public List<Employe> findFemales(Genre genre) {
        return this.employeeRepo.findFemales(genre);
    }

    @Override
    public List<Employe> findCelibataire(SituationFamilale sf) {
        return this.employeeRepo.findCelibataire(sf);
    }

    @Override
    public List<Employe> findMarie(SituationFamilale sf) {
        return this.employeeRepo.findMarie(sf);
    }

    @Override
    public List<Employe> findEmployeByYearRecrut(int year) {
        return this.employeeRepo.findEmployeByYearRecrut(year);
    }
    @Override
    public List<Employe> findEmployeByYearDepart(int year) {
        return this.employeeRepo.findEmployeByYearDepart(year);
    }

}
