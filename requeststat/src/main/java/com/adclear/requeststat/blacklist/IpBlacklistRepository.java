package com.adclear.requeststat.blacklist;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IpBlacklistRepository extends JpaRepository<IpBlacklist, Long>{
	@Query("select i from IpBlacklist i where i.ip = :ip")
	public IpBlacklist getIp(@Param("ip") long ip);
  
}
