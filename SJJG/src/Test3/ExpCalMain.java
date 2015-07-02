package Test3;

public class ExpCalMain {
	public static void main(String[] args){
		ExpCal ec = new ExpCal();
		ec.getInfix("3*(4+2)/2-5");
		ec.infixToSuffix();
		System.out.println(ec.getInfix()+"  转换为后缀表达式为:  "+ec.getSuffix());
		System.out.println(ec.getInfix()+"  计算结果为:   "+ec.Calculate());
	}
}
