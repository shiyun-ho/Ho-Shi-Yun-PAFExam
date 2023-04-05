package ibf2022.paf.assessment.server.services;

import ibf2022.paf.assessment.server.models.Task;

public class TaskNotFoundException extends Exception{
    private Task taskInfo; 

    public TaskNotFoundException(){
        super(); 
    }

    public TaskNotFoundException(String message){
        super(message); 
    }

    public void setTaskInfo(Task taskInfo){
        this.taskInfo = taskInfo; 
    }

    public Task getTaskInfo(){
        return this.taskInfo; 
    }
}
