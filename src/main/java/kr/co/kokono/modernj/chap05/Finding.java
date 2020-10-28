package kr.co.kokono.modernj.chap05;

import kr.co.kokono.modernj.chap04.Dish;

import java.util.Optional;

import static kr.co.kokono.modernj.chap04.Dish.menu;

public class Finding {

    public static void main(String[] args) {

    }

    private static boolean isVegetarianFriendlyMenu() {
        //anyMatch: 주어진 스트림에서 적어도 한 요소와 일치하는지 확인
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        //allMatch: 모든 요소가 조건에 일치하는지 확인
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        //nonMatch: allMatch와 반대연산
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }
}
