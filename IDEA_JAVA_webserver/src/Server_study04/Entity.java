package Server_study04;

/**
 * <servlet>
 *         <servlet-name>login</servlet-name>
 *         <servlet-class>com.shsxt.LoginServlet</servlet-class>
 *     </servlet>
 *     <servlet>
 *         <servlet-name>reg</servlet-name>
 *         <servlet-class>com.shsxt.RegisterServlet</servlet-class>
 *     </servlet>
 */
public class Entity {
    private String name;
    private String ciz;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiz() {
        return ciz;
    }

    public void setCiz(String ciz) {
        this.ciz = ciz;
    }
}
