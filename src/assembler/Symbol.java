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
public class Symbol {
    String Symbol, Address, Length;
    
    public Symbol(String Symbol, String Address){
        this.Symbol = Symbol;
        this.Address = Address;
        //this.Length = Length;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String Symbol) {
        this.Symbol = Symbol;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String printSymbol(){
        String str = Integer.toHexString(Integer.parseInt(Address));
        return Symbol + ", " + str;
    }

//    public String getLength() {
//        return Length;
//    }
//
//    public void setLength(String Length) {
//        this.Length = Length;
//    }
    
}
