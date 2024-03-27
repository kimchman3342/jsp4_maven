package day7.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import day4.mybatis.dao.MybatisProductDao;
import day4.mybatis.dto.CateDto;
import day4.mybatis.dto.ProductDto;

public class ProductsController implements Controller {

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		MybatisProductDao dao = new MybatisProductDao();
		
		List<CateDto> cateList = dao.getCategories();
		req.setAttribute("cateList", cateList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("products.jsp");
		dispatcher.forward(req, resp);

	}

}
