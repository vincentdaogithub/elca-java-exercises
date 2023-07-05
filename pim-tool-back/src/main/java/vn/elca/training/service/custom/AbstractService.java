package vn.elca.training.service.custom;

import vn.elca.training.model.mapper.EntityMapper;

public class AbstractService {

    protected final EntityMapper entityMapper;

    public AbstractService(EntityMapper entityMapper) {
        this.entityMapper = entityMapper;
    }
}
