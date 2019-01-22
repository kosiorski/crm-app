package pl.kosiorski.service;

import pl.kosiorski.model.Status;

import java.util.List;

public interface StatusService {
  List<Status> findAll();

  List<Status> findAllActive();

  Status save(Status status);

  void changeActive(Long statusId);
}
