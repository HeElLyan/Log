import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableManager {
    static List<Goods> goods;

    static void tableGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession(false) == null || request.getSession(false).getAttribute("name") == null) {
            response.sendRedirect("./login");
        }
        if (goods == null) {
            goods = new ArrayList<>();
            goods.add(new Goods("Bread", Goods.current_id++));
            goods.add(new Goods("Milk", Goods.current_id++));
            goods.add(new Goods("Cheese", Goods.current_id++));
            goods.add(new Goods("Butter", Goods.current_id++));
        }
    }

    static void tablePost(HttpServletRequest request, HttpServletResponse response) {
        int i = 0;
        for (Goods good : goods) {
            String var = request.getParameter(Integer.toString(i));

            if (var != null) {

                if (var.equals("Add")) {
                    ++good.count;
                } else --good.count;
                break;
            }
            i++;
        }
    }
}
