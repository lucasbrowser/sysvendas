/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.formatter;

import com.towel.bean.Formatter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lucas
 */
public class DataFormatter implements Formatter {
    
    @Override
    public Object format(Object o) {
        Date data = (Date) o;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String string = dateFormat.format(data);

        return string;
    }

    @Override
    public Object parse(Object o) {
        return null;
    }

    @Override
    public String getName() {
        return "data";
    }
    
}
