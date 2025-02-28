package com.example.calculator.lv2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 속성
    private List<Integer> resultList;


    // 생성자
    public Calculator() {
        this.resultList = new ArrayList<>();
    }


    // 기능
    public int calculate(int a, int b, char operation) {
        switch (operation) {
            case '+':
                // 원래 코드
//                System.out.println("결과는" + " " + (a + b));
//                break;
                // 수정 코드
//                int result1 = a + b;
//                break;
                // 위 식을 return을 사용해서 한줄로 하기.
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("0이 아닌 숫자를 입력하세요.");
                } else {
                    return a / b;
                }
            default:
                // 메서드가 int형 이기 때문에 default 블록에서도 int값이 반환되어야 한다.
                // 하지만, 현재는 메시지만 반환하고 있다.
//                System.out.println("잘못된 부호입니다. 정확히 입력하세요!");
                // 따라서 throw 를 사용한다.
                // 반환값을 직접 제공하지 않지만 이를 메서드 종료로 처리.
                throw new IllegalArgumentException("잘못 입력했습니다. : " + operation);
        }
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
