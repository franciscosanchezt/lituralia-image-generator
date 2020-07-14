package com.campusdual.lituraliaimagegenerator.repositories;

import com.campusdual.lituraliaimagegenerator.domain.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Integer> {


}
