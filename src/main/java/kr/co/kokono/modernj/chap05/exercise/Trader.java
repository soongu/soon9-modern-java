package kr.co.kokono.modernj.chap05.exercise;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Trader {
    private final String name;
    private final String city;

    @Override
    public String toString() {
        return String.format("Trader: %s in %s", name, city);
    }
}
