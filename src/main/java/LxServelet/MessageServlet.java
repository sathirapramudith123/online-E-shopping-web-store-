package LxServelet;

import controllers.MessageController;
import LxModel.Message;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    private MessageController controller = new MessageController();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        
        if ("search".equals(action)) {
            String email = request.getParameter("email");
            List<Message> messages = controller.searchMessagesByEmail(email);
            request.setAttribute("messages", messages);
            request.getRequestDispatcher("/messages.jsp").forward(request, response);
        } 
        if ("list".equals(action)) {
            List<Message> messages = controller.getAllMessages();
            request.setAttribute("messages", messages);
            request.getRequestDispatcher("/messages.jsp").forward(request, response);
        } 
        
        else if("delete".equals(action)) {
        	int id  = Integer.parseInt(request.getParameter("id"));
        	controller.deleteMessage(id);
        	List<Message> messages = controller.getAllMessages();
            request.setAttribute("messages", messages);
            request.getRequestDispatcher("/messages.jsp").forward(request, response);
        }
        else if ("show".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Message message = controller.getMessage(id);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String messageText = request.getParameter("message");
            int userId = 0;
           // int userId = Integer.parseInt(request.getParameter("userId"));
            Message message = new Message(0, name, email, messageText, userId);
            if (controller.addMessage(message)) {
                response.sendRedirect("message?action=list");
            } else {
                response.getWriter().println("Error adding message");
            }
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String messageText = request.getParameter("message");
            int userId = 0;
            Message message = new Message(id, name, email, messageText, userId);
            if (controller.updateMessage(message)) {
                response.sendRedirect("message?action=list");
            } else {
                response.getWriter().println("Error updating message");
            }
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (controller.deleteMessage(id)) {
                response.sendRedirect("message?action=list");
            } else {
                response.getWriter().println("Error deleting message");
            }
        }
    }
    
 

}
