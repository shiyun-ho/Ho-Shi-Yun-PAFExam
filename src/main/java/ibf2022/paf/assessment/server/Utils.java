package ibf2022.paf.assessment.server;

import java.io.StringReader;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Utils {

    //convert sqlrowset to model object class
    public static User toUser(SqlRowSet rs){
        User user = new User(); 

        user.setUserId(rs.getString("user_id"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));

        return user; 
    }

    public static Task toTask(String username, String description, Integer priority){
        Task task = new Task(); 

        task.setUsername(username);
        task.setDescription(description);
        task.setPriority(priority);

        return task; 
    }

    // //toTask
    // public static Task toTask(String jsonStr){
    //     Task task = new Task(); 
    //     JsonReader reader = Json.createReader(new StringReader(jsonStr));
    //     JsonObject json = reader.readObject(); 
        
    //     //create the getters and setters in Task.java
    //     //get the payload
    //     task.setUsername(json.getString("username"));
    //     task.setDescription(json.getString("description"));
    //     task.setPriority(json.getInt("priority"));
    //     task.setDueDate((Date) json.getJsonObject("dueDate"));

    //     return task; 
        
    // }
}
