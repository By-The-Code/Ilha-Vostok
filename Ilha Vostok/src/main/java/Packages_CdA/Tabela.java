package Packages_CdA;

import javax.swing.JFrame;
import javax.swing.JTable;

public class Tabela {
	
	public void geraTabelaDeProfissoes() {
	
		String[] colunas = {"PROFISSÃO / STATUS", "MÉDICO", "SOLDADO", "PROFESSOR"};
	    Object[][] statusQtd = {
	
	            {"PROFISSÃO / STATUS", "MÉDICO", "SOLDADO", "PROFESSOR"},
	
	            {"VIDA",            	"+5", 		"+2", 		"+3"},
	
	            {"ESTAMINA",        	"+0", 		"+5", 		"+3"},
	
	            {"FORÇA",           	"+0", 		"+5", 		"+0"},
	
	            {"RESISTÊNCIA",    	 	"+5", 		"+0", 		"+0"},
	
	            {"INTELIGÊNCIA",    	"+2", 		"+0", 		"+6"},
	    };
	
	    final JFrame janela = new JFrame();
	    final JTable tabelaDeClasses = new JTable(statusQtd, colunas);
	
	    janela.add(tabelaDeClasses);
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    janela.setSize(450, 150);
	    janela.setLocationRelativeTo(null);
	    janela.setVisible(true);
	}
}