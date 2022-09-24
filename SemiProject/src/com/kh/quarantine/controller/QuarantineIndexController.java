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
 * Servlet implementation class QuarantineIndexController
 */
@WebServlet("/index.qu")
public class QuarantineIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuarantineIndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String clickContinent = "동북아시아";
//		ArrayList<Quarantine> listTap = new QuarantineService().quarantineInfoList(clickContinent);	
//		request.setAttribute("listTap", listTap);
		
		ArrayList<Quarantine> listTap1 = new QuarantineService().quarantineInfoList1();	
		ArrayList<Quarantine> listTap2 = new QuarantineService().quarantineInfoList2();	
		ArrayList<Quarantine> listTap3 = new QuarantineService().quarantineInfoList3();	
		ArrayList<Quarantine> listTap4 = new QuarantineService().quarantineInfoList4();	


		request.setAttribute("listTap1", listTap1);
		request.setAttribute("listTap2", listTap2);
		request.setAttribute("listTap3", listTap3);
		request.setAttribute("listTap4", listTap4);
		
		request.getRequestDispatcher("views/quarantine/user_quarantineIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
