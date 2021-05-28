package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.User;
import helpers.UserController;

public class UserRouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserController userController = new UserController();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		
		switch (action) {
        case "/add-user-form":
            showNewForm(request, response);
            break;
        case "/add-user":
            addUser(request, response);
            break;
        case "/delete-user":
            deleteUser(request, response);
            break;
        case "/update-user-form":
            showEditForm(request, response);
            break;
        case "/update-user":
            updateUser(request, response);
            break;
        case "/list-all-users":
            listUsers(request, response);
            break;
		}
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserForm.jsp");
        dispatcher.forward(request, response);
    }
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
 
        User newUser = new User(name, email, country);
        userController.addOne(newUser);
        response.sendRedirect("/Odev6");
    }
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        userController.deleteOne(id);
        response.sendRedirect("/Odev6");
    }
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userController.getOne(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserForm.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
 
        User updatedUser = new User(id, name, email, country);
        userController.updateOne(updatedUser);
        response.sendRedirect("/Odev6");
    }
	
	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userController.getAll();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
        dispatcher.forward(request, response);
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
