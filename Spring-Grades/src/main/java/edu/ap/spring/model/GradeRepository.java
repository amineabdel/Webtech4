package edu.ap.spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface GradeRepository extends CrudRepository<Grade, Long>{



}
