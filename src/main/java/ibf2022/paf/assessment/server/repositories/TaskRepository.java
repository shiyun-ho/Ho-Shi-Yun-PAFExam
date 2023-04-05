package ibf2022.paf.assessment.server.repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.services.TaskNotFoundException;

// TODO: Task 6
@Repository
public class TaskRepository {

    private static final String SQL_INSERT_TASK_BY_NAME = "insert into task(description, priority, due_date, username) values (?, ?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate; 

    public Task insertTask(String description, Integer priority, Date dueDate, String username) throws TaskNotFoundException{
        //need to handle exception

        int updated = jdbcTemplate.update(SQL_INSERT_TASK_BY_NAME, description, priority, dueDate, username); 

        if (updated <= 0){
            throw new TaskNotFoundException("Unable to insert task: %s \n\n for user %s".formatted(description, username)); 
        }
        return null;
    }


}
