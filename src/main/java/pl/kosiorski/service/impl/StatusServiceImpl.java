package pl.kosiorski.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.model.Status;
import pl.kosiorski.repository.StatusRepository;
import pl.kosiorski.service.StatusService;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
  private StatusRepository statusRepository;

  @Autowired
  public StatusServiceImpl(StatusRepository statusRepository) {
    this.statusRepository = statusRepository;
  }

  @Override
  public List<Status> findAll() {
    return statusRepository.findAll();
  }

  @Override
  public List<Status> findAllActive() {
    return statusRepository.findAllByIsActiveTrue();
  }

  @Override
  public Status save(Status status) {
    return statusRepository.save(status);
  }

  @Override
  public void changeActive(Long statusId) {
    Status status = statusRepository.findById(statusId);
    status.setIsActive(!status.getActive());
    statusRepository.save(status);
  }
}
