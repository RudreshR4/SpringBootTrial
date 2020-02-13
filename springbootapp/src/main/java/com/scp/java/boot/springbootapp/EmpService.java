package com.scp.java.boot.springbootapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpService extends CrudRepository<EmpEntity,Integer> {

}
