import java.util.*;

import edu.polytechnique.mjava.ast.TProcDef;
import edu.polytechnique.xvm.asm.*;
import edu.polytechnique.xvm.asm.interfaces.*;

public final class CodeGen {
  private Vector<AsmInstruction> instructions;
  private Map<String, Integer>   labels;
  private Map<String, Integer>   offsets;
  private TProcDef<AbstractExpr,AbstractInstruction> proc;

  public CodeGen() {
    this.instructions = new Vector<AsmInstruction>();
    this.labels = new HashMap<String, Integer>();
    this.offsets = new HashMap<String, Integer>();
  }

  @SuppressWarnings("unused")
  private static int labelc = 0;

  public static String generateLabel() {
	// should work so long as we don't generate more than 999 labels. 
	  String label = String.format("l%d%d%d", labelc/100, labelc/10, labelc%10);
	  labelc ++;
	  return(label);
    // Generate a fresh label using `labelc'.
    // For example, lXXX where XXX is the value of labelc.
    // Two generated labels should never be equal.
    // A label must start with a lowercase letter.
    //throw new UnsupportedOperationException();
  }

  public void pushLabel(String label) {
	  labels.put(label, instructions.size());
   // throw new UnsupportedOperationException(); // FIXME
  }

  public void pushInstruction(AsmInstruction asm) {
	  instructions.add(asm);
	  //throw new UnsupportedOperationException(); // FIXME
  }

  public void pushLocalVariable(String name, int offset) {
    offsets.put(name, offset);
    //throw new UnsupportedOperationException(); // FIXME    
  }
  public int getOffset(String name) {
	  return(offsets.get(name));
  }
  public void clearLocals() {
    this.offsets.clear();
  }
  
  public TProcDef<AbstractExpr, AbstractInstruction>  getProc() {
	  return this.proc;
  }
  
  public void setProc(TProcDef<AbstractExpr, AbstractInstruction> proc) {
	  this.proc = proc;
	  
  }
  @Override
  public String toString() {
    return Printer.programToString(this.instructions, this.labels);
  }
}
