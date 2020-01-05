### String

#### substring(처음, 마지막);
ex) 
```java
String name = "minhee";
System.out.println(name.substring(2.5);
```
실행결과 :  nhee  

#### contains()
String 안에 포함 여부  
ex)
```java
String name = "An minhee";
if(a,contains("An")
{
    System.out.println("oh");
}
```  
실행결과 : oh
#### equal - 1
ex)
```java
 String name = "An minhee";
    if(a.equals("An minhee"))
    {
        System.out.println("true");
    }

    else
    {
        System.out.println("false");
    }
```
실행결과 : true  
#### equalsIgnoreCase - 2
대소문자 상관하지 않고 같은지 비교  
ex)
```java
 String name = "An minhee";
    if(a.equalsIgnoreCase("an minhee"))
    {
        System.out.println("true");
    }

    else
    {
        System.out.println("false");
    }
```  
실행결과 : true