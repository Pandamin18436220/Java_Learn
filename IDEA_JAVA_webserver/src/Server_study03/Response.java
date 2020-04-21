package Server_study03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
    private BufferedWriter bw;
    private Socket client;
    private StringBuilder headInfo; //协议头包括状态行和请求头和回车
    private StringBuilder content;
    private int len=0; //正文的字节数
    private final String BLANK=" ";
    private final String CRLF="\r\n";

    private Response()
    {
        content=new StringBuilder();
        headInfo=new StringBuilder();
        len=0;
    }
    public Response(Socket client)
    {
        this(); //调用默认构造器
        try {
            bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {

            e.printStackTrace();
            headInfo=null;
        }
    }

    public Response(OutputStream os)
    {
        this();  //调用默认构造器
        bw=new BufferedWriter(new OutputStreamWriter(os));
    }
    public Response print(String info)   //流模式，不断添加内容返回自身
    {
        content.append(info);
        len+=info.getBytes().length;
        return this;
    }
    public Response println(String info)
    {
        content.append(info).append(CRLF);
        len+=(info+CRLF).getBytes().length;  //换行符也占长度
        return this;

    }
    //推送响应信息
    public void pushToBrowser(int code) throws IOException
    {
        if(null==headInfo) {
            code=505;
        }
        createHeadInfo(code);

        bw.append(headInfo);  //bw.append()以追加模式写出数据，.write()刷新原有数据，只有当前数据
        bw.append(content);
        bw.flush();

    }
    //构建头信息
    private void createHeadInfo(int code)  //传不同的code有不同的状态
    {
        //1、响应行:HTTP/1.1 200 OK
        headInfo.append("HTTP/1.1").append(BLANK);
        headInfo.append(code).append(BLANK);
        switch(code)
        {
            case 200:
                headInfo.append("OK").append(CRLF);
                break;
            case 404:
                headInfo.append("NOT FOUND").append(CRLF);
                break;
            case 505:
                headInfo.append("SERVER ERROR").append(CRLF);
                break;
        }
        //2、响应头
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Server:").append("shsxt Server/0.0.1;charset=GBK").append(CRLF);
        headInfo.append("Content-type:text/html").append(CRLF);
        headInfo.append("Content-length:").append(len).append(CRLF);
        headInfo.append(CRLF); //响应头和正文之间有空行

    }
}
