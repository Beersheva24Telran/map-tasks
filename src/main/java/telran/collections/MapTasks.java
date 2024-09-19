package telran.collections;

import java.util.*;

public class MapTasks {
public static void displayOccurrences(String[] strings) {
    //input {"lpm", "ab", "a", "c", "cb", "cb", "c", "lpm", "lpm"} 
    //output:
    //lpm -> 3
    //c -> 2
    //cb -> 2
    //a -> 1
    //ab -> 1
    HashMap<String, Long> occurrencesMap = getMapOccurrences(strings);
   TreeMap<Long, TreeSet<String>> sortedOccurrencesMap = getSortedOccurrencesMap(occurrencesMap);
   displaySortedOoccurrencesMap(sortedOccurrencesMap);
}

private static void displaySortedOoccurrencesMap(TreeMap<Long, TreeSet<String>> sortedOccurrencesMap) {
    sortedOccurrencesMap.forEach((occurrency, treeSet) -> treeSet.forEach(s -> System.out.printf("%s -> %d \n", s, occurrency)) );
}

private static TreeMap<Long, TreeSet<String>> getSortedOccurrencesMap(HashMap<String, Long> occurrencesMap) {
  TreeMap<Long, TreeSet<String>> result = new TreeMap<>(Comparator.reverseOrder());
  occurrencesMap.entrySet().forEach(e -> result.computeIfAbsent(e.getValue(),
   k -> new TreeSet<>()).add(e.getKey())); 
   return result;
}

private static HashMap<String, Long> getMapOccurrences(String[] strings) {
    HashMap<String, Long> result = new HashMap<>();
    Arrays.stream(strings).forEach(s -> result.merge(s, 1l, Long::sum));
    return result;
}
}
