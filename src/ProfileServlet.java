import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends javax.servlet.http.HttpServlet {
    final String HTML = "<html>\n" +
        "<form action=\"./logout\" method=\"GET\"\n" +
        "<p>This is your profile</p>\n" +
        "<br>\n" +
        "<input name=\"logout\" type=\"submit\" value=\"Log out\"/>\n" +
        "</form>\n" +
        "</html>\n";

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession httpSession;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("username")) {
                httpSession = request.getSession(true);
                httpSession.setAttribute("name", cookie.getValue());
            }
        }

        httpSession = request.getSession(false);
        if (httpSession == null) {
            response.sendRedirect("./login");
        }

        Object username = httpSession.getAttribute("name");
        if (username == null) {
            httpSession.invalidate();
            response.sendRedirect("./login");
            return;
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.println(HTML);
    }
}