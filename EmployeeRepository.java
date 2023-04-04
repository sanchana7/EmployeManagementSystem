package com.example.springboot.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.EDMapping;
import com.example.springboot.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

@Transactional
@Modifying
@Query(value= "update mst_tblemployee set active = 'false' where id =:employeeid",nativeQuery= true)
public void employeeDel(@Param("employeeid")Long employeeid );

@Transactional
@Modifying
@Query(value= "update mst_tblemployee set active = 'false' where id in (:employeeid)",nativeQuery= true)
public void updateemployeeid(@Param ("employeeid") List<Long> employeeid);


	
}
