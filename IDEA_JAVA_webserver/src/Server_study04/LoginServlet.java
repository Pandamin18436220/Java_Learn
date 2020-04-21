package Server_study04;

public class LoginServlet implements Servlet{
    @Override
    public void service(Request request, Response response) {
        response.print("<html>");    //通过输出流输出
        response.print("<head>");
        response.print("<title>");
        response.print("第一个servlet");
        response.print("</title>");
        response.print("</head>");
        response.print("<body>");
        response.print("欢迎回来："+request.getParameterValue("uname"));
        response.print("</body>");
        response.print("</html>");
    }
}
