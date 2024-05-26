package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

//Implement the Service
@Service
public class IOUServiceList implements IOUService {
    public IOURepository iouRepository;

    // constructor
    public IOUServiceList(IOURepository iouRepository) {
        this.iouRepository = iouRepository;

    }

    /*
     * Set the appropriate accessibility modifiers for all members
     * and annotate the class as a Service. Ensure your code appropriately
     * handles any exceptions thrown by the repository class.
     */
    @Override
    public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException {
        try {
            return iouRepository.save(null);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void deleteIOU(UUID id) {
        iouRepository.deleteById(id);

    }

    @Override
    public List<IOU> getAllIOUs() {

        return iouRepository.findAll();
    }

    @Override
    public IOU getIOU(UUID id) throws NoSuchElementException {
        try {
            return iouRepository.findById(id).orElse(null);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException();
        }

    }

    @Override
    public IOU updateIOU(UUID id, IOU updatedIOU) throws NoSuchElementException {
        try {
            return iouRepository.save(updatedIOU);
        } catch (NoSuchElementException e) {

        }
        throw new NoSuchElementException();
    }

}
