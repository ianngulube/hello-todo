package za.co.mafsoft.jee8.rest;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import lombok.NoArgsConstructor;
import za.co.mafsoft.jee8.entity.Todo;
import za.co.mafsoft.jee8.service.TodoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@NoArgsConstructor(force = true)
public class TodoRest {

    private final TodoService todoService;

    @Inject
    public TodoRest(final TodoService todoService) {
        this.todoService = todoService;
    }

    @POST
    @Path("new")
    public Response createTodo(@Valid Todo todo) {
        assert todoService != null;
        return Response.ok(todoService.createTodo(todo)).build();
    }

    @POST
    @Path("edit")
    public Response editTodo(Todo todo) {
        assert todoService != null;
        return Response.ok(todoService.updateTodo(todo)).build();
    }

    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
        assert todoService != null;
        return Response.ok(todoService.findTodo(id)).build();
    }

    @GET
    @Path("list")
    public Response getTodos() {
        assert todoService != null;
        return Response.ok(todoService.getTodos()).build();
    }

    @PUT
    @Path("complete")
    public Response markAsComplete(@QueryParam("id") Long id) {
        assert todoService != null;
        Todo todo = todoService.findTodo(id);
        todo.setCompleted(true);
        return Response.ok(todoService.updateTodo(todo)).build();
    }
}
