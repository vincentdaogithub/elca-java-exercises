package com.vincentdao.pimtoolback.application.boundary.input;

import java.util.Collection;

import com.vincentdao.pimtoolback.application.model.ProjectModel;
import com.vincentdao.pimtoolback.application.model.request.ViewProjectsPaginatedRequestModel;
import com.vincentdao.pimtoolback.application.model.response.ResponseModel;

public interface ViewProjectsPaginatedInteractor {

    ResponseModel<Collection<ProjectModel>> viewProjectsPaginated(ViewProjectsPaginatedRequestModel request);
}
