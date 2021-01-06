package exp.impl;
import exp.Expr;
import visitor.Visitor;

public class SubExpr extends BinExpr {

	/**
	 * Constructeur
	 * @param opg
	 * @param opd
	 */
	public SubExpr(Expr opg, Expr opd) {
		super(opg, opd);
	}

	/**
	 * Utilisation du patern visiteur
	 */
	@Override
	public void accept(Visitor v) {
		v.visitSubExpr(this);
	}
	
	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return super.toString("-");
	}

}
