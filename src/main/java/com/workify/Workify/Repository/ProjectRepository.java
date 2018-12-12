package com.workify.Workify.Repository;

        import com.workify.Workify.Entity.Project;
        import org.springframework.data.repository.CrudRepository;

        import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findByName(String name);
    List<Project> findAll();
}
