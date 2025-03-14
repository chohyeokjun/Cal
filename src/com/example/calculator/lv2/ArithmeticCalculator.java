package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// enum 정의(enum generic 타입을 사용 못함.)
enum Operation {
    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> a / b);

    // 속성
    private final char symbol;
    private final CalculatorLambda calculatorLambda;

    // 생성자
    Operation(char symbol, CalculatorLambda calculatorLambda) {
        this.symbol = symbol;
        this.calculatorLambda = calculatorLambda;
    }

    // 인터페이스 참조 메서드
    public double calculate(double a, double b) {
        return calculatorLambda.calculate(a, b);
    }

    // 입력된 값이 사칙연산 부호에 있는지 확인
    public static Operation Symbol(char operation) {
        return Arrays.stream(Operation.values())  // Operation의 값들을 순회한다.
                .filter(op -> operation == op.symbol)  // 입력받은 부호가 enum의 부호와 일치하는지 확인
                .findFirst()  // 첫 번째 요소를 찾는다.
                .orElseThrow(() -> new IllegalArgumentException("잘못된 부호입니다."));  // null 값일 때 예외처리
    }
}

public class ArithmeticCalculator<T> {
    // 속성
    private List<T> resultList;

    // 생성자
    public ArithmeticCalculator() {
        this.resultList = new ArrayList<>();
    }

    // 결과 저장
    public void saveResultList(T result) {
        resultList.add(result);
    }

    // 결과 배열로 출력(getter)
    public List<T> getResultList() {
        return resultList;
    }

    // (setter)
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    // 먼저 저장된 데이터 삭제
    public void removeResultList() {
        if (resultList.size() >= 5) {
            resultList.remove(0);
        }
    }
}
