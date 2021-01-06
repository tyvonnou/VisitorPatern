package exp;
import visitor.Visitor;

public interface Expr {
	public abstract void accept(Visitor v);
}
