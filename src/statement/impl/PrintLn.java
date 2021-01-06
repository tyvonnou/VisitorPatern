package statement.impl;

import exp.Expr;
import statement.ProcCall;
import visitor.Visitor;

public class PrintLn implements ProcCall {

	public PrintLn(final Expr exp) {
		this.exp = exp;
	}

	@Override
	public void accept(final Visitor visitor) {
		visitor.visitPrintLn(this);
	}

	@Override
	public Expr getExp() {
		return exp;
	}

	protected final Expr exp;


}