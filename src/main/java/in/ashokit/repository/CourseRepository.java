package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
