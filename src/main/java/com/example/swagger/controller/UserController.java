package com.example.swagger.controller;

import com.example.swagger.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "GET user by ID", response = User.class)
    public ResponseEntity<User> getUser(
            @ApiParam(value = "User ID to get the object", required = true)
            @PathVariable("id") Long id) {
        LOG.info("GET user by id: {}", id);
        return ResponseEntity.ok(new User("Duck", "DuckPass"));
    }

    @PostMapping
    @ApiOperation(value = "POST an user", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity createUser(@Valid @RequestBody User user, BindingResult result) {
        LOG.info("POST user: {}", user.getName());
        if (result.hasErrors()) {
            LOG.info("Validation erros: {}", result.getAllErrors());
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        return ResponseEntity.ok(new User("Duck", "DuckPass"));
    }
}
