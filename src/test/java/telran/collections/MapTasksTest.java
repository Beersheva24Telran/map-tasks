package telran.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
public class MapTasksTest {
  Integer[] numbers = {10, 5, 7, -4, 1};
  LinkedHashMap<Integer, Integer> map ;
  private void setUpMap(){
    map = new LinkedHashMap<>(10, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldestEntry){
            return size() > numbers.length;
        }
        
    };
    Arrays.stream(numbers).forEach(n -> map.put(n, n * n));
  }
  @Test
  void displayOccurrencesTest(){
    String[] strings = {"lpm", "ab", "a", "c", "cb", "cb", "c", "lpm", "lpm"} ;
    MapTasks.displayOccurrences(strings);
  }
  @Test
  void displayOccurrencesStreamTest(){
    String[] strings = {"lpm", "ab", "a", "c", "cb", "cb", "c", "lpm", "lpm"} ;
    MapTasks.displayOccurrencesStream(strings);
  }
  @Test
  void groupingByNumberOfdigitsTest(){
    int[][] array = {{100, 1, 50}, {20, 30}, {1}};
    Map<Integer, Integer[]> map = MapTasks.getGroupingByNumberOfDigits(array);
    Integer[] oneDigitNumbers = {1, 1};
    Integer[] twoDigitsNumbers = {50, 20, 30};
    Integer[] threeDigitsNumbers = {100};
    assertArrayEquals(map.get(1), oneDigitNumbers);
    assertArrayEquals(map.get(2), twoDigitsNumbers);
    assertArrayEquals(map.get(3), threeDigitsNumbers);

  }
  @Test
  void distributionByNumberOfdigitsTest(){
    int[][] array = {{100, 1, 50}, {20, 30}, {1}};
    Map<Integer, Long> map = MapTasks.getDistributionByNumberOfDigits(array);
   assertEquals(2, map.get(1));
   assertEquals(3, map.get(2));
   assertEquals(1, map.get(3));


  }
  @Test
  void digitsDistributionTest() {
    MapTasks.displayDigitsDistribution();
  }
  @Test
  void getParenthesesmapsTest() {
    Character[][] openCloseParentheses = {
      {'[', ']'}, {'(', ')'}, {'{', '}'}
    };
    ParenthesesMaps maps = MapTasks.getParenthesesMaps(openCloseParentheses);
    Map<Character, Character> openCloseMap = maps.openCloseMap();
    Map<Character, Character> closeOpenMap = maps.closeOpenMap();
    assertEquals(']', openCloseMap.get('['));
    assertEquals('[', closeOpenMap.get(']'));
  }
  //Tests of CW #32
  @Test
  void linkedHashMapTest() {
    setUpMap();
    assertArrayEquals(numbers, map.keySet().toArray(Integer[]::new));
  }
  @Test
  void linkedHashMapWithPutTest() {
    setUpMap();
    map.put(3, 9);
    Integer[] expected = {5, 7, -4, 1, 3};
    assertArrayEquals(expected, map.keySet().toArray(Integer[]::new));
  }
  @Test
  void linkedHashMapWithGetAndPutTest() {
    setUpMap();
    map.get(10); //10 will be moved at end
    map.put(3, 9);
    Integer[] expected = { 7, -4, 1, 10, 3};
    assertArrayEquals(expected, map.keySet().toArray(Integer[]::new));
  }



}
