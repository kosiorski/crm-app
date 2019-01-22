package pl.kosiorski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kosiorski.model.Activity;
import pl.kosiorski.model.Project;
import pl.kosiorski.service.ActivityService;
import pl.kosiorski.service.ProjectService;

import java.util.List;

@Controller
public class HomePageController {

  private final ProjectService projectService;
  private final ActivityService activityService;

  @Autowired
  public HomePageController(ProjectService projectService, ActivityService activityService) {
    this.projectService = projectService;
    this.activityService = activityService;
  }

  @GetMapping("/home")
  public String homePage(Model model) {
    List<Project> projects = projectService.lastFive();
    List<Activity> activities = activityService.lastTwentyFive();
    model.addAttribute("projects", projects);
    model.addAttribute("activities", activities);
    return "user/home";
  }
}
