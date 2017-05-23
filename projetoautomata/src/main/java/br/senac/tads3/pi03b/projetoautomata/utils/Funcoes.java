package br.senac.tads3.pi03b.projetoautomata.utils;

public class Funcoes {
    public String tiraNaoNumero(String para){
        String retorno = "";
        String decimal = "";
        String aux;
        
        // se possui os dois, necessário tratar qual é o da casa decimal
        if (para.contains(",") && para.contains(".")) {
            // se está cheio destes símbolos, então considera que não é um valor com casas decimais
            if (ocorrencias(para, ",") > 1 && ocorrencias(para, ".") > 1) {
                decimal = "";
            }else if (para.indexOf(",") > para.indexOf(".")) {
                decimal = ",";
            }else{
                decimal = ".";
            }
        }else{
            // se possui apenas um deles, o que tiver, é considerado decimal
            if (para.contains(",")) {
                decimal = ",";
            }else{
                decimal = ".";
            }
        }
        
        for (int i = 0; i < para.length(); i++) {
            aux = String.valueOf(para.charAt(i));
            
            if ("1234567890".contains(aux)) {
                retorno += aux;
            }else if(aux.equals(decimal) && !decimal.equals("")){
                retorno += "."; // decimal no banco de dados sempre será '.'
            }
        }
        
        return retorno;
    }
    
    public int ocorrencias(String sequencia, String procurar){
        int retorno = 0;
        
        for (int i = 0; i < sequencia.length(); i++) {
            if (i + procurar.length() >= sequencia.length()) {
                break;
            }
            
            if (sequencia.substring(i, procurar.length() + i).equals(procurar)) {
                retorno++;
            }
        }
        
        return retorno;
    }
}