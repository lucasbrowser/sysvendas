/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucas.sysvendas.report;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author lucas
 */
public class Relatorio {
    
    public void gerarRelatorio(List lista, Map<String, Object> parametros, String relatorioJasper) {
        
        try {
            JRDataSource jrds = new JRBeanCollectionDataSource(lista);
            JasperPrint print = JasperFillManager.fillReport(relatorioJasper, parametros, jrds);
            JasperViewer.viewReport(print, false);     
        } catch (HeadlessException | JRException e) {
            e.printStackTrace();
        }
        
    }
    
     public void gerarRelatorioComPdf(List lista, Map<String, Object> parametros, String relatorioJasper, String relatorioPdf) {
        
        try {
            JRDataSource jrds = new JRBeanCollectionDataSource(lista);
            JasperPrint print = JasperFillManager.fillReport(relatorioJasper, parametros, jrds);
            JasperViewer.viewReport(print, false);     
            JasperExportManager.exportReportToPdfFile(print, relatorioPdf);
            File file = new File(relatorioPdf);
            try {
                Desktop.getDesktop().open(file);
            }catch (IOException e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();
        } catch (HeadlessException | JRException e) {
            e.printStackTrace();
        }
        
    }

    
}
