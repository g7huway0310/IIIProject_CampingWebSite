package Article;

iimport java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	 private static final String CHARSET_CODE = "UTF-8";
	 public void init(ServletConfig config) throws ServletException
	 {
	   super.init(config);
	 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		    request.setCharacterEncoding(CHARSET_CODE);
		    response.setContentType(CONTENT_TYPE);

		    // To prevent caching 
		   response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
		   response.setHeader("Pragma","no-cache"); // HTTP 1.0
		   response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server

		    
		   if (request.getParameter("submit")!=null)
		     gotoSubmitProcess(request, response);
		   else if (request.getParameter("confirm")!=null)
		     gotoConfirmProcess(request, response);
		}
		
		
		
		
		public void gotoSubmitProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		  {
			String Title;
			String Text;
			String Memberid;

		   
			Title = request.getParameter("Title").trim();
			Text = request.getParameter("Text").trim();
			Memberid = request.getParameter("Memberid").trim();

		    
			ArticleBean rel_Article =  new ArticleBean(Title, Text, Memberid);
		    request.getSession(true).setAttribute("rel_Article",rel_Article);
		    request.getRequestDispatcher("/@@@@@@@@.jsp").forward(request,response);
		  }
		
		
		
		
		public void gotoConfirmProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		  {

		    DataSource ds = null;
		    InitialContext ctxt = null;
		    Connection conn = null;
		    
		    try {
		      ctxt = new InitialContext();
		      ds = ( DataSource ) ctxt.lookup("java:comp/env/jdbc/xe");
		     //ds = ( DataSource ) ctxt.lookup("jdbc/OracleXE");
		      //�VDataSource�nConnection
		      conn = ds.getConnection();

		      //�إ�Database Access Object,�t�dTable��Access
		      ArticleDAO articleDao = new ArticleDAO(conn);
		      ArticleBean commentData = (ArticleBean)request.getSession(true).getAttribute("reg_student");
		      if (ArticleBean.insertArticle(ArticleBean))
		        {
		          System.out.println("Get some SQL commands done!");
		          request.getSession(true).invalidate();
		          request.getRequestDispatcher("/Done.jsp").forward(request,response);
		        }
		    } catch (NamingException ne) {
		      System.out.println("Naming Service Lookup Exception");  
		    } catch (SQLException e) {
		      System.out.println("Database Connection Error"); 
		    } finally {
		      try {
		        if (conn != null) conn.close();
		      } catch (Exception e) {
		        System.out.println("Connection Pool Error!");
		      }
		    }
		           
		  }

	}
