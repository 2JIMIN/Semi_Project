package com.kh.quarantine.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.quarantine.model.service.QuarantineService;
import com.kh.quarantine.model.vo.Quarantine;

/**
 * Servlet implementation class AjaxQuarantineTapsController
 */
@WebServlet("/tapList.qu")
public class AjaxQuarantineTapsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxQuarantineTapsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clickContinent = request.getParameter("input");
//		System.out.println(clickContinent);
		
		ArrayList<Quarantine> listTap = new QuarantineService().quarantineInfoList(clickContinent);	
//		System.out.println(listTap);

		request.setAttribute("listTap", listTap);
		
		response.setContentType("application/json;charset=UTF-8");
		
		new Gson().toJson(listTap, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
