package com.his.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.his.entities.User;
import com.his.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Component
@Path("/users")
@Api("Operations pertaining to products in Online Store")
public class HISService extends HISServiceBase {

    private ServiceValidation validation = new ServiceValidation();

    private static final Logger logger = LoggerFactory.getLogger(HISService.class);

    @Autowired
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/getUser/{id}")
    @ApiOperation(value = "View a list of available products", response = User.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"), @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"), @ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    public User getUserById(@PathParam("id") long id) {
        return userService.findByUserId(id);
    }

}