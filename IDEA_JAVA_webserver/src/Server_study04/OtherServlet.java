package Server_study04;


public class OtherServlet implements Servlet{
    @Override
    public void service(Request request, Response response) {
        response.print("其他页面");
    }
}
