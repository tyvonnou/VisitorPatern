package exp.impl;
import exp.Expr;
import visitor.Visitor;

public class MultExpr extends BinExpr {

	/**
	 * Constructeur
	 * @param opg
	 * @param opd
	 */
	public MultExpr(Expr opg, Expr opd) {
		super(opg, opd);
	}

	/**
	 * Utilisation du patern visiteur
	 */
	@Override
	public void accept(Visitor v) {
		v.visitMultExpr(this);
	}

	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return super.toString("*");
	}
}
