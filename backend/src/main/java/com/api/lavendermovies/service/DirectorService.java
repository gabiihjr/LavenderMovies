package com.api.lavendermovies.service;

import com.api.lavendermovies.domain.dtos.CreateDirectorDto;
import com.api.lavendermovies.domain.dtos.GetDirectorDto;
import com.api.lavendermovies.domain.models.Director;
import com.api.lavendermovies.repository.DirectorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorService {
    @Autowired
    final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public CreateDirectorDto save(CreateDirectorDto directorDto) {
        var director = new Director();
        BeanUtils.copyProperties(directorDto, director);
        directorRepository.save(director);
        return directorDto;
    }

    public List<GetDirectorDto> findAll() {
        var directorList = directorRepository.findAll();
        var getDirectorList = new ArrayList<GetDirectorDto>();
        BeanUtils.copyProperties(directorList, getDirectorList);
        return getDirectorList;
    }
}
