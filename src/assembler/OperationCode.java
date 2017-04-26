/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assembler;

/**
 *
 * @author Mark Miller
 */
public class OperationCode {
    String Mnemonic,MachineCode;

    public OperationCode(String Mnemonic, String MachineCode) {
        this.Mnemonic = Mnemonic;
        this.MachineCode = MachineCode;
    }

    public String getMnemonic() {
        return Mnemonic;
    }

    public void setMnemonic(String Mnemonic) {
        this.Mnemonic = Mnemonic;
    }

    public String getMachineCode() {
        return MachineCode;
    }

    public void setMachineCode(String MachineCode) {
        this.MachineCode = MachineCode;
    }
     

    
}
