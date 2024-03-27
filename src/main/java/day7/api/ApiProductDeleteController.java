package day7.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.mybatis.dao.MybatisProductDao;

public class ApiProductDeleteController implements Controller {

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pcode = req.getParameter("pcode");
		//dao 실행해서 삭제하기
		MybatisProductDao dao = new MybatisProductDao();
		int result = dao.delete(pcode);
		
		//응답은 post처리 참고하세요
		String jsonData = "{ \"result\" : "+result+" }";
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().print(jsonData);
	}

}
