package Programmers.PCCE;
import java.util.*;

public class 데이터_분석_10번 {

  // Map 으로 init 하고 indexOf 사용해도 가능
  // 또한 stream() 을 사용해서 filter 로 거르고 sorted 사용해서 정렬 후 변환 가능

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
      int[][] answer = {};

      String[] extList = {"code", "date", "maximum", "remain"};

      int sortIndex = 0;
      int extIndex = 0;

      for (int i = 0; i < extList.length; i++) {
        if (extList[i].equals(sort_by)) {
          sortIndex = i;
        }
        if (extList[i].equals(ext)) {
          extIndex = i;
        }
      }

      List<List<Integer>> result = new ArrayList<>();

      for (int[] d : data) {
        if (d[extIndex] < val_ext) {
          List<Integer> l = new ArrayList<>();
          for (int i : d) {
            l.add(i);
          }
          result.add(l);
        }
      }

      final int sIndex = sortIndex;

      result.sort((a, b) ->
          Integer.compare(a.get(sIndex), b.get(sIndex)));

      int[][] arr = new int[result.size()][];

      for (int i = 0; i < result.size(); i++) {
        List<Integer> row = result.get(i);
        arr[i] = new int[row.size()];
        for (int j = 0; j < row.size(); j++) {
          arr[i][j] = row.get(j);
        }
      }


      return arr;
    }
  }

