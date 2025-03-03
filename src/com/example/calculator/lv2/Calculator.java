package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // enum 정의
    public enum Operation {
        PLUS('+') {
            public int calculate(int a, int b) {
                return a + b;
            }
        },
        MINUS('-') {
            public int calculate(int a, int b) {
                return a - b;
            }
        },
        MULTIPLY('*') {
            public int calculate(int a, int b) {
                return a * b;
            }
        },
        DIVIDE('/') {
            public int calculate(int a, int b) {
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
        public abstract int calculate(int a, int b);

        // 입력된 값이 사칙연산 부호에 있는지 확인
        public static Calculator.Operation Symbol(char symbol) {
            for (Calculator.Operation op : Calculator.Operation.values()) {
                if (op.symbol == symbol) {
                    return op;
                }
            }
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }

    // 속성
    private List<Integer> resultList;


    // 생성자
    public Calculator() {
        this.resultList = new ArrayList<>();
    }

    // 기능: enum 을 사용
    public int calculate(int a, int b, char operation) {
        Calculator.Operation op = Calculator.Operation.Symbol(operation);
        return op.calculate(a, b);
    }

    // 결과 저장
    public void saveResultList(int result) {
        resultList.add(result);
    }

    // 결과 배열로 출력(getter)
    public List<Integer> getResultList() {
        return resultList;
    }

    // (setter)
    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
    }

    // 먼저 저장된 데이터 삭제
    public void removeResultList(int result) {
        if (resultList.size() > 5) {
            resultList.remove(0);
        }
    }
}
