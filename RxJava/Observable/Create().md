#### create() 함수

- 함수 이벤트를 직접 호출해야한다
- 모든 데이터 발행 후 반드시 onComplete 호출해야한다

~~~java
Observable<Integer> observable = 
                Observable.create(emitter -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
                });
        
        observable.subscribe(System.out::println);
~~~

- subscribe() 함수 변형
  1. 메서드 레퍼런스로 축약할 수 있는가
  2. 람다 표현식으로 활용할 수 있는가
  3. 1, 2번 활용 x -> 익명 객체나 멤버 변수로 표현

~~~ java
source.subscribe(System.out::println); //1번

source.subscribe(data -> System.out.println("Result: "+data));  //2번

source.subscribe(new Consumer<Integer>() {  //3번
            @Override
            public void accept(Integer integer) throws Throwable {
                System.out.println("Result: " + integer);
            }
        });
~~~

###### 사용시 주의사항

1. Observable이 dispose가 되었을 때 모든 콜백을 해제해야한다 -> 메모리 누수 방지
2. 구독하는 동안에만 onNext, onComplete 이벤트를 호출해야한다.
3. 에러 발생시 오직 onError 이벤트로 에러 전달
4. back pressure을 직접 처리해야 한다.