package com.example.project.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;
        
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        
        //then
        assertThat(dto.getName()).isEqualTo(name);      // assertThat(): 테스트 검증 라이브러리의 검증 메소드 / 검증하고 싶은 대상을 메소드 인자로 받음 / 메소드 체이닝 지원
        assertThat(dto.getAmount()).isEqualTo(amount);  //isEqualTo(): assertj의 동등 비교 메소드 / assertThat에 잇는 값과 비교해 같을 때만 성공
    }
}
