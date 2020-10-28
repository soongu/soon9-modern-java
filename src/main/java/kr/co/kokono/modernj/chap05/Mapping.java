package kr.co.kokono.modernj.chap05;

import kr.co.kokono.modernj.chap04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toList;
import static kr.co.kokono.modernj.chap04.Dish.menu;

public class Mapping {

    public static void main(String[] args) {
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println("dishNames = " + dishNames);

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println("wordLengths = " + wordLengths);

        /**
         * Quiz - 숫자리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환하세요
         * [1,2,3,4,5]가 주어지면 [1,4,9,16,25] 를 반환해야 함.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(toList());
        System.out.println("squares = " + squares);
    }

}
