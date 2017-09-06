package com.ctsi.backup.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ctsi.backup.pojo.User;
import com.ctsi.backup.service.UserService;
import com.ctsi.backup.utils.ListClause;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class UserModel extends WebService{

	Logger logger = Logger.getLogger(UserModel.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	public UserModel(@Context UriInfo uriInfo, @Context HttpHeaders headers, @Context SecurityContext securityContext) {
		super(uriInfo, headers, securityContext);
	}

	public UserModel() {}
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response create( User user) throws Exception {
		User us = new User();
		try {
			us = userService.add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok().entity(us).build();
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update( User user) throws Exception {
		try {
			userService.upate(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok().entity(user).build();
	}
	

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") String id) throws Exception {
		int delete = 0;
		try {
			delete = userService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok().entity(delete).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response bareHostlists(@DefaultValue("{}") @QueryParam("param") ListClause<String, String> clause) throws Exception {
		List<User> users = new ArrayList<User>();
		try {
			users = userService.queryList(clause.getClause());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok().entity(users).header("total", users.size()).build();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(@PathParam("id") String id) throws Exception {
		User user = null;
		try {
			user = userService.queryById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.ok().entity(user).build();
	}
}
