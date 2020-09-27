# Method 
```java
public class MethodDemo1 {
    public static void numbering()
    {
        int i =0;
        while (i<10)
        {
            System.out.println(i);
            i++;
        }
    }
    public static void main(String[] args)
    {
        numbering();
    }
}

```

### 입출력
##### 1. 입력
```java
public class MethodDemo1 {
    public static void numbering(int num1,int num2)
    {
        int i = num1;
        while (i < num2)
        {
            System.out.println(i);
            i++;
        }
    }
    public static void main(String[] args)
    {
        numbering(2,5);
    }
}

```
##### 2. 출력
```java
public class MethodDemo1 {
    public static String numbering(int num1,int num2)
    {
        int i = num1;
        String output = " "
        while (i < num2)
        {
           output += i;
            i++;
        }
        return output; 
    }
    public static void main(String[] args)
    {
        String result = numbering(2,7);
        System.out.println(result);
    }
}


```
