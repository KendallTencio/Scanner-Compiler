/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author imarc
 */
public class Report {

    List<TokenReport> token_list = new ArrayList<TokenReport>();
    
    public void analyze(String token, String token_type, String line){
        
        TokenReport existing_token = this.getTokenInfo(token);
        
        if(existing_token == null){
            TokenReport newToken = new TokenReport();
            newToken.setLine(line);
            newToken.setToken(token);
            newToken.setTokenType(token_type);
            this.token_list.add(newToken);
        }
        else{
            existing_token.setLine(line);
        }
       
    }
    
    public TokenReport getTokenInfo(String token){
        for(int i = 0; i < this.token_list.size(); i++){
          
            if(this.token_list.get(i).getToken().equals(token)){
                return this.token_list.get(i);
            }
        }
        return null;
    }
    
    public String generateReport(){
        String report = "";
        for(int i = 0; i < this.token_list.size(); i++){
            TokenReport token = this.token_list.get(i);
            String temp = "";
            temp = "Token: "+token.getToken()+"   Tipo de Token: "+token.getTokenType()+"   Lineas: "+this.processLines(token.getLines())+" \n";
            report = report + temp;
        }
        return report;
    }
    
    public String processLines(Hashtable<String, Integer> lines){
        String result = "";
        Set<String> value = lines.keySet();
        for(String key: value){
            result = result+key+" ("+lines.get(key)+")"+", ";
        }
        return result.substring(0, result.length() - 2);
    }
}
