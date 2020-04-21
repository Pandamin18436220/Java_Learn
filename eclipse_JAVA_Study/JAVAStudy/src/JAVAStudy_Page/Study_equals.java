package JAVAStudy_Page;
/**
 * 
 * @author Pandamin
 * ==表示的是对象的地址或者基本类型的数值相同
 * equals表示对象的内容是否相同
 */
class User1{
	int id;
	String name;
	String pwd;
	public User1(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User1 other = (User1) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}
}
public class Study_equals {
	public static void main(String[] args){
		Object obj;
		String str;
		User1 u1=new User1(123,"panda","456");
		User1 u2=new User1(123,"panda","456");
		System.out.println(u1.equals(u2));
		String str1=new String("sxt");
		String str2=new String("sxt");
		System.out.println(str1.equals(str2));
	}
}
