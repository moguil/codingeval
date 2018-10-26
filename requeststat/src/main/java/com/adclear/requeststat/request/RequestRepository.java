package com.adclear.requeststat.request;

/*
 * interface used to access object in the database
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<HourlyStat, Integer>{
		
	@Query("select h from HourlyStat h where h.customerId = :customerId")
	List<HourlyStat> findByCustomerID(@Param("customerId") int customerId);	
	
	@Query("select h from HourlyStat h where h.day = :day")
	List<HourlyStat> findByDay(@Param("day") int day);
    
}
