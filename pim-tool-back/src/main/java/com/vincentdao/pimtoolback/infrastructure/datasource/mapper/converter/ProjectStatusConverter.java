/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.infrastructure.datasource.mapper.converter;

import com.vincentdao.pimtoolback.domain.project.ProjectStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ProjectStatusConverter implements AttributeConverter<ProjectStatus, String> {

    @Override
    public String convertToDatabaseColumn(ProjectStatus attribute) {
        return attribute.getStatusCode();
    }

    @Override
    public ProjectStatus convertToEntityAttribute(String dbData) {
        return ProjectStatus.convertFrom(dbData);
    }
}
