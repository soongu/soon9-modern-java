package kr.co.kokono.modernj.chap05.exercise;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class PuttingIntoPratice {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 질의 1: 2011년에 발생한 모든 거래를 찾아 값으로 정렬(작은 값에서 큰 값).
        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println("tr2011 = " + tr2011);

        // 질의 2: 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        List<String> cities = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println("cities = " + cities);

        // 질의 3: Cambridge에 근무하는 모든 거래자를 찾아 이름순으로 정렬.
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println("traders = " + traders);

        // 질의 4: 모든 거래자의 이름을 알파벳순으로 정렬하여 반환
        List<String> names = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(toList());
        System.out.println("names = " + names);

        // 질의 5: Milan에 거주하는 거래자가 있는가?
        boolean milanBased = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("milanBased = " + milanBased);

        // 질의 6: Cambridge에 사는 거래자의 모든 거래내역(value) 출력.
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 질의 7: 모든 거래에서 최고값은 얼마인가?
        Integer highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Math::max);
        System.out.println("highestValue = " + highestValue);

        int highestValue2 = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();
        System.out.println("highestValue2 = " + highestValue2);



        // 질의 8: 가장 작은 값을 가진 거래 탐색
        Optional<Transaction> smallestTransaction = transactions.stream()
                .min(comparing(Transaction::getValue));
        smallestTransaction.ifPresent(System.out::println);

    }

}
