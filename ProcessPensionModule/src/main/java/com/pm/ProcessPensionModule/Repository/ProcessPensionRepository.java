package com.pm.ProcessPensionModule.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pm.ProcessPensionModule.Entity.Pensioner;

public interface ProcessPensionRepository extends JpaRepository<Pensioner, Long>{

}
