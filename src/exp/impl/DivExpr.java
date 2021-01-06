package exp.impl;
import exp.Expr;
import visitor.Visitor;

public class DivExpr extends BinExpr {
	
	/**
	 * Constructeur qui renseigne les valeurs de l'operation
	 * @param opg
	 * @param opd
	 */
	public DivExpr(Expr opg, Expr opd) {
		super(opg, opd);
	}

	/**
	 * Utilisation du patern visiteur
	 */
	@Override
	public void accept(Visitor v) {
		v.visitDivExpr(this);
	}
	
	/**
	 * Affichage
	 */
	@Override
	public String toString() {
		return super.toString("/");
	}

}
