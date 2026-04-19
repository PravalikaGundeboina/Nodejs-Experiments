package nodejslab;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // ✅ Safe fetching
            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String salaryStr = request.getParameter("salary");
            String field = request.getParameter("field");

            // ✅ Validation
            if (idStr == null || salaryStr == null ||
                idStr.isEmpty() || salaryStr.isEmpty()) {
                out.println("Error: ID or Salary is missing!");
                return;
            }

            int id = Integer.parseInt(idStr);
            double salary = Double.parseDouble(salaryStr);

            EmployeeDAO dao = new EmployeeDAO();
           dao.updateEmployee(id, name, salary, field);

            out.println("<h3>Employee Updated Successfully!</h3>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3>Error occurred: " + e.getMessage() + "</h3>");
        }
    }
}

