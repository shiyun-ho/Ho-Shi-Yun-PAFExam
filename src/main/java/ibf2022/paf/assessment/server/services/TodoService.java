package ibf2022.paf.assessment.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7
@Service
public class TodoService {

    @Autowired
    TaskRepository taskRepo; 

    @Autowired
    UserRepository userRepo; 

    public boolean userExists(String username){
            //checks if user exists
            return userRepo.findUserByUsername(username).isPresent(); 
        }
    //create method upsertTask
        //function: insert a list of tasks for a particular user into the db
        //if user does not exist, create the user before inserting the tasks
    
    @Transactional (rollbackFor = TaskNotFoundException.class)
    public Boolean upsertTask(List<Task> tasks, User user) throws Exception{
        Boolean result = userExists(((Task) tasks).getUsername().toString()); 
        if (!result){
            //create a user
            userRepo.insertUser(user); 
        } 

        for (Task task: tasks){
            try {
                //create a list of tasks into Task List
                result = tasks.add(taskRepo.insertTask(task.getDescription(), task.getPriority(), task.getDueDate(), task.getUsername()));
                
            } catch (TaskNotFoundException tnfex) {
                // TODO: handle exception
                throw new TaskNotFoundException("Unable to insert task: %s \n".formatted(task.getDescription())); 
            }
            
        }

        return result; 
    }
    
    

}
