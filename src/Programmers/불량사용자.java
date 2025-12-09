package Programmers;

import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {

  Set<Set<String>> result = new HashSet<>();

  void dfs(String[] user_id, String[] banned_id,
      int idx, Set<String> current) {
    if (idx == banned_id.length) {
      result.add(new HashSet<>(current));
      return;
    }

    for (String user : user_id) {
      if (!current.contains(user) &&
          user.matches(banned_id[idx].replace("*", "."))) {
        current.add(user);
        dfs(user_id, banned_id, idx + 1, current);
        current.remove(user);
      }
    }
  }

  public int solution(String[] user_id, String[] banned_id) {

    dfs(user_id, banned_id, 0, new HashSet<>());

    return result.size();
  }
}

