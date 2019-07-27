package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {
    Group findByName(String name);
    List<Group> findAllByUserId(String id);
}