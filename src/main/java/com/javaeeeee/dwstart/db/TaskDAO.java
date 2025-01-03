package com.javaeeeee.dwstart.db;

import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import com.javaeeeee.dwstart.api.Task;

import java.util.List;
import java.util.Optional;


public interface TaskDAO {

    // Create a new task
    @SqlUpdate("INSERT INTO tasks (description, status, start_date, target_date) " +
            "VALUES (:description, :status, :startDate, :targetDate)")
    @GetGeneratedKeys
    int insertTask(@BindBean Task task);

    // Retrieve all tasks
    @SqlQuery("SELECT * FROM tasks")
    List<Task> getAllTasks();

    // Retrieve a task by ID
    @SqlQuery("SELECT * FROM tasks WHERE id = :id")
    Optional<Task> getTaskById(@Bind("id") int id);

    // Update a task
    @SqlUpdate("UPDATE tasks SET description = :description, status = :status, " +
            "start_date = :startDate, target_date = :targetDate WHERE id = :id")
    void updateTask(@BindBean Task task, @Bind("id") int id);

    // Delete a task by ID
    @SqlUpdate("DELETE FROM tasks WHERE id = :id")
    void deleteTask(@Bind("id") int id);

    @SqlQuery("SELECT COUNT(*) FROM tasks WHERE id = :id")
    boolean taskExists(@Bind("id") int id);

}
