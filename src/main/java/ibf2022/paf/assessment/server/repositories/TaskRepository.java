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

    //batch update
    // public int[] add(List<Task> tasks){
    //     List<Object[]> params = tasks.stream()
    //                                 .map(task -> new Object[]{ task.getDescription(), task.getPriority(), task.getDueDate(), 
    //                                 task.getUsername()})
    //                                 .collect(Collectors.toList()); 

    //     int added [] = jdbcTemplate.batchUpdate(SQL_INSERT_TASK_BY_NAME, params); 

    //     return added; 
    // }

    // public int[] batchInsert(List<Task> tasks){
    //     return jdbcTemplate.batchUpdate(SQL_INSERT_TASK_BY_NAME, new BatchPreparedStatementSetter() {

    //         @Override
    //         public int getBatchSize() {
    //             return tasks.size(); 
    //         }

    //         @Override
    //         public void setValues(PreparedStatement ps, int i) throws SQLException {
    //             ps.setString(1, t;
    //         }
            
    //     })
    // }


   
    // public int[] batchInsert(List<RSVP> rsvp) {
    //         return jdbcTemplate.batchUpdate(insertSQL, (BatchPreparedStatementSetter) new BatchPreparedStatementSetter() {

    //                 // rsvp.getFullName(), rsvp.getEmail(), rsvp.getPhone(),
    //                 //        rsvp.getConfirmationDate(), rsvp.getComments()
    //                 public void setValues(PreparedStatement ps, int i) throws SQLException {
    //                         ps.setString(1, rsvp.get(i).getFullName());
    //                         ps.setString(2,rsvp.get(i).getEmail());
    //                         ps.setInt(3, rsvp.get(i).getPhone());
    //                         ps.setDate(4, rsvp.get(i).getConfirmationDate());
    //                         ps.setString(5, rsvp.get(i).getComments());
    //                 }

    //                 public int getBatchSize() {
    //                         return rsvp.size();
    //                 }


    //         });
    // }


}
