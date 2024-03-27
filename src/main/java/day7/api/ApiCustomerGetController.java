package day7.api;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisCustomerDao;
import day4.mybatis.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ApiCustomerGetController implements Controller {

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		MybatisCustomerDao dao = new MybatisCustomerDao();
		CustomerDto dto = dao.getCustomer(req.getParameter("id"));
		log.info("getCustomer dto : {}", dto);
		
		// CustomerDto 자바 객체를 json 문자열로 변환
		// 1) 아이디 중복검사가 아닌 고객 조회이면 사용하기.
//		ObjectMapper objectMapper = new ObjectMapper();
//		String jsonData = null;
//		jsonData = objectMapper.writeValueAsString(dto);
//		log.info("전송할 json 문자열 : {}", jsonData);
		
		
		int result = 0;
		if(dto != null) result = 1;
		// 2) 아이디 중복검사인 경우에는 json으로 있다 또는 없다에 대한 값으로 전달하기.
		String jsonData = "{ \"result\" : "+result+"}";
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().print(jsonData);
		

	}

}
