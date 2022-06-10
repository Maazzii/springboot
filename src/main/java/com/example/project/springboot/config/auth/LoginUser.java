package com.example.project.springboot.config.auth;

// 세션 값을 가져오는 부분이 반복되어 불필요하므로 어노테이션 기반으로 개선

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)      // 어노테이션 생성될 수 있는 위치 지정 / PARAMETER: 메소드의 파라미터로 선언된 객체에서 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}
