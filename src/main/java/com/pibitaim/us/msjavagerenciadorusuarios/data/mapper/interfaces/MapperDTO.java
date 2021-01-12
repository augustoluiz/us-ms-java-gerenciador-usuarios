package com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.interfaces;

public interface MapperDTO<Entity, DTO> {

      DTO converteParaDTO(Entity e);

}
