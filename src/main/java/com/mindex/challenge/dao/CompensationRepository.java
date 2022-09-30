package com.mindex.challenge.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mindex.challenge.entity.CompensationEntity;

/**
 * repository for compensation
 * 
 * @author fredy
 *
 */
@Repository
public interface CompensationRepository extends MongoRepository<CompensationEntity, String> {
	CompensationEntity findByEmployeeId(String employeeId);
}
