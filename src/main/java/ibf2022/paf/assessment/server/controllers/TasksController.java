package ibf2022.paf.assessment.server.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.Utils;
import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.services.TodoService;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.servlet.http.HttpSession;

// TODO: Task 4, Task 8
@Controller
@RequestMapping
public class TasksController {

    @Autowired
    TodoService todoSvc; 

    @PostMapping(path = "/task", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postSave(@RequestBody MultiValueMap<String, String> form, Model model, Task task){

        String username = form.getFirst("username"); 
        String description = form.getFirst("description-0"); 
        Integer priority = Integer.valueOf(form.getFirst("priority-0"));
        
        System.out.printf(">>>username: %s \n>>>description: %s \n>>>priority: %s".formatted(username, description, priority));
        //convert strings to a model object
        task = Utils.toTask(username, description, priority); 
        
        model.addAttribute("task", task); 
        List<Task> tasks = List.of(task); 

        User user = new User();
        user.setUsername(username);
        try {
            todoSvc.upsertTask(tasks, user);
            
            return ResponseEntity.status(200).body("Successfully saved!");
            // return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage()); 
        }
        
    } 
    
    // @ResponseBody
    // public ResponseEntity<String> postSave(@RequestBody String payload, Model model){
    //     System.out.printf(">>> payload: %s\n".formatted(payload));

    //     //convert payload to model object Task.java
    //     Task task = Utils.toTask(payload);

    //     //save the task from request to payload
    //     try {
    //         model.addAttribute("task", task);
    //         return ResponseEntity.ok().body(payload); 
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         JsonObject err = Json.createObjectBuilder()
    //                             .add("message", e.getMessage())
    //                             .build();
    //         return ResponseEntity.status(400).body(err.toString()); 
    //     }
         
    // }
    
}

//Task 4
// a) Press save button
// b) Handle the request from landing package
// c) Task from request to be saved to model 'Task.java'
// d) Each Task is a single task. Add members with getters and setters to the task class. 
