package statement;

import visitor.Visitor;

public interface Statement {
	void accept(Visitor visitor);
}

