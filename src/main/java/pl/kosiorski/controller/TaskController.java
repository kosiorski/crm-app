package pl.kosiorski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kosiorski.model.Activity;
import pl.kosiorski.model.Task;
import pl.kosiorski.service.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/task")
public class TaskController {
  private final TaskService taskService;
  private final UserService userService;
  private final ProjectService projectService;
  private final PriorityService priorityService;
  private final StatusService statusService;
  private final ActivityService activityService;

  @Autowired
  public TaskController(
      TaskService taskService,
      UserService userService,
      ProjectService projectService,
      PriorityService priorityService,
      StatusService statusService,
      ActivityService activityService) {
    this.taskService = taskService;
    this.userService = userService;
    this.projectService = projectService;
    this.priorityService = priorityService;
    this.statusService = statusService;
    this.activityService = activityService;
  }

  @GetMapping("/add/{id}")
  public String projectForm(Model model, @PathVariable Long id) {
    Task task = new Task();
    task.setProject(projectService.findOne(id));
    model.addAttribute("projectUsers", userService.findByProjectId(id));
    model.addAttribute("task", task);
    return "forms/task";
  }

  @PostMapping("/add")
  public String addPost(Principal principal, @Valid Task task, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("projectUsers", userService.findByProjectId(task.getProject().getId()));
      return "forms/task";
    }
    taskService.save(task);
    activityService.save(
        new Activity(
            "New task added to project "
                + task.getProject().getName()
                + "by user: "
                + principal.getName(),
            LocalDateTime.now()));
    return "redirect:/project/tasks/" + task.getProject().getId();
  }

  @GetMapping(path = "/status/{id}")
  public String changeStatusForm(@PathVariable Long id, Model model) {
    Task task = taskService.findOne(id);
    model.addAttribute("task", task);
    model.addAttribute("users", userService.findByProjectId(task.getProject().getId()));
    return "/task/task_status";
  }

  @PostMapping(path = "/status")
  public String changeStatus(
      Principal principal, @Valid Task task, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("users", userService.findByProjectId(task.getProject().getId()));
      return "/task/task_status";
    }
    taskService.save(task);
    activityService.save(
        new Activity(
            "Task status changed "
                + task.getProject().getName()
                + "by user: "
                + principal.getName(),
            LocalDateTime.now()));
    return "redirect:/task/all/" + task.getProject().getId();
  }

  @GetMapping(path = "/edit/{id}")
  public String editForm(@PathVariable Long id, Model model) {
    Task task = taskService.findOne(id);
    model.addAttribute("task", task);
    model.addAttribute("projectUsers", userService.findByProjectId(task.getProject().getId()));
    return "/task/task_edit";
  }

  @PostMapping(path = "/edit/{id}")
  public String edit(@Valid @ModelAttribute("task") Task task, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("projectUsers", userService.findByProjectId(task.getProject().getId()));
      return "/task/task_edit";
    }
    taskService.save(task);
    return "redirect:/project/tasks/" + task.getProject().getId();
  }

  @ModelAttribute
  public void modelAttributes(Model model) {
    model.addAttribute("statuses", statusService.findAllActive());
    model.addAttribute("priorities", priorityService.findAllActive());
  }
}
