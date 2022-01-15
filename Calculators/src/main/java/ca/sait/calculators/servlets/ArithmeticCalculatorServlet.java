package ca.sait.calculators.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/arithmetic"})
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("message", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String number1=request.getParameter("number1");
        String number2=request.getParameter("number2");
        try{
            if(request.getParameter("number1") == null || request.getParameter("number2") == null){
                throw new Exception();
            }
            Double num1 = Double.parseDouble(number1);
            Double num2 = Double.parseDouble(number2);
            String operation = request.getParameter("operation");
            System.out.println(operation);
            if(operation.equals("add")){
                request.setAttribute("message",num1+num2);
            }
            else if(operation.equals("subtract")){
                request.setAttribute("message",num1-num2);
            }
            else if(operation.equals("multiply")){
                request.setAttribute("message",num1*num2);
            }
            else if(operation.equals("divide")){
                request.setAttribute("message",num1/num2);
            }else{
                throw new Exception();
            }
        }catch(Exception e){
                request.setAttribute("message", "Invalid input");
        }
        //I am unsure if this is the best soloution, but this is what I came up with for keeping the form data intact on submit
        request.setAttribute("input1", number1);
        request.setAttribute("input2", number2);
        getServletContext().getRequestDispatcher("/WEB-INF/ArithmeticCalculator.jsp").forward(request,response);
    }

}
