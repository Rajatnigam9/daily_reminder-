/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.Date;

/**
 *
 * @author Clay
 */
public class Task {

   

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getTaskdate() {
        return taskdate;
    }

    public void setTaskdate(Date taskdate) {
        this.taskdate = taskdate;
    }
    String user,task;
    Date taskdate;
   int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
