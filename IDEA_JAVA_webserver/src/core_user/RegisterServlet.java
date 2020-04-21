package core_user;


import Server_study_core.Request;
import Server_study_core.Response;
import Server_study_core.Servlet;

public class RegisterServlet implements Servlet {
    @Override
    public void service(Request request, Response response) {
        response.print("注册成功");
        //关注业务逻辑
        String uname = request.getParameterValue("uname");
//        String[] favs = request.getParameterValues("fav");
        response.print("你注册的信息为："+uname);
//        response.print("爱好为："+uname);
    }
}
