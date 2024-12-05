package beans;

import java.util.Objects;

public class Task {
    private int taskid;
    private String taskname;
    private String taskdate;
    int taskstatus;
    int regid;

    public Task(int taskid, String taskname, String taskdate, int taskstatus, int regid) {
        this.taskid = taskid;
        this.taskname = taskname;
        this.taskdate = taskdate;
        this.taskstatus = taskstatus;
        this.regid = regid;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskdate() {
        return taskdate;
    }

    public void setTaskdate(String taskdate) {
        this.taskdate = taskdate;
    }

    public int getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(int taskstatus) {
        this.taskstatus = taskstatus;
    }

    public int getRegid() {
        return regid;
    }

    public void setRegid(int regid) {
        this.regid = regid;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskid=" + taskid +
                ", taskname='" + taskname + '\'' +
                ", taskdate='" + taskdate + '\'' +
                ", taskstatus=" + taskstatus +
                ", regid=" + regid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return taskid == task.taskid && taskstatus == task.taskstatus && regid == task.regid && Objects.equals(taskname, task.taskname) && Objects.equals(taskdate, task.taskdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskid, taskname, taskdate, taskstatus, regid);
    }
}
