package day4.mybatis.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
// Value Object : 데이터 형식으로서 정의되는 클래스
//			ㄴ private 필드, 값 초기화 커스텀생성자, getter, hashcode와 equals 재정의.
//			ㄴ 객체 생성시 값을 초기화 한 후 변경할 수 없으며, 필드값이 같으면 값으로 처리되는 객체.

@Getter
@ToString
@AllArgsConstructor		
@NoArgsConstructor		// jackson 라이브러리의 매핑에 필요합니다. json을 자바객체로 변환할 때.
						// tbl_custom 테이블의 컬럼과 1:1 대응되는 변수로 정의.

public class CustomerDto {
	  private String customId;
	  private String custom_id;
	    private String name;
	    private String email;
	    private int age;
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	    private Date reg_date;
}
