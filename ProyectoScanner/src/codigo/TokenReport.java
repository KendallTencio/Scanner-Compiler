/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.Hashtable;

/**
 *
 * @author imarc
 */
public class TokenReport {
    String Token = "";
    String TokenType = "";
    Hashtable<String, Integer> Lines = new Hashtable<String, Integer>();

    public TokenReport() {
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getTokenType() {
        return TokenType;
    }

    public void setTokenType(String TokenType) {
        this.TokenType = TokenType;
    }
    
    public Integer getLine(String line){
        if(this.Lines.get(line) == null){
            return 0;
        }
        else{
            return this.Lines.get(line);
        }
    }
    
    public Hashtable getLines(){
        return this.Lines;
    }
    
    public void setLine(String line){
        int qty = this.getLine(line);
        this.Lines.put(line, qty+1);
    }
    
    
}
