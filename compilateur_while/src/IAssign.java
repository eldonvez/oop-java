import edu.polytechnique.xvm.asm.opcodes.*;
import java.util.Optional;

@SuppressWarnings("unused")
public final class IAssign extends AbstractInstruction {
  public final Optional<String> lvalue; // (optional) left-value
  public AbstractExpr           rvalue; // right-value (expression)

  public IAssign(Optional<String> lvalue, AbstractExpr rvalue) {
    this.lvalue = lvalue;
    this.rvalue = rvalue;
  }

  @Override
  public void codegen(CodeGen cg) {
	  if( this.lvalue.isPresent()){
		  
		 String name = lvalue.get();
		 Integer offset = cg.getOffset(name);
		 if(offset != null) { 
			 rvalue.codegen(cg);
			 cg.pushInstruction(new WFR(offset));
					}
		 else {
			 System.out.println("pas d'offset déclaré");
		 }
	  }
	  else {
		  rvalue.codegen(cg);
	  }
	   
   
	  
  }
}
