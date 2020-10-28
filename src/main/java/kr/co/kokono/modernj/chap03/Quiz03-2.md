#### 다음 중 함수형 인터페이스는 어느 것인가?
```java
public interface  Adder {
    int add(int a, int b);
}

public interface SmartAdder extends Adder {
    int add(double a, double b);
}

public interface Nothing {
    
}
```
---
정답: Adder만 함수형 인터페이스다. 