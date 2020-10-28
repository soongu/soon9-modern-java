package kr.co.kokono.modernj.chap02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static kr.co.kokono.modernj.chap02.FilteringApples.Color.*;

public class FilteringApples {

    /**
     @solution - try 1
     @problem
     - 만약 빨간사과를 필터링하고 싶다면?? filterRedApples를 만들 것인지?
     - 다양한 색의 사과를 필터링해야 한다면??
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN == apple.getColor()) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @solution - try 2: 색을 파라미터화한다.
     * @problem
     *  만약 필터기준에 색상이 아닌 무게가 필요하다면??
     *  두번째 파라미터로 무게를 전달받는 메서드를 만들 것인가??
     *  그러면 무게 비교 조건문 빼고 나머지 코드는 동일할텐데?
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @solution - try 3:  동작 파라미터화 - 추상적 조건으로 필터링
     *  a. 사과의 필터 조건에 따라 참 거짓을 반환하게 하는 메서드를 가진 ApplePredicate를 정의한다.
     *  b. 특정 조건을 설정할 클래스들을 정의하고 기능을 만든다.
     *  c. 위 내용을 기반으로 필터 메서드를 정의한다.
     *
     * @problem
     *  필터조건별 클래스가 너무 많아진다. 익명클래스로 해결하자 test코드로 이동
     *  사과말고 오렌지면?
     */

    //a
    public interface ApplePredicate {
        boolean test(Apple apple); //사과를 주고 필터 조건을 테스트하여 참,거짓을 반환
    }

    //b
    static class AppleWeightPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }

    }

    static class AppleColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == Color.GREEN;
        }

    }

    //c
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @solution - try 4: 리스트 형식으로 추상화
     */

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }



    enum Color { RED, GREEN }

    @Getter @Setter
    @AllArgsConstructor
    @ToString
    public static class Apple {

        private int weight;
        private Color color;

    }

}
