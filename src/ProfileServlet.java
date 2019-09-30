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
        TableManager.tableGet(request, response);
        PrintWriter pw = response.getWriter();
        pw.println("<html>\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <th scope=\"col\"> ID</th>\n" +
                "        <th scope=\"col\"> Name</th>\n" +
                "        <th scope=\"col\"></th>\n" +
                "    </tr>");
        for (Goods good : TableManager.goods) {
            pw.println("<tr>\n" +
                    "        <form action=\"./table\" method=\"post\">\n" +
                    "            <td>\n" +
                    good.getId() +
                    "            </td>\n" +
                    "            <td>\n" +
                    "                <label for=\"" + good.getId() + "\">" + good.getProduct() + "</label>\n" +
                    "            </td>\n" +
                    "            <td>\n" +
                    "                <input type=\"submit\" value=\"Add\" id=\" " + good.getId() + "\" name=\"" + good.getId() + "\"" + ">\n" +
                    "            </td>\n" +
                    "        </form>\n" +
                    "    </tr>");
        }
        pw.println("</table>\n");
        pw.println("<hr>\n" +
                "<table>\n" +
                "    <thead>\n" +
                "    <tr>\n" +
                "        <th colspan=\"4\">Your shopping</th>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <th>ID</th>\n" +
                "        <th>Name</th>\n" +
                "        <th>Quantity</th>\n" +
                "        <th></th>\n"+
                "    </tr>\n" +
                "    </thead>");

        for (Goods good : TableManager.goods) {
            if (good.count > 0) {
                pw.println("<tr>\n" +
                        "       <form action=\"./table\" method=\"post\">\n" +
                        "           <td>"+good.getId()+"</td>\n" +
                        "            <td>\n" +
                        "                <label for=\"" + good.getId() + "\">" + good.getProduct() + "</label>\n" +
                        "            </td>\n" +
                        "           <td>"+good.getCount()+"</td>\n" +
                        "           <td><input type=\"submit\" value=\"Remove\" name=\""+good.getId()+"\"</td>"+
                        "       </form>\n" +
                        "    </tr>");
            }
        }
        pw.println("</table>\n");

        pw.println("</body>\n" +
                "</html>");

        pw.println(HTML);
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ServletManagaer.profile(request,response);

        TableManager.tablePost(request, response);
        doGet(request,response);
    }
}