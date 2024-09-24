package telran.collections;

import java.util.Map;

public record ParenthesesMaps(Map<Character, Character> openCloseMap,
 Map<Character, Character> closeOpenMap) {
  //openCloseMap - key is openning parentheses, value is closing parenthese
  //closeOpenMAp - key is closing parentheses , value is openning parentheses
}
