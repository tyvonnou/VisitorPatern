package exp.impl;
import exp.Expr;
import visitor.Visitor;

public class PlusExpr extends BinExpr {

	/**
	 * Constructeur
	 * @param opg
	 * @param opd
	 */
	public PlusExpr(Expr opg, Expr opd) {
		super(opg, opd);
	}

	/**
	 * Utilisation du patern visiteur
	 */
	@Override
	public void accept(Visitor v) {
		v.visitPlusExpr(this);
	}
	
	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return super.toString("+");
	}

}
