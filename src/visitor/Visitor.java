package visitor;
import exp.impl.DivExpr;
import exp.impl.IntExpr;
import exp.impl.MultExpr;
import exp.impl.PlusExpr;
import exp.impl.SubExpr;
import statement.impl.Assignment;
import statement.impl.PrintLn;
import variable.Variable;
import variable.VariableUse;

public class Visitor {
	public void visitIntExpr(IntExpr intExpr) {
		throw new UnsupportedOperationException();
	}

	public void visitMultExpr(MultExpr multExpr) {
		throw new UnsupportedOperationException();
	}

	public void visitPlusExpr(PlusExpr plusExpr) {
		throw new UnsupportedOperationException();
	}
	
	public void visitSubExpr(SubExpr subExpr) {
		throw new UnsupportedOperationException();
	}

	public void visitDivExpr(DivExpr divExpr) {
		throw new UnsupportedOperationException();
	}
	
	public void visitVariableUse(VariableUse variableUse) {
		throw new UnsupportedOperationException();
	}
	
	public void visitAssignment(Assignment assignment) {
		throw new UnsupportedOperationException();
	}
	
	public void visitPrintLn(PrintLn printLn) {
		throw new UnsupportedOperationException();
	}
	
	public void visitVariable(Variable variable) {
		throw new UnsupportedOperationException();
	}
}
