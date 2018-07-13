import static org.junit.Assert.*;
import org.junit.Test;
import src.Calculator;

public class CalculatorTest {

  @Test
  public void evaluatesExpression() {
    int sum = Calculator.add(1, 2);
    assertEquals(3, sum);
  }

  @Test
  public void findsGreatest() {
    int[] arr = {1, 2, 3, 4, 5};
    int greatest = Calculator.findGreatest(arr);
    assertEquals(5, greatest);
  }

}
