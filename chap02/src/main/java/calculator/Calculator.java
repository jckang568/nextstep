package calculator;

/*
    2.1 main()메서드를 활용한 테스트의 문제점
   소스코드를 구현한 후 정상적으로 동작하는지 확인하는 일반적인 방법은 main() 메서드를 활용해 우리가 의도한 결과 값이 정상적으로
   출력되는지를 콘솔을 통해 확인하는 것이 일반적이다.
   계산기 코드는 실제로 서비스를 담당하는 프로덕션 코드(production code)와 이 프로덕션 코드가 정상적으로 동작하는지 확인하기
   위한 목적과 프로덕션 코드가 정상적으로 동작하는지 확인하는 테스트 목적으로 나뉜다.
   아래 코드의 첫 번째 문제점은 프로덕션 코드와 테스트 코드(main메서드)가 같은 클래스에 위치하고 있다는 것이다.
   테스트 코드의 경우 테스트 단계에서만 필요하기 때문에 굳이 서비스하는 시점에 같이 배포할 필요가 없다.
   이 문제를 해결하기 위한 첫 번째 단계로 프로덕션 코드(calculator.Calculator 클래스)와 테스트 코드(CalculatorTest)를 분리할 수 있다.
 */
public class Calculator {
    public int add(int i, int j) {
        return i + j;
    }

    public int subtract(int i, int j) {
        return i - j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }

    public int divide(int i, int j) {
        return i / j;
    }

    /* 아래의 메인 메서드를 CalculatorTest클래스로 분리한다. */
    /*
    public static void main(String[] args) {
        calculator.Calculator cal = new calculator.Calculator();
        System.out.println(cal.add(3, 4));
        System.out.println(cal.subtract(5, 4));
        System.out.println(cal.multiply(2, 6));
        System.out.println(cal.divide(8, 4));
    }
     */
}
