package br.senac.tads3.pi03b.projetoautomata.utils;

public class Funcoes {
    public String tiraNaoNumero(String para){
        String retorno = "", aux;
        
        for (int i = 0; i < para.length(); i++) {
            aux = String.valueOf(para.charAt(i));
            
            if ("1234567890".contains(aux)) {
                retorno += aux;
            }else if(aux.equals(",")){
                retorno += ".";
            }
        }
        
        return retorno;
    }
}