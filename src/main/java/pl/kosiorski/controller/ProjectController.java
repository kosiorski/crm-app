package pl.kosiorski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kosiorski.model.Activity;
import pl.kosiorski.model.Project;
import pl.kosiorski.model.User;
import pl.kosiorski.service.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
  private final ProjectService projectService;
  private final UserService userService;
  private final TaskService taskService;
  private final ActivityService activityService;

  @Autowired
  public ProjectController(
      ProjectService projectService,
      UserService userService,
      TaskService taskService,
      ActivityService activityService) {
    this.projectService = projectService;
    this.userService = userService;
    this.taskService = taskService;
    this.activityService = activityService;
  }

  @ModelAttribute("users")
  public List<User> users() {
    return userService.findAll();
  }

  @GetMapping("/list")
  public String showAllProjects(Model model) {
    List<Project> projects = projectService.findAll();
    model.addAttribute("projects", projects);
    return "project/project_list";
  }

  @GetMapping("/add")
  public String projectForm(Model model) {
    Project project = new Project();
    model.addAttribute("project", project);
    return "forms/project";
  }

  @PostMapping("/add")
  public String addPost(Principal principal, @Valid Project project, BindingResult result) {
    if (result.hasErrors()) {
      return "forms/project";
    }

    project.setIdentifier(projectService.createIdentifier(project.getName()));

    projectService.save(project);
    activityService.save(
        new Activity("New project created by user: " + principal.getName(), LocalDateTime.now()));
    return "redirect:/project/list";
  }

  @GetMapping("/details/{id}")
  public String projectDetails(@PathVariable Long id, Model model) {
    model.addAttribute("project", projectService.findOne(id));
    return "project/project_details";
  }

  @GetMapping("/tasks/{id}")
  public String projectTasks(@PathVariable Long id, Model model) {
    model.addAttribute("tasks", taskService.findAllByProjectId(id));
    return "project/project_tasks";
  }

  @GetMapping(value = "/edit/{id}")
  public String edit(@PathVariable Long id, Model model) {
    Project project = projectService.findOne(id);
    model.addAttribute("command", project);

    return "project/project_edit";
  }

  @PostMapping(value = "/editsave")
  public String editsave(@ModelAttribute("project") Project project, Principal principal) {
    project.setIdentifier(projectService.createIdentifier(project.getName()));

    activityService.save(
        new Activity(
            "Project " + project.getName() + " edited by user: " + principal.getName(),
            LocalDateTime.now()));
    projectService.save(project);
    return "redirect:/project/list";
  }
}
