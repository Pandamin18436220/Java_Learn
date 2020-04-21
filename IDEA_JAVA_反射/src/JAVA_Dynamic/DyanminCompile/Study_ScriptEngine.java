package JAVA_Dynamic.DyanminCompile;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

/**
 * 脚本引擎介绍
 *  - 使的Java应用程序可以通过一套固定的接口与各种脚本引擎交互，
 *   从而达到Java平台上调用各种脚本语言的目的
 *  - Java脚本API是连通Java平台和脚本语言的桥梁。
 *  - 可以把一些复杂异变的业务逻辑交给脚本语言处理，这又大大提高了开发效率。
 *
 * 获取脚本程序输入，通过脚本引擎运行脚本并返回运行结果，这是最核心的接口
 *  注意是：接口。java可以使用各种不同的实现，从而通过调用js,groovy,python等脚本。
 *  - Js使用了：Rhino
 *  Rhino是一种使用Java语言编写的JavaScript的开源实现，原先由Mozilla开发，现在被集成JDK6.0
 */
public class Study_ScriptEngine {
    public static void main(String[] args) throws Exception{
        //获取脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = (ScriptEngine) sem.getEngineByName("javascript");
        //定义变量
        engine.put("msg","pandamin is man");
        String str = "var user = {name:'pandamin',age:18};" + "println(user.name);";

        //执行脚本
        engine.eval(str);
        engine.eval("msg = 'sxt is a good school';");
        System.out.println(engine.get("msg"));

        //定义函数
        engine.eval("function add(a,b){var sum = a+b;return sum;}");
        //执行脚本中定义的方法
        Invocable jsInvoke = (Invocable) engine;
        Object result1 = jsInvoke.invokeFunction("add",new Object[]{13,20});
        System.out.println(result1);
        //导入其他的java包,使用其他包中的java类
        String jsCode = "importPackage(java.util); var list=Arrays.asList([\"1\",\"2\"])";
        engine.eval(jsCode);

        List<String> list2 =(List<String>)engine.get("list");
        for(String temp:list2){
            System.out.println(temp);
        }
        //执行一个js文件（我们将a.js至于项目的src下）
        URL url = Study_ScriptEngine.class.getClassLoader().getResource("a.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close();

    }
}

