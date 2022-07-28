package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employe,Long> {
    void deleteEmployeById(Long id);
    Optional<Employe> findEmployeById(Long id);
}
