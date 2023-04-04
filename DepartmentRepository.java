package com.example.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

 @Query(value="select  * from mst_tbldepartment mt where mt.active =false",nativeQuery = true)
 
List<Department> getAllDepartment();


@Transactional
@Modifying
@Query(value= "update mst_tbldepartment set \"name\" = 'IT' where id =:departmentid",nativeQuery= true)
public void departmentDel(@Param("departmentid")int departmentid );


	
}
