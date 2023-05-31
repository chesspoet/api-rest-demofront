package org.api.demo.Repository;

import org.api.demo.Model.Task;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task,Long> {
    //Optional<Task>
}