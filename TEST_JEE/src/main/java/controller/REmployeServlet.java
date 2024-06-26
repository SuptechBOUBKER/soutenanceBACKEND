package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;


import entities.REmploye;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.REmployeService;

@WebServlet("/employe")
public class REmployeServlet extends HttpServlet {
	REmployeService remployeService;
	@Override
	public void init() throws ServletException {
		remployeService=new REmployeService();
			}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		List<REmploye> remployes= this.remployeService.getAllREmployes();
		ObjectMapper mapper=new ObjectMapper();
		String jsonREmploye=mapper.writeValueAsString(remployes);
		resp.getWriter().write(jsonREmploye);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		String jsonREmploye="";
		String line;
		while((line=req.getReader().readLine()) != null) {
			jsonREmploye+=line.trim();
		}
		ObjectMapper mapper=new ObjectMapper();
		REmploye remploye=mapper.readValue(jsonREmploye, REmploye.class);
		REmploye empls=this.remployeService.addREmploye(remploye);
		if (empls!=null) {		
		PrintWriter response=resp.getWriter();
		response.write(jsonREmploye);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
        String jsonREmploye="";
		String line;
		while((line=req.getReader().readLine()) != null) {
			jsonREmploye+=line.trim();
		}
		System.out.println(jsonREmploye);
		ObjectMapper mapper=new ObjectMapper();
		REmploye remploye=mapper.readValue(jsonREmploye, REmploye.class);
		remployeService.addREmploye(remploye);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
