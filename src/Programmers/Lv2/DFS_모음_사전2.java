package Programmers.Lv2;

class DFS_모음_사전2 {

  // SB + backtracking
    
    int count = 0;
    
    int result = 0;
    
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    
    String word;
    
    void dfs(StringBuilder sb) {
        if (sb.toString().equals(word)) {
            result = count;
            return;  
        }
      if (sb.length() == 5) {
        return;
      }
        
        for (int i = 0; i < 5; i++) {
            count++;
            sb.append(words[i]);
            dfs(sb);
            if (result != 0) {
                return;
            }
            sb.setLength(sb.length() - 1);
            
        }
        return;
    }
    
    public int solution(String word) {
        this.word = word;
        dfs(new StringBuilder());
        return count;
    }
}