package ibf2022.paf.assessment.server.models;

import java.util.Date;

// TODO: Task 4

public class Task {
    private String username; 
    private String description; 
    private Integer priority; 
    private Date dueDate;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    } 

    
}

// payload:
// username: lala
// description-0: ssss
// priority-0: 1
// dueDate-0: 2023-03-28
