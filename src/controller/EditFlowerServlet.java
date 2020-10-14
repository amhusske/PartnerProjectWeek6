package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Flower;

/**
 * Servlet implementation class EditFlowerServlet
 */
@WebServlet("/editFlowerServlet")
public class EditFlowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFlowerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FlowerHelper fh = new FlowerHelper();
		
		String flowerName = request.getParameter("flowerName");
		String colors = request.getParameter("colors");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Flower flowerToUpdate = fh.searchForFlowerById(tempId);
		flowerToUpdate.setColors(colors);
		flowerToUpdate.setFlowerName(flowerName);
				
		fh.updateFlower(flowerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllFlowersServlet").forward(request, response);
	}
}
