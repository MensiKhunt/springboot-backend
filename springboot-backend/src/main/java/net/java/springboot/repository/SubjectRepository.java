package net.java.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
