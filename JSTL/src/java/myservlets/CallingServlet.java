package myservlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import beans.State;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CallingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // forward request and response objects to JSP page
    
        HttpSession session = request.getSession(true);
        
        session.setAttribute("title","ForEach example");
        //session.setAttribute("states",  buildStates());
        session.setAttribute("states",  buildStateList());

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher("/JSP_Test.jsp");
        dispatcher.forward(request, response);
    }
    private State[] buildStates()
    {
        String[] stateNames={"Michigan", "Ohio", "Indiana", "California"};
        int[] statePopulations={8100000, 9100000, 3200000, 21000000}; 
        State[] states = new State[stateNames.length];
        
        for (int i=0; i < states.length; i++)
        {
            states[i] = new State();
            states[i].setName(stateNames[i]);
            states[i].setPopulation(statePopulations[i]);
        }
        
        return states;
    }
    
    private List<State> buildStateList()
    {
        String[] stateNames={"Michigan", "Ohio", "Indiana", "California"};
        int[] statePopulations={8100000, 9100000, 3200000, 21000000}; 
        
        // Note that anything which implements List would also work like Vector or LinkedList
        List<State> states = new ArrayList<State>();
        
        for (int i=0; i < stateNames.length; i++)
        {
            State state = new State();
            state.setName(stateNames[i]);
            state.setPopulation(statePopulations[i]);
            states.add(state);
        }
        
        return states;
    }
}
