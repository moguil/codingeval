package com.adclear.requeststat.blacklist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UaBlacklistRepository extends JpaRepository<UaBlacklist, Long>{
	@Query("select u from UaBlacklist u where u.ua = :ua")
	public UaBlacklist getUa(@Param("ua") String ua);
  
}
