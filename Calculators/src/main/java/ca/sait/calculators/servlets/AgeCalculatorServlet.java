package ca.sait.calculators.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculator.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("age") != null){
            try{
                String ageString = request.getParameter("age");
                int age= Integer.parseInt(ageString);
                if(age < 0){
                    throw new Exception();
                }
                int ageNextBirthday=age+1;
                request.setAttribute("message", "You will be "+ageNextBirthday+" after your next birthday!");
            }catch(Exception e){
                request.setAttribute("message", "Invalid input");
            }
        }
       getServletContext().getRequestDispatcher("/WEB-INF/AgeCalculator.jsp").forward(request,response);
    }

}
