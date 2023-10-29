package com.example.securitydemo.mapper.base;

/**
 * @Author Kevin  on 2023/10/30
 */
public interface BaseMapper<D, E> {
   E toEntity(D entity);
   D toDTO(E entity);

}
