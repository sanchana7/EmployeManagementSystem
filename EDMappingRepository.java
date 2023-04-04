package com.example.springboot.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Department;
import com.example.springboot.model.EDMapping;


@Repository
public interface EDMappingRepository extends JpaRepository<EDMapping, Long> {



@Transactional
@Modifying
@Query(value= "update mst_tblempdeptmapping set \"emp_id\" = '101' where id =:dept_id",nativeQuery= true)
public void edmappingDel(@Param("dept_id")int edmappingid );

@Query(value=" select  mt3.name as empName ,mt2.name as deptName , mt3.age ,mt4.name as deptHead,mt3.email_id , mt3.contact , mt3.address , mt2.dept_head \r\n"
		+ "				from mst_tblempdeptmapping mt \r\n"
		+ "				inner join mst_tbldepartment mt2 \r\n"
		+ "				on mt.dept_id = mt2.id \r\n"
		+ "				inner join mst_tblemployee mt3 \r\n"
		+ "				on mt.emp_id =mt3.id \r\n"
		+ "				left join mst_tblemployee mt4 \r\n"
		+ "				on mt2.dept_head = mt4.id and mt4.active=true\r\n"
		+ "				where  mt2.active = true and mt3.active=true", nativeQuery = true)
public List<Map<String,Object>> getedpmappingAll();

@Query(value=" select  mt3.name as empName ,mt2.name as deptName , mt3.age ,mt4.name as deptHead,mt3.email_id , mt3.contact , mt3.address , mt2.dept_head\r\n"
		+ "		from mst_tblempdeptmapping mt \r\n"
		+ "		inner join mst_tbldepartment mt2 \r\n"
		+ "		on mt.dept_id = mt2.id \r\n"
		+ "		inner join mst_tblemployee mt3 \r\n"
		+ "		on mt.emp_id =mt3.id \r\n"
		+ "		left join mst_tblemployee mt4 \r\n"
		+ "		on mt2.dept_head = mt4.id and mt4.active=true\r\n"
		+ "		where  mt2.active = true and mt3.active=true and mt.id=:id ", nativeQuery = true)
	public List<Map<String,Object>> getedmappingByID(@Param ("id") Long id);

}
