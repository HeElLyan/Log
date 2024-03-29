import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    final String USERNAME = "HeEl";
    final String PASSWORD = "123456789";

    final String HTML = "<html>\n" +
            "<form action=\"./login\" method=\"POST\"\n>" +
            "<p>Please, enter your username and password:</p>\n" +
            "<label for=\"username\">Username</label>\n" +
            "<input type=\"text\" id=\"username\" name=\"username\" placeholder=\"3-12 symbols\" minlength=3 maxlength=12>\n" +
            "<br>\n" +
            "<label for=\"password\">Password</label>\n" +
            "<input type=\"password\" id=\"password\" name=\"password\" placeholder=\"8-100 symbols\" minlength=8 maxlength=100>\n" +
            "<br>\n" +
            "<input type=\"checkbox\" name=\"rememberCheckbox\" value=\"remember\"/>\n" +
            "<label>Remember for 10 seconds</label>" +
            "<br>" +
            "<input type=\"submit\" value=\"Log In\">\n" +
            "</form>\n" +
            "</html>";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       ServletManagaer.logInPost(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ServletManagaer.logInGet(request, response);

        PrintWriter printWriter = response.getWriter();
        printWriter.println(HTML);
    }
}
