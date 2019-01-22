package pl.kosiorski.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.model.Priority;
import pl.kosiorski.repository.PriorityRepository;
import pl.kosiorski.service.PriorityService;

import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {
  private PriorityRepository priorityRepository;

  @Autowired
  public PriorityServiceImpl(PriorityRepository priorityRepository) {
    this.priorityRepository = priorityRepository;
  }

  @Override
  public List<Priority> findAll() {
    return priorityRepository.findAll();
  }

  @Override
  public List<Priority> findAllActive() {
    return priorityRepository.findAllByIsActiveTrue();
  }

  @Override
  public Priority save(Priority priority) {
    return priorityRepository.save(priority);
  }

  @Override
  public void changeActive(Long priorityId) {
    Priority priority = priorityRepository.findById(priorityId);
    priority.setIsActive(!priority.getActive());
    priorityRepository.save(priority);
  }
}
