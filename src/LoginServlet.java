import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    final String USERNAME="HeEl";
    final String PASSWORD="123456789";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals(USERNAME) && password.equals(PASSWORD)){
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("username", request.getParameter("username"));
            if (request.getParameter("rememberCheckbox") != null){
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(10);
                response.addCookie(cookie);
            }
            response.sendRedirect("./profile");
        } else{
            response.getWriter().println("ERROR");
            doGet(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        if(httpSession != null) {
            response.sendRedirect("./profile");
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<form action=\"./login\" method=\"POST\">");
        printWriter.println("<p>Please, enter your username and password:</p>");
        printWriter.println("<label for=\"username\">Username</label>");
        printWriter.println("<input type=\"text\" id=\"username\" name=\"username\" placeholder=\"3-12 symbols\" minlength=3 maxlength=12>");
        printWriter.println("<br>");
        printWriter.println("<label for=\"password\">Password</label>");
        printWriter.println("<input type=\"password\" id=\"password\" name=\"password\" placeholder=\"8-100 symbols\" minlength=8 maxlength=100>");
        printWriter.println("<br>");
        printWriter.println("<input type=\"checkbox\" name=\"rememberCheckbox\" value=\"remember\"/>");
        printWriter.println("<label>Remember for 10 seconds</label>");
        printWriter.println("<br>");
        printWriter.println("<input type=\"submit\" value=\"Log In\">");
        printWriter.println("</form>");
        printWriter.println("</html>");
    }
}
