package day7.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
@Slf4j

public class ApiProductSearchController implements Controller {

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 json 문자열 읽어오기 (POST 처리 코드)
		req.setCharacterEncoding("UTF-8");
		InputStream inputStream = req.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
		
		StringBuffer sb = new StringBuffer();
		String line = null;
		
		while((line = br.readLine()) != null) {
			sb.append(line);
			log.info("line:()",line);
		}
		//읽어온 json 문자열을 Map (자바)객체로 변환 (dao의 search 메소드 인자가 Map 입니다.)
		ObjectMapper objMapper = new ObjectMapper();
		
		@SuppressWarnings("unchecked")
		Map<String, Object> map = objMapper.readValue(sb.toString(),Map.class);
		log.info("map:{}",map);
		
		MybatisProductDao dao = new MybatisProductDao();
		List<ProductDto> list = dao.search(map);
		
		//(List) 자바 객체를 json 문자열로 변환
		String jsonData = null;
		jsonData = objMapper.writeValueAsString(list);
		log.info("전송할 json 문자열 : {}",jsonData);
		
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(jsonData);
	}

}
