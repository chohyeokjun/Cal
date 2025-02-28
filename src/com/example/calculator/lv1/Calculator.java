package com.example.calculator.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                // 첫번째 숫자 입력
                System.out.println("첫번째 숫자를 입력하세요.");
                a = scanner.nextInt();

                // 숫자가 아닌 다른 값이 입력되면 처음으로 돌아간다.
            } catch (InputMismatchException e) {
                System.out.println("잘못 입력하셨습니다. 숫자를 입력하세요.");
                scanner.nextLine(); // 버퍼 비우기
                continue;
            }

            // 사칙연산 부호 초기화
            scanner.nextLine(); // 버퍼 비우기
            char operation = '+';

            // 사칙연산 부호 입력
            while (true) {
                try {
                    System.out.println("사칙연산 부호(+, -, *, /)를 입력하세요.");
                    operation = scanner.next().charAt(0);

                    // 사칙연산 부호가 아닐 시
                    if (operation == ('+') || operation == ('-') || operation == ('*') || operation == ('/')) {
                        break;
                    } else {
                        throw new IllegalArgumentException("부호(+, -, *, /)를 입력하세요.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }


            // 두번째 숫자 입력
            boolean check = true;
            while (check) {
                try {
                    System.out.println("두번째 숫자를 입력하세요.");
                    b = scanner.nextInt();

                    // 사칙연산 수행
                    switch (operation) {
                        case '+':
                            System.out.println("결과는" + " " + (a + b));
                            break;
                        case '-':
                            System.out.println("결과는" + " " + (a - b));
                            break;
                        case '*':
                            System.out.println("결과는" + " " + (a * b));
                            break;
                        case '/':
                            System.out.println("결과는" + " " + (a / b));
                            break;

                        default:
                            // 사실상 필요 없는 부분
                            throw new IllegalArgumentException("올바른 부호를 입력하세요.");
                    }

                    //0으로 나눌 수 없으므로 0이 입력되면 문구가 나오면서 두번째 숫자 입력으로 돌아간다.
                } catch (ArithmeticException e) {
                    System.out.println("0이 아닌 다른 숫자를 입력하세요.");
                    continue;
                    // 숫자가 아닌 다른 값이 입력되면 두 번째 숫자 입력으로 돌아간다.
                } catch (InputMismatchException e) {
                    System.out.println("잘못 입력하셨습니다. 숫자를 입력하세요.");
                    scanner.nextLine();
                    continue;
                }
                check = false;
            }
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

