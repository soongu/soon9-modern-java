package kr.co.kokono.modernj.chap05.exercise;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int value;

    @Override
    public String toString() {
        return String.format("{%s, year: %d, value: %d}", trader, year, value);
    }
}
