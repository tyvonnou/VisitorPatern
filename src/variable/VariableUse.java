package variable;

import exp.UnaryExpr;
import visitor.Visitor;

public class VariableUse implements UnaryExpr {

	Variable variable;
	
	public VariableUse(Variable variable) {
		this.variable = variable;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visitVariableUse(this);
	}

	public Variable getVariable() {
		return variable;
	}
	
	@Override
	public String toString() {
		return variable.getName();
	}
	
}
