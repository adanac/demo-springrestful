package com.adanac.demo.springrestful;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Scope("prototype")
@Controller
@RequestMapping("/products")
public class TestController {

	/**
	 * 测试方法,HelloWord
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("name", "helloWord");
		return "products/list";
	}

	@RequestMapping(value = "/info/{proId}", method = RequestMethod.GET)
	public String getProductInfo(@PathVariable String proId, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("name", proId);
		return "products/list";
	}

	@RequestMapping(value = "/info/{pid}/{pname}", method = RequestMethod.GET)
	public String getProductInfo(Product pro, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("name", pro.getPid() + "___" + pro.getPname());
		return "products/list";
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public String insertProduct(Product pro, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("name", pro.getPid() + "___" + pro.getPname());
		return "products/list";
	}

	@RequestMapping(value = "/info", method = RequestMethod.PUT)
	public ModelAndView updateProduct(@RequestBody Product pro, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("pid", pro.getPid());
		ModelAndView mav = new ModelAndView("products/list", map1);
		return mav;
	}
}