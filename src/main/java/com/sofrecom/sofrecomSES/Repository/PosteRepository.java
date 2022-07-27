package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PosteRepository  extends JpaRepository<Poste,Long> {
}
