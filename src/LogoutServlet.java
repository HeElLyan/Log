import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null){
            httpSession.invalidate();
            response.getWriter().println("<p>You are logged out</p>");
        } else {
            response.sendRedirect("./login");
        }
    }
}
