#### just() 함수

- 인자로 넣은 데이터를 차례로 발행하려고 Observable 생성 
- 실제 데이터 발행은 subscribe() 함수 호출시 시작 
- 인자는 최대 10개까지 넣을 수 있으며 타입은 동일해야한다.

~~~java
public void emit() {
        Observable.just(1,2,3,4,5,6).subscribe(System.out::println);
    }

    public static void main(String[] args) {
        just just = new just();
        just.emit();
    }
~~~

