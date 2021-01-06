package statement.impl;

import exp.Expr;
import statement.Statement;
import variable.Variable;
import visitor.Visitor;

public class Assignment implements Statement{
	
	Variable opg;
	Expr opd;
	
	public Assignment(Variable opg, Expr opd) {
		this.opg = opg;
		this.opd = opd;
	}
	
	public Variable getOpg() {
		return opg;
	}
	
	public Expr getOpd() {
		return opd;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visitAssignment(this);
	}
	
	

}
