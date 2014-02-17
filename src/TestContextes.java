

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import org.apache.catalina.connector.Request;

/**
 * Servlet implementation class TestContextes
 */
public class TestContextes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int compteurAppli = 0;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = null;;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<html>");
		out.println("<body>");

		HttpSession session = request.getSession(false);
		ServletConfig config = this.getServletConfig();
		ServletContext application = config.getServletContext();



		synchronized (this) {

			if(session == null){
				// on crée une session
				session=request.getSession();
				compteurAppli++;
				application.setAttribute("Nombre de sessions", compteurAppli);
				donnees.setCompteurSession(compteurAppli);
				donnees.setNbrequette(1);
				//				session.setAttribute("id", compteurAppli);
				donnees.setId(compteurAppli);

				session.setAttribute(session.getId(),1);


			}
			else{

				donnees.setNbrequette(donnees.getNbrequette()+1);
				///out.println("Requetes" + donnees.getNbrequette());
				session.setAttribute(session.getId(),donnees.getNbrequette());

			}

		}





		out.println("<head>");
		out.println("<title>Test de contextes</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(" le nombre de sessions depuis le début est " + application.getAttribute("Nombre de sessions") + "<br />");
		out.println("Votre session est: " + donnees.getId());
		out.println(" <br /> le nombre de requettes de votre session  est " + session.getAttribute(session.getId()));
		out.println("<br /> (Request context) Count = 1");


		out.println("</body>");
		out.println("</html>");





	}





	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
