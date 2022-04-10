import edu.polytechnique.xvm.asm.interfaces.AsmInstruction;
import edu.polytechnique.xvm.asm.opcodes.*;

@SuppressWarnings("unused")
public final class EBool extends AbstractExpr {
  public final boolean value; // Literal value

  public EBool() {
    this(false);
  }

  public EBool(boolean value) {
    this.value = value;
  }

  @Override
  public void codegen(CodeGen cg) {
	  if(this.value){
		  cg.pushInstruction(new PUSH(1));
	  }
	  else {
		  cg.pushInstruction(new PUSH(0));
	  }
	  
	  //throw new UnsupportedOperationException(); // FIXME
  }
}
