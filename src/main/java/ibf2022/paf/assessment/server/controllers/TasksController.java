package ibf2022.paf.assessment.server.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import ibf2022.paf.assessment.server.Utils;
import ibf2022.paf.assessment.server.models.Task;
import jakarta.json.Json;
import jakarta.json.JsonObject;

// TODO: Task 4, Task 8
@Controller
@RequestMapping
public class TasksController {

    @PostMapping(path = "/task", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> postsave(@RequestBody String payload, Model model){
        System.out.printf(">>> payload: %s\n".formatted(payload));

        //convert payload to model object Task.java
        Task task = Utils.toTask(payload);
        
        //check for scenarios where the account exists?

        //save the task from request to payload
        try {
            model.addAttribute("task", task);
            return ResponseEntity.ok().body(payload); 
        } catch (Exception e) {
            // TODO: handle exception
            JsonObject err = Json.createObjectBuilder()
                                .add("message", e.getMessage())
                                .build();
            return ResponseEntity.status(400).body(err.toString()); 
        }
         

        
    }
    
}

//Task 4
// a) Press save button
// b) Handle the request from landing package
// c) Task from request to be saved to model 'Task.java'
// d) Each Task is a single task. Add members with getters and setters to the task class. 
