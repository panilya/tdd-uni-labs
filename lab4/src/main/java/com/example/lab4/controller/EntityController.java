package com.example.lab4.controller;/*
  @author   user
  @project   lab4
  @class  EntityController
  @version  1.0.0
  @since 07.03.2024 - 00.17
*/

import com.example.lab4.dto.EntityDTO;
import com.example.lab4.model.Entity;
import com.example.lab4.service.EntityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/entity")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EntityController {

    EntityService entityService;

    @GetMapping("")
    public List<EntityDTO> getEntities() {
        return entityService.getAll();
    }

    @GetMapping("/{id}")
    public EntityDTO fetchById(@PathVariable String id) {
        return entityService.getOne(id);
    }

}
