package kr.co.kokono.modernj.chap05;

import kr.co.kokono.modernj.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static kr.co.kokono.modernj.chap04.Dish.*;

public class Filtering {

    public static void main(String[] args) {
        //Predicate로 필터링
        System.out.println("Filtering with a predicate");
        List<Dish> vegeterianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        vegeterianMenu.forEach(System.out::println);

        //고유 요소 필터링
        System.out.println("\nFiltering unique elements:");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // 스트림 연결
        List<Dish> dishesLimit3 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
        System.out.println("\nTruncating a stream:");
        dishesLimit3.forEach(System.out::println);

        // 요소 생략
        List<Dish> dishesSkip2 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println("\nSkipping elements:");
        dishesSkip2.forEach(System.out::println);

        /**
         * Quiz
         * 스트림을 사용해서 처음 등장하는 두 고기 요리를 필터링하세요.
         */
        List<Dish> dishes = menu.stream()
                .filter(m -> m.getType() == Type.MEAT)
                .limit(2)
                .collect(toList());
        System.out.println("dishes = " + dishes);
    }
}
