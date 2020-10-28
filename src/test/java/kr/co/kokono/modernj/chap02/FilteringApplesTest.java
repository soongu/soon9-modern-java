package kr.co.kokono.modernj.chap02;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static kr.co.kokono.modernj.chap02.FilteringApples.Apple;
import static kr.co.kokono.modernj.chap02.FilteringApples.Color.GREEN;
import static kr.co.kokono.modernj.chap02.FilteringApples.Color.RED;
import static kr.co.kokono.modernj.chap02.FilteringApples.*;

public class FilteringApplesTest {

    List<Apple> inventory;

    @Before
    public void init() {
        inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED)
        );
    }

    @Test
    public void testFilterGreenApple() throws Exception {
        //given

        //when
        List<Apple> greenApples = filterGreenApples(inventory);
        //then
        System.out.println("greenApples = " + greenApples);
    }

    @Test
    public void testFilterApplesByColor() throws Exception {
        //given

        //when
        List<Apple> greenApples = filterApplesByColor(inventory, GREEN);
        List<Apple> redApples = filterApplesByColor(inventory, RED);
        //then
        System.out.println("greenApples = " + greenApples);
        System.out.println("redApples = " + redApples);

    }
    
    @Test
    public void testFilterApplePredicate() throws Exception {
        //given
        
        //when
        List<Apple> greenApples = filterApples(inventory, new AppleColorPredicate());
        List<Apple> heavyApples = filterApples(inventory, new AppleWeightPredicate());
        //then
        System.out.println("greenApples = " + greenApples);
        System.out.println("heavyApples = " + heavyApples);
    }

    @Test
    public void testWithAnonymousClass() throws Exception {

        //빨간 사과를 필터링해야한다!
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED == apple.getColor();
            }
        });

        System.out.println("redApples = " + redApples);

    }

    @Test
    public void testWithLambda() throws Exception {
        //given

        //when
        List<Apple> redApples = filterApples(inventory, apple -> apple.getColor() == RED);
        //then
        System.out.println("redApples = " + redApples);
    }

    @Test
    public void testWithGenericFilter() throws Exception {
        //given
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //when
        List<Integer> evens = filter(numbers, n -> n % 2 == 0);
        //then
        System.out.println("evens = " + evens);
    }

}