package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource {

    static List<User> users = new ArrayList<>();

    @GET
    public static List<User> getUsers() {
        return users;
    }

    @POST
    public static void addUser(User user) {
        users.add(user);
    }

    @PUT
    public void updateUser(User user) {
        for (User u : users) {
            if (u.getId().equals(user.getId())) {
                u.setId(user.getId());
                u.setName((String) user.getName());
                u.setEmail((String) user.getEmail());
                break;
            }
        }
    }
    
    @DELETE
    public void deleteUser(@QueryParam("id") Long id) {
        users.removeIf(u -> u.getId().equals(id));
    }

    public static class User {
        private static Long id;
        private String name;
        private String email;

        public Long getId() {
            return id;
        }

        public Object getName() {
            return name;
        }
        public Object getEmail() {
            return email;
        }

        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setId(Long id) {
            User.id = id;
        }
        
    }

}