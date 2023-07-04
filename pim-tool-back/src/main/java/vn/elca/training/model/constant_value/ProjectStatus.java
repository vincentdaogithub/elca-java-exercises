package vn.elca.training.model.constant_value;

import vn.elca.training.model.exception.InvalidProjectStatusException;

import java.util.stream.Stream;

public enum ProjectStatus {

    NEW("NEW"),
    PLANNED("PLA"),
    IN_PROGRESS("INP"),
    FINISHED("FIN");

    private final String status;

    ProjectStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static ProjectStatus convert(String status) {
        if (status == null) {
            throw new InvalidProjectStatusException();
        }
        return Stream.of(ProjectStatus.values())
                .filter(p -> p.getStatus().equals(status))
                .findFirst().orElseThrow(InvalidProjectStatusException::new);
    }
}
