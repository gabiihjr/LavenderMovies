package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.config.exceptions.RequiredFieldException;
import com.api.lavendermovies.domain.dtos.CreateDirectorDto;
import com.api.lavendermovies.domain.dtos.GetDirectorDto;
import com.api.lavendermovies.domain.models.Director;
import com.api.lavendermovies.repository.DirectorRepository;
import com.api.lavendermovies.utils.ObjectMapper;
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

    public void requiredFieldExceptions(CreateDirectorDto directorDto) {
        if (directorDto.getName() == null) throw new RequiredFieldException("name");
        if (directorDto.getAge() == 0) throw new RequiredFieldException("age");
    }

    public void notFoundException(UUID id){
        var directorExists = directorRepository.findById(id);

        if (directorExists.isEmpty()) throw new BusinessException("Director not found");
    }

    public CreateDirectorDto save(CreateDirectorDto directorDto) {
        requiredFieldExceptions(directorDto);

        var director = ObjectMapper.map(directorDto, Director.class);
        director.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        directorRepository.save(director);

        return directorDto;
    }

    public List<GetDirectorDto> findAll() {
        var directorList = directorRepository.findAll();

        return ObjectMapper.mapAll(directorList, GetDirectorDto.class);
    }

    public GetDirectorDto findById(UUID id) {
        notFoundException(id);

        var director = directorRepository.getReferenceById(id);

        return ObjectMapper.map(director, GetDirectorDto.class);
    }

    public CreateDirectorDto update(CreateDirectorDto directorDto, UUID id) {
        notFoundException(id);

        requiredFieldExceptions(directorDto);

        var director = directorRepository.getReferenceById(id);

        BeanUtils.copyProperties(directorDto, director);

        director.setId(director.getId());
        director.setCreatedAt(director.getCreatedAt());
        director.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        directorRepository.save(director);

        return directorDto;
    }
}
