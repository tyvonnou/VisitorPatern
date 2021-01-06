package variable;

import visitor.Visitor;

public class Variable {
	
	String name;
	
	public Variable(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	public void accept(Visitor visitor) {
		    visitor.visitVariable(this);
	}
}