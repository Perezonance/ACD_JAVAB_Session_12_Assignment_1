package controllers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBUtility;

/**
 * Servlet implementation class BookUpdaterController
 */
@WebServlet("/BookUpdate")
public class BookUpdaterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DBUtility db;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdaterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		db = new DBUtility(new File("app.properties"));
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idKey = "book_isbn";
		String titleKey = "book_title";
		String authorKey = "book_author";
		String pubKey = "book_publisher";
		String yearKey = "book_publication_year";
		String priceKey = "book_price";
		String table = "`online_books`.`books`";
		
		String title = request.getParameter("bTitle");
		String author = request.getParameter("bAuthor");
		String publisher = request.getParameter("bPub");
		String year = request.getParameter("bYear");
		String price = request.getParameter("bPrice");
		String id = request.getParameter("bID");
		String message = "";
		
		String radiusType = request.getParameter("type");
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		if(id != null && !id.isEmpty()) {
			hm.put(idKey, id);
			
		}
		hm.put(titleKey, title);
		hm.put(authorKey, author);
		hm.put(pubKey, publisher);
		hm.put(yearKey, year);
		hm.put(priceKey, price);
		
		if(radiusType.equals("add")) {
			DBUtility.saveData(table, hm);
		}else if(radiusType.equals("delete")) {
			DBUtility.deleteData(table, hm, idKey);
		}else if(radiusType.equals("update")) {
			hm.remove(idKey);
			DBUtility.updateRow(table, hm, idKey, id);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/BookShop");
		rd.forward(request, response);
	}

}
