/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

import java.util.ArrayList;

/**
 *
 * @author Mark Miller
 */
public class OPTABLE {
    ArrayList<OperationCode> optable = new ArrayList<>();
    public OPTABLE(){
        optable.add(new OperationCode("ADD","18"));
        optable.add(new OperationCode("ADDF","58"));
        optable.add(new OperationCode("ADDR","90"));
        optable.add(new OperationCode("AND","40"));
        optable.add(new OperationCode("CLEAR","B4"));
        optable.add(new OperationCode("COMP","28"));
        optable.add(new OperationCode("COMPF","88"));
        optable.add(new OperationCode("COMPR","A0"));
        optable.add(new OperationCode("DIV","24"));
        optable.add(new OperationCode("DIVF","64"));
        optable.add(new OperationCode("DIVR","9C"));
        optable.add(new OperationCode("FIX","C4"));
        optable.add(new OperationCode("FLOAT","C0"));
        optable.add(new OperationCode("HIO","F4"));
        optable.add(new OperationCode("J","3C"));
        optable.add(new OperationCode("JEQ","30"));
        optable.add(new OperationCode("JGT","34"));
        optable.add(new OperationCode("JLT","38"));
        optable.add(new OperationCode("JSUB","48"));
        optable.add(new OperationCode("LDA","00"));
        optable.add(new OperationCode("LDB","68"));
        optable.add(new OperationCode("LDCH","50"));
        optable.add(new OperationCode("LDF","70"));
        optable.add(new OperationCode("LDL","08"));
        optable.add(new OperationCode("LDS","6C"));
        optable.add(new OperationCode("LDT","74"));
        optable.add(new OperationCode("LDX","04"));
        optable.add(new OperationCode("LPS","D0"));
        optable.add(new OperationCode("MUL","20"));
        optable.add(new OperationCode("MULF","60"));
        optable.add(new OperationCode("MULR","98"));
        optable.add(new OperationCode("NORM","C8"));
        optable.add(new OperationCode("OR","44"));
        optable.add(new OperationCode("RD","D8"));
        optable.add(new OperationCode("RMO","AC"));
        optable.add(new OperationCode("RSUB","4C"));
        optable.add(new OperationCode("SHIFTL","A4"));
        optable.add(new OperationCode("SHIFTR","A8"));
        optable.add(new OperationCode("SIO","F0"));
        optable.add(new OperationCode("SSK","EC"));
        optable.add(new OperationCode("STA","0C"));
        optable.add(new OperationCode("STB","78"));
        optable.add(new OperationCode("STCH","54"));
        optable.add(new OperationCode("STF","80"));
        optable.add(new OperationCode("STI","D4"));
        optable.add(new OperationCode("STL","14"));
        optable.add(new OperationCode("STS","7C"));
        optable.add(new OperationCode("STSW","E8"));
        optable.add(new OperationCode("STT","84"));
        optable.add(new OperationCode("STX","10"));
        optable.add(new OperationCode("SUB","1C"));
        optable.add(new OperationCode("SUBF","1C"));
        optable.add(new OperationCode("SUBR","94"));
        optable.add(new OperationCode("SVC","B0"));
        optable.add(new OperationCode("TD","E0"));
        optable.add(new OperationCode("TIO","F8"));
        optable.add(new OperationCode("TIX","2C"));
        optable.add(new OperationCode("TIXR","B8"));
        optable.add(new OperationCode("WD","DC"));
    }
    public String getOPCode(String mnemonic){
        for(int i = 0; i < optable.size();i++){
            if(mnemonic.equals(optable.get(i).Mnemonic)){
                return optable.get(i).MachineCode;
            }
        }
        return "Invalid Mnemonic";
    }
    
   public boolean isOPCode(String mnemonic){
       for(int i = 0; i < optable.size();i++){
            if(mnemonic.equals(optable.get(i).Mnemonic)){
                return true;
            }
        }
       return false;
   }
}
