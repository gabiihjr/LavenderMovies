package com.api.lavendermovies.service;

import com.api.lavendermovies.domain.dtos.CreateDirectorDto;
import com.api.lavendermovies.domain.dtos.GetDirectorDto;
import com.api.lavendermovies.domain.models.Director;
import com.api.lavendermovies.repository.DirectorRepository;
import com.api.lavendermovies.utils.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        return ObjectMapper.mapAll(directorList, GetDirectorDto.class);
    }

    public GetDirectorDto findById(UUID id) {
        var director = directorRepository.getReferenceById(id);
        return ObjectMapper.map(director, GetDirectorDto.class);
    }
}
