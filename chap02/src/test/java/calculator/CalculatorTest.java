package calculator;

/*
    테스트를 담당하는 별도의 클래스를 추가했지만 main()메서드 하나에서 프로덕션 코드의 여러 메서드를 동시에 테스트하고 있다.
    이는 프로덕션 코드의 복잡도가 증가하면 증가할수록, main() 메서으듸 복잡도도 증가하고, 결과적으로 main() 메서드를
    유지하는 데 부담이 된다. 이 같은 문제를 해결하기 위해 다음과 같이 테스트 코드를 각 메서드별로 분리할 수도 있다.
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        /*
        System.out.println(cal.add(3, 4));
        System.out.println(cal.subtract(5, 4));
        System.out.println(cal.multiply(2, 6));
        System.out.println(cal.divide(8, 4));
         */
        add(cal);
        subtract(cal);
        multiply(cal);
        divide(cal);
    }
    /*
        하지만 이 또한 최종적인 해결책이 될 수 없다. 그 이유는 개발자가 프로그래밍하는 과정을 살펴보면 된다. 우리는 프로그래밍을 할 때 한 번에
        메서드 하나의 구현에 집중한다. 클래스가 가지고 있는 모든 메서드에 관심이 있는 것이 아니라 현재 내가 구현하고 있는 메서드에만 집중하고 싶다.
        하지만 아래 테스트 코드는 Calculator클래스가 가지고 있는 모든 메서드를 테스트할 수 밖에 없다. 그렇다고 테스트하는 메서드만 남기고 다른
        메서드를 주석처리하는 것 또한 불합리한 작업이다.
        main() 메서드를 활용한 위 테스트가 안고 있는 다른 문제점은 테스트 결과를 매번 콘솔에 출력되는 값을 통해 수동으로 확인해야 한다는 것이다.
        아래와 같이 로직이 간단한 경우네는 결과 값을 쉽게 예측할 수 있다. 하지만 로직의 복잡도가 높은 경우, 구현을 완료한 후 한 달이 지난 시점이라고
        생각해 보자. 이때 프로덕션 코드의 복잡한 로직을 머릿속으로 계산해 결과 값이 정상적으로 출력되는지 일일이 확인해야 하는 번거로움이 있다.
        main() 메서드를 활용한 테스트의 이 같은 문제점을 해결하기 위해 등장한 라이브러리가 JUnit이다. JUnit은 내가 관심을 가지는 메서드에 대한
        테스트만 가능하다. 또한 로직을 실행한 후의 결과 값 확인을 프로그래밍을 통해 자동화하는 것이 가능하다.
     */
    private static void divide(Calculator cal) {
        System.out.println(cal.divide(9,3));
    }

    private static void multiply(Calculator cal) {
        System.out.println(cal.multiply(9,3));
    }

    private static void subtract(Calculator cal) {
        System.out.println(cal.subtract(9,3));
    }

    private static void add(Calculator cal) {
        System.out.println(cal.add(9,3));
    }
}
