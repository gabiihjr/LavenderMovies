package com.api.lavendermovies.service;

import com.api.lavendermovies.domain.dtos.CreateDirectorDto;
import com.api.lavendermovies.domain.models.Director;
import com.api.lavendermovies.repository.DirectorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    @Autowired
    final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Director save(CreateDirectorDto directorDto) {
        var director = new Director();
        BeanUtils.copyProperties(directorDto, director);
        return directorRepository.save(director);
    }
}
