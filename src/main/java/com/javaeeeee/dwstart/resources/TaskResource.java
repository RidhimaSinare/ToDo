package com.javaeeeee.dwstart.resources;

import com.javaeeeee.dwstart.api.Task;
import com.javaeeeee.dwstart.db.TaskDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {
    private final TaskDAO taskDAO;

    public TaskResource(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GET
    public List<Task> getAllTasks() {
        return taskDAO.getAllTasks();
    }

    @GET
    @Path("/{id}")
    public Optional<Task> getTask(@PathParam("id") int id) {
        return taskDAO.getTaskById(id);
    }

    @POST
    public Response createTask(Task task) {
        int id = taskDAO.insertTask(task);

        return Response.status(Response.Status.CREATED)
                .entity("Task created successfully with ID: " + id)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTask(@PathParam("id") int id, Task updatedTask) {
        boolean exists = taskDAO.taskExists(id);

        if (!exists) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Task with ID " + id + " not found.")
                    .build();
        }

        taskDAO.updateTask(updatedTask, id);
        return Response.ok("Task updated successfully.").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTask(@PathParam("id") int id) {
        boolean exists = taskDAO.taskExists(id);

        if (!exists) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Task with ID " + id + " not found.")
                    .build();
        }

        taskDAO.deleteTask(id);
        return Response.ok("Task deleted successfully.").build();
    }
}
