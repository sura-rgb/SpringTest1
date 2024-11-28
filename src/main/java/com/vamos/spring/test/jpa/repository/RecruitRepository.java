package com.vamos.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vamos.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

	// WHERE `companyId` = #{companyId}
	public List<Recruit> findByCompanyId(int companyId);
	
	// WHERE `position` = #{} AND `type` = #{}
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// WHERE `type` = #{} OR `salary` >= #{}
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// WHERE `type` = #{} ORDER BY `salary` DESC LIMIT 3
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// WHERE `region` = #{} AND `salary` >= #{} AND `salary` BETWEEN #{} AND #{};
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	

	// deadline 컬럼이 특정값 보다 크고 salary가 특정값 보다 크고 type이 일치하는 데이터를 연봉 내림차순으로 조회
	@Query(value="SELECT * FROM `recruit` "
			+ "WHERE `deadline` > :deadline "
			+ "AND `salary` >= :salary "
			+ "AND `type` = :type "
			+ "ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> findByNativeQuery(
			@Param("deadline") String dealline
			, @Param("salary") int salary
			, @Param("type") String type);
}
