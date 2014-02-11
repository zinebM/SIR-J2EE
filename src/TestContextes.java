

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestContextes
 */
public class TestContextes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int compteurAppli = 0;
	private ServletConfig config;
	private ServletContext application;
	private HttpSession session;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestContextes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int comptSession =0;
//		if(compteurAppli == 0){
		
		if(application.getAttribute("compteurAppli")==null){
			session = request.getSession(true);
			application.setAttribute("compteurAppli", compteurAppli);	 
		 application.setAttribute("compteurAppli", compteurAppli);
		 session.setAttribute("Numero",compteurAppli);
	
	 
		 }
	}
	
	public int getNbsessionappli(HttpServletRequest request){
		application = config.getServletContext();
		if(application.getAttribute("compteurAppli")==null){
			session = request.getSession(true);
			application.setAttribute("compteurAppli", compteurAppli);
		}
		compteurAppli ++;
		return compteurAppli;
	}
	public int getNumSession(){
		
//		session.setAttribute("numsession", arg1)
		
//		return (Integer)application.getAttribute("compteurAppli");
//		session.
		return 0;
	}
	public int getNbRequete(){
		return 0;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
