package com.navneet.rx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.codehaus.jackson.map.annotate.JacksonInject;
import org.springframework.beans.factory.annotation.Autowired;

import com.navneet.model.TestDao;

import rx.Observable;

public class HelloServlet extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TestDao testDao=new TestDao();
		Observable<Document> list=testDao.getUsersFromDB();
		System.out.println(list);
		
		PrintWriter writer=resp.getWriter();
		list.map(input ->  {
			String userName=(String)input.get("name");
			return userName;
		}).filter( input ->input.length()>5).
		subscribe(name -> writer.write(name+"\t"));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
