package com.sofrecom.sofrecomSES.Repository;

import com.sofrecom.sofrecomSES.Model.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface DirectionRepository extends JpaRepository<Direction,Long> {
    void deleteDirectionById(Long id);
    Optional<Direction> findDirectionById(Long id);
}
