package pl.kosiorski.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.model.Task;
import pl.kosiorski.repository.TaskRepository;
import pl.kosiorski.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
  private TaskRepository taskRepository;

  @Autowired
  public TaskServiceImpl(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @Override
  public Task save(Task task) {
    return taskRepository.save(task);
  }

  @Override
  public List<Task> findAllByProjectId(Long id) {
    return taskRepository.findAllByProjectId(id);
  }

  @Override
  public Task findOne(Long id) {
    return taskRepository.findById(id);
  }
}
