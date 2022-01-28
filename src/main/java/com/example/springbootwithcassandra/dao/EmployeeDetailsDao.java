package com.example.springbootwithcassandra.dao;

import com.example.springbootwithcassandra.entity.EmployeeDetailsEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeDetailsDao extends CassandraRepository<EmployeeDetailsEntity, UUID> {
}
