import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServletManagaer {
    final static String USERNAME = "HeEl";
    final static String PASSWORD = "123456789";

    public static void logInPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.doGet(request,response);
        }
    }

    public static void logInGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession httpSession = request.getSession(false);
        if(httpSession != null) {
            response.sendRedirect("./profile");
            return;
        }

    }

    public static void profile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
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
            return;
        }

        Object username = httpSession.getAttribute("name");
        if (username == null) {
            httpSession.invalidate();
            response.sendRedirect("./login");
            return;
        }
    }

    public static void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null){
            httpSession.invalidate();
            LogoutServlet logoutServlet = new LogoutServlet();
            response.getWriter().println(logoutServlet.HTML);
        } else {
            response.sendRedirect("./login");
        }
    }
}
