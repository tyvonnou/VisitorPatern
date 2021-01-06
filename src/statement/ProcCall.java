package statement;

import exp.Expr;

public interface ProcCall extends Statement {
	Expr getExp();
}