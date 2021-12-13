/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lucas
 */
public class ValidacaoEmail {
    
    public boolean validaEmail(String email){
        String regex = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,3}$";
        Pattern p = Pattern.compile(regex); 
        Matcher mat = p.matcher(email); 
        if(!mat.find()){ 		    
            return false;
        }
        return true;
    }
    
}
