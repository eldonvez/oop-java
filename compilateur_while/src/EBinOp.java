import edu.polytechnique.xvm.asm.opcodes.*;
import edu.polytechnique.mjava.ast.BinOp;

@SuppressWarnings("unused")
public final class EBinOp extends AbstractExpr {
  public final BinOp        op   ;    // operator (enum)
  public final AbstractExpr left ;    // left operand
  public final AbstractExpr right;    // right operand

  public EBinOp(BinOp op, AbstractExpr left, AbstractExpr right) {
    this.op = op;
    this.left = left;
    this.right = right;
  }

  @Override
  public void codegen(CodeGen cg) {
	    switch (this.op) {
	    case ADD:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new ADD());
	    	break;
	    	
	    case MUL:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new MULT());
	    	break;
	    	
	    case DIV:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new DIV());
	    	break;
	    	
	    case SUB:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new SUB());
	    	break;
	    	
	    case AND:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new AND());
	    	break;
	    	
	    case OR:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new OR());
	    	break;
	   
	    case EQ:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new EQ());
	    	break;
	    	
	    case NEQ:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new EQ());
	    	cg.pushInstruction(new NOT());
	    	
	    	
	    case LT:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new LT());
	    	break;
	    	
	    case LE:
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new LT());
	    	left.codegen(cg);
	    	right.codegen(cg);
	    	cg.pushInstruction(new EQ());
	    	cg.pushInstruction(new OR());
	    	break;
	    	
	    case GT:
	    	right.codegen(cg);
	    	left.codegen(cg);
	    	cg.pushInstruction(new LT());
	    	break;
	    	
	    case GE:
	    	right.codegen(cg);
	    	left.codegen(cg);
	    	cg.pushInstruction(new LT());
	    	
	    	right.codegen(cg);
	    	left.codegen(cg);
	    	cg.pushInstruction(new EQ());
	    	
	    	cg.pushInstruction(new OR());
	    	break;
	    }
	    
  }	
	   
	    	
  

}
