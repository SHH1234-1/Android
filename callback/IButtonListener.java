package com.example.myrecyclerview.observer;

public interface IButtonListener {
    void clickEvent(String event); //  <--- 메서드 선언부
}

/*인터페이스가 객체 생성을 못하는 이유

  void clickEvent(String event); //  <--- 메서드 선언부

	메서드 내용
}

객체를 생성하기 위해서는 메서드 선언부와 안의 메서드 내용이 전부다 있을 경우만 객체 생성이 가능하지만
인터페이스는 추상메서드 메서드 선언부만 가능하고 메서드 내용을 입력할 수 없으므로 객체 생성이 불가능
*/