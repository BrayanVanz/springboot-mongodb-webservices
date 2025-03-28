package com.brayanvanz.nosqlwebservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brayanvanz.nosqlwebservices.domain.User;
import com.brayanvanz.nosqlwebservices.dto.UserDTO;
import com.brayanvanz.nosqlwebservices.repositories.UserRepository;
import com.brayanvanz.nosqlwebservices.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return repository.save(newUser);
    }
        
    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setemail(user.getemail());
    }
        
    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
