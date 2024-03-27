package day7.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ApiProductPostController implements Controller {

   @Override
   public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      //사용자가 보낸 데이터는 json 문자열. 이 데이터를 읽어오기 위해 입력스트림이 필요.
      InputStream inputStream = request.getInputStream();      //http 전송방식의 입력스트림 생성. 요청 객체로 만들어짐.
      //입출력의 속도 향상을 위해 버퍼를 사용함.
      BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
      
      StringBuffer sb = new StringBuffer();
      String line = null;
      
      while ((line = br.readLine()) != null) {
         sb.append(line);
         log.info("line : {} ",line);
      }
      
      //json 문자열을 자바 객체로 변환
      ObjectMapper objMapper = new ObjectMapper();
      ProductDto dto = objMapper.readValue(sb.toString(), ProductDto.class);
      
      log.info("변환된 dto : {}",dto);
      
      //dao insert
      int result =0;
      try {
         MybatisProductDao dao = new MybatisProductDao();
         result = dao.Insert(dto);
      } catch (Exception e) {
         log.info("dao insert 예외 : {}",e.getMessage());
      }
      //방법2 는 직접 문자열 만드는 대신 Map에 저장해서 변환할 수도 있음
      String jsonData = "{\"result\" : "+result+"}";
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().print(jsonData);
      
      
      

   }

}