package com.example.securitydemo.mapper;

import com.example.securitydemo.dto.RegisterRequest;
import com.example.securitydemo.entity.User;
import com.example.securitydemo.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import static org.mapstruct.MappingConstants.ComponentModel.*;

/**
 * @Author Kevin  on 2023/10/30
 */
@Mapper(componentModel = SPRING)
public interface RegisterMapper extends BaseMapper<RegisterRequest, User> {
}
