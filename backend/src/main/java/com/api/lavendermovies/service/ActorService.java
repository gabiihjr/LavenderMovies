package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.domain.models.Actor;
import com.api.lavendermovies.dtos.GetActorDto;
import com.api.lavendermovies.forms.ActorForm;
import com.api.lavendermovies.repository.ActorRepository;
import com.api.lavendermovies.utils.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@Service
public class ActorService {
    @Autowired
    final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ActorForm save(ActorForm actorForm) {
        var actor = ObjectMapper.map(actorForm, Actor.class);
        actor.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        actorRepository.save(actor);

        return actorForm;
    }

    public List<GetActorDto> findAll() {
        var actorList = actorRepository.findAll();

        return ObjectMapper.mapAll(actorList, GetActorDto.class);
    }

    public GetActorDto findById(UUID id) {
        var actor = actorRepository.findById(id).orElseThrow(() -> new BusinessException("Actor not found"));

        return ObjectMapper.map(actor, GetActorDto.class);
    }

    public ActorForm update(ActorForm actorForm, UUID id) {
        var actor = actorRepository.findById(id).orElseThrow(() -> new BusinessException("Actor not found"));

        BeanUtils.copyProperties(actorForm, actor);

        actor.setId(actor.getId());
        actor.setCreatedAt(actor.getCreatedAt());
        actor.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        actorRepository.save(actor);

        return actorForm;
    }

    public void delete(UUID id) {
        var actor = actorRepository.findById(id).orElseThrow(() -> new BusinessException("Actor not found"));

        actorRepository.delete(actor);
    }
}
