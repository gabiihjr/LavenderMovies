package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.domain.models.Writer;
import com.api.lavendermovies.dtos.GetPersonDto;
import com.api.lavendermovies.forms.PersonForm;
import com.api.lavendermovies.repository.WriterRepository;
import com.api.lavendermovies.config.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
public class WriterService {
    @Autowired
    final WriterRepository writerRepository;

    public WriterService(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    public PersonForm save(PersonForm writerForm) {
        var writer = ObjectMapper.map(writerForm, Writer.class);
        writer.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        writerRepository.save(writer);

        return writerForm;
    }

    public List<GetPersonDto> findAll() {
        var writersList = writerRepository.findAll();

        return ObjectMapper.mapAll(writersList, GetPersonDto.class);
    }

    public GetPersonDto findById(UUID id) {
        var writer = writerRepository.findById(id).orElseThrow(() -> new BusinessException("Writer not found"));

        return ObjectMapper.map(writer, GetPersonDto.class);
    }

    public PersonForm update(PersonForm writerForm, UUID id) {
        var writer = writerRepository.findById(id).orElseThrow(() -> new BusinessException("Writer not found"));

        BeanUtils.copyProperties(writerForm, writer);

        writer.setId(writer.getId());
        writer.setCreatedAt(writer.getCreatedAt());
        writer.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        writerRepository.save(writer);

        return writerForm;
    }

    public void delete(UUID id) {
        var writer = writerRepository.findById(id).orElseThrow(() -> new BusinessException("Writer not found"));

        writerRepository.delete(writer);
    }
}
