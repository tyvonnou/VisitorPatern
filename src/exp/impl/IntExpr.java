package exp.impl;
import exp.UnaryExpr;
import visitor.Visitor;

public class IntExpr implements UnaryExpr {
	
	// valeur de l'element
	protected int val;
	
	/**
	 * Constructeur
	 * @param val
	 */
	public IntExpr(Integer val) {
		this.val = val;
	}

	/**
	 * Getteur de la valeur de l'attribut
	 * @return
	 */
	public int getVal() {
		return val;
	}

	/**
	 * Utilisation du partern visiteur
	 */
	@Override
	public void accept(Visitor v) {
		v.visitIntExpr(this);
	}	
	
	/**
	 * Afficahge
	 */
	@Override
	public String toString() {
		return Integer.toString(val);
	}
	
}
