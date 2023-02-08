
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import static java.lang.System.out;

/**
 * Servlet implementation class Serv02
 */
@WebServlet("/serv02")
public class Serv02 extends HttpServlet {

    private static final long serialVersionUID = 101L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv02() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/miestilo.css");
        // dispatcher.forward(request, response);
        // TODO Auto-generated method stub
        String msgHead = "<html> <title>Server de Practica - Arquitectura y Servicios Distribuidos</title>\n "
                + "<head>"
                + "<style>"
                + "body{\n"
                + "min-height: 100vh;"
                + " max-width: 400px;\n"
                + " margin: auto;\n"
                + " color: red;\n"
                + " background-color: antiquewhite;\n"
                + "min-height: 100%;"
                + "    \n"
                + "}"
                + "h1{\n"
                + " background-color: red;\n"
                + "text-align: center;\n"
                + "color:white;\n"
                + "}"
                + "H2{\n"
                + "text-align: center;\n"
                + "}"
                + "form{\n"
                + "text-align: center;\n"
                + "}"
                      + "footer {\n"
                + "color: black; \n"
                + "position: relative;\n"
            /* Altura total del footer en px con valor negativo */
            +"margin-top: -50px;\n"
                + "}"
                + " </style>"
                + "</head> <body><br>";

        String msgTail = "</body> </html>";
        String resp, aux1, aux2;
        float res1, res2 = 0;
        resp = msgHead + "<html>\n"
                + "<H1>Convertidor de monedas</H2><br>"
                + "<center><img src=\"euro-a-dolarr.png\""
                + " width=\"90\"\n"
                + "height=\"80\" >"
                + "<p>"
                + " Escriba el valor que desea convertir:<br>\n"
                + "<form action= \"serv02\" name=\"calc\" method=\"post\">\n"
                + "	<h3>Cantidad: <input type=\"text\" name=\"cantidad\" size=\"20\"> </h3>\n"
                + "	Tipos de conversion:\n"
                + "	<select name=\"conv\" size=\"1\" align=\"left\" >\n"
                + "	<option value=\"1\"> USD --> Euros </option>\n"
                + "	<option value=\"2\"> Euros --> USD </option>\n"
                + "	</select>\n"
                + "<p>"
                + "<input type=\"submit\" name=\"submit\" value=\"Convertir\" >\n"
                + "<input type=\"submit\" name=\"submit\" value=\"Recargar\" >\n</form>\n"
              ;
        if (request.getQueryString() != null) {
            aux1 = request.getParameter("submit");
            if (aux1.equalsIgnoreCase("Convertir")) {
                aux1 = request.getParameter("cantidad");
                aux2 = request.getParameter("conv");

                if (!aux1.equalsIgnoreCase("") && aux1 != null) {
                    res1 = Float.parseFloat(aux1);
                    if (aux2.equalsIgnoreCase("1")) {
                        //HACER LA OPERACION Y GUARDAR RESULTADO EN res2
                        res2 = (float) (res1 / 1.05);
                        resp = resp + "<br> Resultado: " + res1 + " USD equivalen a " + res2 + "Euros.<br>" + msgTail;
                    } else if (aux2.equalsIgnoreCase("2")) {
                        //HACER LA OPERACION Y GUARDAR RESULTADO EN res2
                        res2 = (float) (res1 * 1.05);
                        resp = resp + "<br> Resultado: " + res1 + " Euros equivalen a " + res2 + "USD.<br>" + msgTail;

                    } else {
                        resp = resp + "<br> Error, debe especificar el tipo de conversion." + msgTail;
                    }
                } else {
                    resp = resp + "<br> Error, debe ingresar una cantidad." + msgTail;
                }
            }
        } else {
            resp = resp + msgTail;
        }
        response.getWriter().append(resp);
        //	response.getWriter().append("Served at: ").append(request.getContextPath());
    }
   
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String msgHead = "<html> <title>Server de Practica - Arquitectura y Servicios Distribuidos</title>\n"
                + "<head>"
                + "<style>"
                + "body{\n"
                + "min-height: 100vh;"
                + " max-width: 400px;\n"
                + " margin: auto;\n"
                + " color: red;\n"
                + " background-color: antiquewhite;\n"
                + "min-height: 100%;"
                + "    \n"
                + "}"
                + "h1{\n"
                + " background-color: red;\n"
                + "text-align: center;\n"
                + "color:white;\n"
                + "}"
                + "H2{\n"
                + "text-align: center;\n"
                + "}"
                + "form{\n"
                + "text-align: center;\n"
                + "}"              
                + " </style>"
                + "</head> <body><br>";

        String msgTail = "</body> </html>";
        String resp, aux1, aux2;
        float res1, res2 = 0;

        resp = msgHead + "<H1>Convertidor de monedas.</H2><br> "
                + "<center><img src=\"euro-a-dolarr.png\""
                + " width=\"90\"\n"
                + "height=\"80\" >"
                + "<p>"
                + "Escriba el valor que desea convertir: <br>\n"
                + "<form action= \"serv02\" name=\"calc\" method=\"post\">\n"
                + "	<h3>Cantidad: <input type=\"text\" name=\"cantidad\" size=\"20\"> </h3>\n"
                + "	Tipos de conversion:\n"
                + "	<select name=\"conv\" size=\"1\" align=\"left\" >\n"
                + "	<option selected=\"selected\" value=\"0\">--&gt; Indique el tipo de conversion</option>\n"
                + "	<option value=\"1\"> USD --> Euros </option>\n"
                + "	<option value=\"2\"> Euros --> USD </option>\n"
                + "	</select>\n" + "<p>"
                + "<input type=\"submit\" name=\"submit\" value=\"Convertir\" >\n"
                + "<input type=\"submit\" name=\"submit\" value=\"Recargar\" >\n</form>\n"
                ;
        aux1 = request.getParameter("cantidad");
        aux2 = request.getParameter("conv");
        String aux3 = request.getParameter("submit");
        if (aux3.equals("Convertir")) {
            if (!aux1.equalsIgnoreCase("") && aux1 != null) {
                res1 = Float.parseFloat(aux1);
                if (aux2.equalsIgnoreCase("1")) {
                    //HACER LA OPERACION Y GUARDAR RESULTADO EN res2
                    res2 = (float) (res1 / 1.05);
                    resp = resp + "<br> Resultado: " + res1 + " USD equivalen a " + res2 + " Euros.<br>" + msgTail;
                } else if (aux2.equalsIgnoreCase("2")) {
                    //HACER LA OPERACION Y GUARDAR RESULTADO EN res2
                    res2 = (float) (res1 * 1.05);
                    resp = resp + "<br> Resultado: " + res1 + " Euros equivalen a " + res2 + " USD.<br>" + msgTail;

                } else {
                    resp = resp + "<br> Error, debe especificar el tipo de conversion." + msgTail;
                }
            } else {
                resp = resp + "<br> Error, debe ingresar una cantidad." + msgTail;
            }
        } else {
            resp = resp + msgTail;
        }
        response.getWriter().append(resp);
        
        try {
            out.println("<html>");
            out.println("<h1>Servlet servlet at" + request.getContextPath() + "</h1>");
            
        } finally {
            out.close();
        }
    }
    
}
