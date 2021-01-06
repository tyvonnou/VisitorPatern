package exp.impl;

import exp.Expr;

abstract public class BinExpr implements Expr {
	
	// Valeur a gauche de l'operation
	protected Expr opg;
	// Valeur a droite de l'operation
	protected Expr opd;
	
	/**
	 * Constructeur qui renseigne les valeurs de l'operation
	 * @param opg
	 * @param opd
	 */
	public BinExpr(Expr opg, Expr opd) {
		this.opg = opg;
		this.opd = opd;
	}

	/**
	 * Renvoie la valeur gauche de l'operation
	 * @return opg
	 */
	public Expr getOpg() {
		return opg;
	}

	/**
	 * Renvoie la valeur droite de l'operation
	 * @return
	 */
	public Expr getOpd() {
		return opd;
	}
	
	/**
	 * Affichage
	 * @param operation
	 * @return
	 */
	protected String toString(final String operation) {	
		return "(" + this.opg.toString() + " " + operation + " " + this.opd.toString() + ")";
	}

	
}
