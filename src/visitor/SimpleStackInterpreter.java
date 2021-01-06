package visitor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import exp.Expr;
import exp.impl.DivExpr;
import exp.impl.IntExpr;
import exp.impl.MultExpr;
import exp.impl.PlusExpr;
import exp.impl.SubExpr;
import statement.impl.Assignment;
import statement.impl.PrintLn;
import variable.Variable;
import variable.VariableUse;

public class SimpleStackInterpreter extends Visitor {
	
	private Deque<IntExpr> stk;
	private Map<Variable, IntExpr> variables;
	
	public SimpleStackInterpreter () {
		this.stk = new ArrayDeque<>();
		this.variables = new HashMap<>();
	}
	
	public void visitIntExpr(IntExpr intExpr) {
		stk.push(intExpr);
	}

	public void visitMultExpr(MultExpr multExpr) {
		multExpr.getOpg().accept(this);
		multExpr.getOpd().accept(this);
		stk.push(new IntExpr(stk.pop().getVal() * stk.pop().getVal()));
	}
	
	public void visitDivExpr(DivExpr divExpr) {
		Expr eg = divExpr.getOpg();
		Expr ed = divExpr.getOpd();
		eg.accept(this);
		ed.accept(this);
		IntExpr ied = (IntExpr) stk.pop();
		IntExpr ieg = (IntExpr) stk.pop();
		stk.push(new IntExpr(ieg.getVal() / ied.getVal()));
	}

	public void visitPlusExpr(PlusExpr plusExpr) {
		Expr eg = plusExpr.getOpg();
		Expr ed = plusExpr.getOpd();
		eg.accept(this);
		ed.accept(this);
		IntExpr ied = (IntExpr) stk.pop();
		IntExpr ieg = (IntExpr) stk.pop();
		stk.push(new IntExpr(ieg.getVal() + ied.getVal()));
	}
	
	public void visitSubExpr(SubExpr subExpr) {
		Expr eg = subExpr.getOpg();
		Expr ed = subExpr.getOpd();
		eg.accept(this);
		ed.accept(this);
		IntExpr ied = (IntExpr) stk.pop();
		IntExpr ieg = (IntExpr) stk.pop();
		stk.push(new IntExpr(ieg.getVal() - ied.getVal()));
	}

	@Override
	public void visitVariableUse(final VariableUse var) {
		stk.push(variables.get(var.getVariable()));
	}
	
	@Override
	public void visitAssignment(final Assignment assignment) {
		assignment.getOpd().accept(this);
		variables.put(assignment.getOpg(), stk.pop());
	}
	
	@Override
	public void visitPrintLn(final PrintLn printLn) {
		Expr exp = printLn.getExp();
		exp.accept(this);
	    IntExpr expression = (IntExpr) this.stk.pop();
	    System.out.println(expression.getVal());
	}
	
	public Expr result() {
		return stk.peek();
	}
	
	public int size() {
		return stk.size();
	}

}
