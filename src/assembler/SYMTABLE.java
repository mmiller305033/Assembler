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
public class SYMTABLE {
    ArrayList<Symbol> SymTable = new ArrayList<>();
    public SYMTABLE(){
        
    }
    public void addSymbol(String Symbol, String Address){
        SymTable.add(new Symbol(Symbol,Address));
    }
    
    public Symbol getSymbol(String Symbol){
        for(int i = 0; i < SymTable.size();i++){
            if(Symbol.equals(SymTable.get(i).Symbol)){
                return SymTable.get(i);
            }
        }
        return null;
    }
    
    public void printSYMTABLE(){
        for(int i = 0; i < SymTable.size();i++){
            System.out.println(SymTable.get(i).printSymbol());
        }
    }
}
