# Modern Java in Action

#### chap02 - 동작 파라미터화 예제
#### chap03 - 람다 표현식
- 5가지 람다 표현식
  1. `(String s) -> s.length()` : String형식의 파라미터 하나를 가지며 int를 반환한다. 람다표현식에는 return이 함축되어 있다.
  1. `(Apple a) -> a.getWeight() > 150` : Apple형식의 파라미터 하나를 가지며 boolean을 반환한다.
  1. int형식의 2개의 파라미터를 가지며 리턴값이 없다.
     ```
     (int x, int y) -> {
         System.out.println("Result:");
         System.out.println(x + y);
     }
     ```
  1.`() -> 42` : 파라미터가 없으며 42를 반환한다.
      