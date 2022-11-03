package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.dtos.GetPersonDto;
import com.api.lavendermovies.forms.PersonForm;
import com.api.lavendermovies.domain.models.Director;
import com.api.lavendermovies.repository.DirectorRepository;
import com.api.lavendermovies.config.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
public class DirectorService {
    @Autowired
    final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public PersonForm save(PersonForm directorForm) {
        var director = ObjectMapper.map(directorForm, Director.class);
        director.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        directorRepository.save(director);

        return directorForm;
    }

    public List<GetPersonDto> findAll() {
        var directorList = directorRepository.findAll();

        return ObjectMapper.mapAll(directorList, GetPersonDto.class);
    }

    public GetPersonDto findById(UUID id) {
        var director = directorRepository.findById(id).orElseThrow(() -> new BusinessException("Director not found"));

        return ObjectMapper.map(director, GetPersonDto.class);
    }

    public PersonForm update(PersonForm directorForm, UUID id) {
        var director = directorRepository.findById(id).orElseThrow(() -> new BusinessException("Director not found"));

        BeanUtils.copyProperties(directorForm, director);

        director.setId(director.getId());
        director.setCreatedAt(director.getCreatedAt());
        director.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        directorRepository.save(director);

        return directorForm;
    }

    public void delete(UUID id) {
        var director = directorRepository.findById(id).orElseThrow(() -> new BusinessException("Director not found"));

        directorRepository.delete(director);
    }
}
