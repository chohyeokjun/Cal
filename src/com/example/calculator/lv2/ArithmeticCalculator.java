package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.List;

// enum 정의
enum Operation {
    PLUS('+') {
        public double calculate(double a, double b) {
            return a + b;
        }
    },
    MINUS('-') {
        public double calculate(double a, double b) {
            return a - b;
        }
    },
    MULTIPLY('*') {
        public double calculate(double a, double b) {
            return a * b;
        }
    },
    DIVIDE('/') {
        public double calculate(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("0이 아닌 숫자를 입력하세요.");
            } else {
                return a / b;
            }
        }
    };

    // 속성
    private final char symbol;

    // 생성자
    Operation(char symbol) {
        this.symbol = symbol;
    }

    // 추상 메서드
    public abstract double calculate(double a, double b);

    // 입력된 값이 사칙연산 부호에 있는지 확인
    public static Operation Symbol(char symbol) {
        for (Operation op : values()) {
            if (op.symbol == symbol) {
                return op;
            }
        }
        throw new IllegalArgumentException("잘못 입력하셨습니다.");
    }
}

public class ArithmeticCalculator<T> {

    // 속성
    private List<T> resultList;


    // 생성자
    public ArithmeticCalculator() {
        this.resultList = new ArrayList<>();
    }

    // 기능: enum 을 사용
    public double calculate(double a, double b, char operation) {
        Operation op = Operation.Symbol(operation);
        return op.calculate(a, b);
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
    public void removeResultList(T result) {
        if (resultList.size() >= 5) {
            resultList.remove(0);
        }
    }
}
