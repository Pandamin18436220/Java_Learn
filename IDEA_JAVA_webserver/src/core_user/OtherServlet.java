package core_user;


import Server_study_core.Request;
import Server_study_core.Response;
import Server_study_core.Servlet;

public class OtherServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("其他页面");
    }
}
