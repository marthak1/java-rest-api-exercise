package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestMethod;

//Implement the Controller
/*
    * Set the appropriate accessibility modifiers for all members
    * and annotate the class as a RestController.
    */

@RestController // This means that this class is a Controller
@RequestMapping(path = "/api/ious") // This means URL's start with /ious (after Application path)
public class IOUController {

    private final IOUService iouService; // an instance of the service interface

    public IOUController(IOUService iouService) {
        // constructor that accepts an instance of the service
        this.iouService = iouService;
    }

    /*
     * / *Add additional methods that defines endpoints for the following
     * operations:
     */

    // * Method URL Description

    // * GET /api/ious Get all IOUs
    @GetMapping
    public List<IOU> getAllIOUs() throws NoSuchElementException {
        try {
            return iouService.getAllIOUs();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.OK, e.getMessage(), e);
        }
    }

    // * GET /api/ious/{id} Get an IOU by id
    @GetMapping("/{id}")
    public IOU getIOU(@PathVariable UUID id) throws NoSuchElementException {
        try {
            return iouService.getIOU(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.OK, e.getMessage(), e);
        }

    }

    // * POST /api/ious Add an IOU
    @PostMapping
    public IOU createIOU(@RequestBody IOU iou) throws NoSuchElementException {
        try {
            return iouService.createIOU(iou);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.CREATED, e.getMessage(), e);
        }

    }

    // * PUT /api/ious/{id} Replace an IOU by Id
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = "application/jason")
    public IOU updateIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU) {

        return iouService.updateIOU(id, updatedIOU);
    }

    // * DELETE /api/ious/{id} Delete an IOU by id
    @DeleteMapping("/{id}")
    public void deleteIOU(@PathVariable UUID id) throws NoSuchElementException {
        try {
            iouService.deleteIOU(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

}
