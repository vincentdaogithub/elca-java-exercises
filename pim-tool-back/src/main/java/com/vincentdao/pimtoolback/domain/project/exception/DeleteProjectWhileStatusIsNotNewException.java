package com.vincentdao.pimtoolback.domain.project.exception;

public class DeleteProjectWhileStatusIsNotNewException extends ProjectException {

    public DeleteProjectWhileStatusIsNotNewException() {
        super("Attempt to delete project that is not new");
    }
}
