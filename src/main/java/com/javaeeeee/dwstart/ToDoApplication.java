package com.javaeeeee.dwstart;

import com.javaeeeee.dwstart.db.TaskMapper;
import com.javaeeeee.dwstart.health.TaskHealthCheck;
import com.javaeeeee.dwstart.resources.TaskResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import io.dropwizard.jdbi3.JdbiFactory;
import org.jdbi.v3.core.Jdbi;
import com.javaeeeee.dwstart.db.TaskDAO;

public class ToDoApplication extends Application<ToDoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ToDoApplication().run(args);
    }

//    @Override
//    public String getName() {
//        return "ToDo";
//    }
//
//    @Override
//    public void initialize(final Bootstrap<ToDoConfiguration> bootstrap) {
//        // TODO: application initialization
//    }

    @Override
    public void run(final ToDoConfiguration configuration, Environment environment) {
        // TODO: implement application
        Jdbi jdbi = Jdbi.create(configuration.getDataSourceFactory().getUrl(),
                configuration.getDataSourceFactory().getUser(),
                configuration.getDataSourceFactory().getPassword());
        jdbi.installPlugin(new SqlObjectPlugin());

        // Register TaskMapper
        jdbi.registerRowMapper(new TaskMapper());

        TaskDAO taskDAO = jdbi.onDemand(TaskDAO.class);
        environment.jersey().register(new TaskResource(taskDAO));

        // Register Health Check
        final TaskHealthCheck healthCheck = new TaskHealthCheck(jdbi);
        environment.healthChecks().register("database", healthCheck);

    }

}
