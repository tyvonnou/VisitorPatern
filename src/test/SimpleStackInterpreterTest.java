package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
import visitor.SimpleStackInterpreter;

class SimpleStackInterpreterTest {
	
	  private PrintStream standardOut = System.out;
	  private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	  private SimpleStackInterpreter simpleStackInterpreter;
	  private IntExpr opg = new IntExpr(7);
	  private IntExpr opd = new IntExpr(11);
	  	
	  @BeforeEach
	  void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	    this.simpleStackInterpreter = new SimpleStackInterpreter();
	  }

	  @AfterEach
	  public void after() {
	    System.setOut(standardOut);
	  }

	  /**
	   * Test des Integers
	   */
	  @Test
	  void testIntExpr() {
	    // Assignation du stack
	    opg.accept(this.simpleStackInterpreter);
	    // Verification de la valeur
	    assertEquals(7, ((IntExpr) this.simpleStackInterpreter.result()).getVal());
	    // Verification de la taille de la stack
		assertEquals(1, this.simpleStackInterpreter.size());
	  }
	  
	  /**
	   * Test des additions
	   */
	  @Test
	  void testPlusExpr() {
		// Initialisation de l'addition  
		Expr plusExpr = new PlusExpr(opg, opd);
		// Utilisation du visiteur
		plusExpr.accept(this.simpleStackInterpreter);
		// Vérification de l'instance du resultat
		assertTrue(simpleStackInterpreter.result() instanceof IntExpr);
		// Verification de la valeur du resultat
		assertEquals(18, ((IntExpr) this.simpleStackInterpreter.result()).getVal());
		// Verification de la taille de la stack
		assertEquals(1, this.simpleStackInterpreter.size());
	  }
	  
	  /**
	   * Test des soustractions
	   */
	  @Test
	  void testSubExpr() {
			// Initialisation de la soustraction 
			Expr subExpr = new SubExpr(opg, opd);
			// Utilisation du visiteur
			subExpr.accept(this.simpleStackInterpreter);
			// Vérification de l'instance du resultat
			assertTrue(simpleStackInterpreter.result() instanceof IntExpr);
			// Verification de la valeur du resultat
			assertEquals(-4, ((IntExpr) this.simpleStackInterpreter.result()).getVal());
			// Verification de la taille de la stack
			assertEquals(1, this.simpleStackInterpreter.size());
	  }
	  
	  /**
	   * Test des multiplications
	   */
	  @Test
	  void testMultExpr() {
			// Initialisation de la multiplication 
			Expr multExpr = new MultExpr(opg, opd);
			// Utilisation du visiteur
			multExpr.accept(this.simpleStackInterpreter);
			// Vérification de l'instance du resultat
			assertTrue(simpleStackInterpreter.result() instanceof IntExpr);
			// Verification de la valeur du resultat
			assertEquals(77, ((IntExpr) this.simpleStackInterpreter.result()).getVal());
			// Verification de la taille de la stack
			assertEquals(1, this.simpleStackInterpreter.size());
	  }

	  /**
	   * Test des divisions
	   */
	  @Test
	  void testDivExpr() {
			// Initialisation de la division 
			Expr divExpr = new DivExpr(opg, opg);
			// Utilisation du visiteur
			divExpr.accept(this.simpleStackInterpreter);
			// Vérification de l'instance du resultat
			assertTrue(simpleStackInterpreter.result() instanceof IntExpr);
			// Verification de la valeur du resultat
			assertEquals(1, ((IntExpr) this.simpleStackInterpreter.result()).getVal());
			// Verification de la taille de la stack
			assertEquals(1, this.simpleStackInterpreter.size());
	  }
	  
	  /**
	   * Test de l'assignement d'une valeur à une variable.
	   */
	  @Test
	  void testVariableAssignement() {
		  	// Initialisation de la variable
		  	Variable a = new Variable("a");
			// Initialisation de l'assignement		
			Assignment assignment = new Assignment(a, new IntExpr(3));
			// Initialisation de l'expression
			Expr var = new VariableUse(a);
			// Utilisation du visiteur
			assignment.accept(this.simpleStackInterpreter);
			var.accept(this.simpleStackInterpreter);
			// Vérification des valeurs
			assertEquals(3, ((IntExpr) this.simpleStackInterpreter.result()).getVal());
			assertEquals(1, simpleStackInterpreter.size());
	  }


	  
	  /**
	   * Test d'expressions multiples
	   */
	  @Test
	  void testMultipleExpr() {
		// Initialisation du calcul -> 7 + 11 * (7 - 11) 
	    Expr plusExpr = new PlusExpr(opg, new MultExpr(opd, new SubExpr(opg, opd)));
	    // Utilisation du visiteur
	    plusExpr.accept(this.simpleStackInterpreter);
		// Vérification de l'instance du resultat
		assertTrue(simpleStackInterpreter.result() instanceof IntExpr);
	    // Verification du resultat attendu, soit -37
	    assertEquals(-37, ((IntExpr) this.simpleStackInterpreter.result()).getVal());
	  }

	  /**
	   * Test d'affichage.
	   */
	  @Test
	  void printLn() {
		// Initialisation de l'expression et de l'affichage
	    Expr plusExpr = new PlusExpr(opg,opd);
	    PrintLn printLn = new PrintLn(plusExpr);
	    // Utilisation du visiteur
	    plusExpr.accept(this.simpleStackInterpreter);
	    printLn.accept(this.simpleStackInterpreter);
	    // Vérification de la valeur
	    assertEquals("18", outputStreamCaptor.toString().trim());
	  }

	

}
