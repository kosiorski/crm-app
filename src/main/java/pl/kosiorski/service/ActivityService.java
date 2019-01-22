package pl.kosiorski.service;

import pl.kosiorski.model.Activity;

import java.util.List;

public interface ActivityService {
  List<Activity> lastTwentyFive();

  Activity save(Activity activity);
}
