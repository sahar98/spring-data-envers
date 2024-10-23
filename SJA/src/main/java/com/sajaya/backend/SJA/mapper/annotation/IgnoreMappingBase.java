package com.sajaya.backend.SJA.mapper.annotation;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "createDate", ignore = true)
@Mapping(target = "updateDate", ignore = true)
@Mapping(target = "deleteDate", ignore = true)
@Mapping(target = "creatorNationalId", ignore = true)
@Mapping(target = "updaterNationalId", ignore = true)
public @interface IgnoreMappingBase {
}
