package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.forms.DirectorForm;
import com.api.lavendermovies.dtos.GetDirectorDto;
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

    public DirectorForm save(DirectorForm directorDto) {
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
        var director = directorRepository.findById(id).orElseThrow(() -> new BusinessException("Director not found"));

        return ObjectMapper.map(director, GetDirectorDto.class);
    }

    public DirectorForm update(DirectorForm directorDto, UUID id) {
        var director = directorRepository.findById(id).orElseThrow(() -> new BusinessException("Director not found"));

        BeanUtils.copyProperties(directorDto, director);

        director.setId(director.getId());
        director.setCreatedAt(director.getCreatedAt());
        director.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        directorRepository.save(director);

        return directorDto;
    }

    public void delete(UUID id) {
        var director = directorRepository.findById(id).orElseThrow(() -> new BusinessException("Director not found"));

        directorRepository.delete(director);
    }
}
