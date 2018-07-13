
public class Calculator {

  public static int add(int numOne, int numTwo) {
    return numOne + numTwo;
  }

  public static int findGreatest(int[] arr) {
    int greatest = arr[0];
    for(int i = 1; i<arr.length; i++) {
      if(arr[i] > greatest)
        greatest = arr[i];
    }

    return greatest;
  }

}
