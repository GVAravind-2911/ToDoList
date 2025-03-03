<%--
  Created by IntelliJ IDEA.
  User: gvara
  Date: 12/4/2024
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="beans.Task"%>
<%@page import="java.util.List"%>
<%@page import="dao.ToDoDAOImpl"%>
<%@page import="dao.ToDoDAOIntf"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Tasks</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <p class="text-right bg-light p-2">
        Welcome
        <%
            ToDoDAOIntf dao = ToDoDAOImpl.getInstance();
            int regId = Integer.parseInt(session.getAttribute("regId").toString());
            String fname = dao.getFnameByRegId(regId);
        %>
        <%=fname%>,
        <a href="./LogoutServlet">Logout</a>
    </p>

    <form method="post" action="./AddTaskServlet">
        <div class="form-group">
            <label for="taskName">Task Name</label>
            <input type="text" class="form-control" id="taskName" name="taskName">
        </div>
        <div class="form-group">
            <label for="taskDate">Task Date</label>
            <input type="text" class="form-control" id="taskDate" name="taskDate" placeholder="dd-mm-yyyy">
        </div>
        <div class="form-group">
            <label for="taskStatus">Task Status</label>
            <select class="form-control" id="taskStatus" name="taskStatus">
                <option value="1">Not Yet Started</option>
                <option value="2">In Progress</option>
                <option value="3">Completed</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Add Task</button>
        <button type="reset" class="btn btn-secondary">Clear</button>
    </form>

    <hr class="my-4">

    <%
        List<Task> taskList = dao.findAllTasksByRegId(regId);
    %>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>TaskID</th>
            <th>TaskName</th>
            <th>TaskDate</th>
            <th>TaskStatus</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Task task : taskList) {
                int taskId = task.getTaskid();
                String taskName = task.getTaskname();
                String taskDate = task.getTaskdate();
                int taskStatus = task.getTaskstatus();
        %>
        <tr class="<%= taskStatus == 3 ? "text-muted" : "" %>" style="<%= taskStatus == 3 ? "text-decoration:line-through;" : "" %>">
            <td><%=taskId%></td>
            <td><%=taskName%></td>
            <td><%=taskDate%></td>
            <td>
                <%= taskStatus == 3 ? "Completed" : taskStatus == 2 ? "In Progress" : "Not Started" %>
            </td>
            <td>
                <%
                    if (taskStatus == 3) {
                %>
                <button class="btn btn-secondary btn-sm" disabled>Completed</button>
                <%
                } else if (taskStatus == 2) {
                %>
                <form method="post" action="./MarkTaskCompletedServlet">
                    <input type="hidden" name="taskId" value="<%=taskId%>">
                    <input type="hidden" name="regId" value="<%=regId%>">
                    <button type="submit" class="btn btn-primary btn-sm">Complete</button>
                </form>
                <%
                } else {
                %>
                <form method="post" action="./ChangeTaskStatusServlet">
                    <input type="hidden" name="taskId" value="<%=taskId%>">
                    <input type="hidden" name="regId" value="<%=regId%>">
                    <button type="submit" name="taskStatus" value="2" class="btn btn-primary btn-sm">In Progress</button>
                    <button type="submit" name="taskStatus" value="3" class="btn btn-success btn-sm">Complete</button>
                </form>
                <%
                    }
                %>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>