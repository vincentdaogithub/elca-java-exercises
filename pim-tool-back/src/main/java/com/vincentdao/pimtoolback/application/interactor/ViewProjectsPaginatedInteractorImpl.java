package com.vincentdao.pimtoolback.application.interactor;

import java.util.Collection;
import java.util.Collections;

import com.vincentdao.pimtoolback.application.boundary.input.ViewProjectsPaginatedInteractor;
import com.vincentdao.pimtoolback.application.boundary.output.Presenter;
import com.vincentdao.pimtoolback.application.model.ProjectModel;
import com.vincentdao.pimtoolback.application.model.request.ViewProjectsPaginatedRequestModel;
import com.vincentdao.pimtoolback.application.model.response.ResponseModel;

public class ViewProjectsPaginatedInteractorImpl implements ViewProjectsPaginatedInteractor {

    private static int PAGE_SIZE = 10;

    private final Presenter<Collection<ProjectModel>> presenter;

    public ViewProjectsPaginatedInteractorImpl(Presenter<Collection<ProjectModel>> presenter) {
        this.presenter = presenter;
    }

    @Override
    public ResponseModel<Collection<ProjectModel>> viewProjectsPaginated(ViewProjectsPaginatedRequestModel request) {
        return presenter.prepareSuccessView(Collections.emptyList());
    }
}
