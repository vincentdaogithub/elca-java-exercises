package vn.elca.training.entity.converter;

import vn.elca.training.entity.constant_value.ProjectStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProjectStatusConverter implements AttributeConverter<ProjectStatus, String> {

    @Override
    public String convertToDatabaseColumn(ProjectStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getStatus();
    }

    @Override
    public ProjectStatus convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return ProjectStatus.convert(dbData);
    }
}
