package com.example.calculator.lv2;

import java.util.*;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        double a = 0;
        double b = 0;
        char operation = '+';

        while (true) {
            // 숫자가 아닌 다른 값이 입력되면 처음으로 돌아간다.
            try {
                // 첫번째 숫자 입력
                System.out.print("첫번째 숫자를 입력하세요 : ");
                a = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 숫자를 입력하세요.");
                scanner.nextLine(); // 버퍼 비우기
                continue;
            }

            // 사칙연산 부호 입력
            while (true) {
                try {
                    System.out.print("사칙연산 부호(+, -, *, /)를 입력하세요 : ");
                    operation = scanner.next().charAt(0);
                    if (operation == '+' || operation == '-' || operation == '*' || operation == '/') {
                        break;
                    } else {
                        throw new IllegalArgumentException("부호(+, -, *, /)를 입력하세요.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                try {
                    // 두 번째 숫자 입력
                    System.out.print("두번째 숫자를 입력하세요 : ");
                    b = scanner.nextDouble();
                    if (operation == '/' && b == 0) {
                        throw new ArithmeticException("0이 아닌 다른 숫자를 입력하세요.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("잘못 입력하셨습니다. 숫자를 입력하세요.");
                    scanner.nextLine(); // 무한루프 방지 버퍼 비우기
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            }

            // 결과 출력
            Operation operator = Operation.Symbol(operation);
            double result = operator.calculate(a, b);
            System.out.println("결과는 : " + result);

            // 결과를 배열에 저장
            arithmeticCalculator.saveResultList(result);

            // 배열 불러오기
            System.out.println("모든 결과 : " + arithmeticCalculator.getResultList());

            // 먼저 들어온 데이터 삭제 기능 호출
            arithmeticCalculator.removeResultList();

            // 버퍼 비우기
            scanner.nextLine();

            //이후 계산 여부 확인
            while (true) {
                System.out.println("더 계산하시겠습니까? (yes/exit)");
                String answer = scanner.nextLine();

                if (answer.equals("yes")) {
                    break;
                } else if (answer.equals("exit")) {
                    System.out.println("계산기를 종료합니다.");
                    return;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }
}
