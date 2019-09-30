import java.io.IOException;

public class LogoutServlet extends javax.servlet.http.HttpServlet {
    final String HTML = "<p>You are logged out</p>";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ServletManagaer.logOut(request, response);
    }
}
