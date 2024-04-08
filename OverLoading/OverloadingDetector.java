import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class OverloadingDetector {

    public static void main(String[] args) {
        detectOverloadedMethods(MyClass.class);
    }

    public static void detectOverloadedMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        Map<String, Integer> methodCountMap = new HashMap<>();

        for (Method method : methods) {
            String methodName = method.getName();
            methodCountMap.put(methodName, methodCountMap.getOrDefault(methodName, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : methodCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Method '" + entry.getKey() + "' is overloaded.");
            }
        }
    }

}

class MyClass {
    public void myMethod(int a) {
        // some code
    }

    public void myMethod(String s) {
        // some code
    }

    public void myMethod(double d) {
        // some code
    }

    public void myMethod(int a, String s) {
        // some code
    }

    public void myMethod(String s, int a) {
        // some code
    }

    public void myMethod(int a, double d) {
        // some code
    }

    // Daha fazla metot ekleyebilirsiniz.
}
