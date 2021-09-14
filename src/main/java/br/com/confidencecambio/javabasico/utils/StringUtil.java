package br.com.confidencecambio.javabasico.utils;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {

    public static String removerEspacos(String str){
        str = trimTrailingWhitespace(str);
        str = trimLeadingWhitespace(str);
        return str;
    }

    public static String getPrimeiroNome(String str){
        return str.split(" ")[0];
    }

    public static String getUltimoNome(String str){
        String[] nomes = str.split(" ");
        StringBuilder ultimoNome = new StringBuilder();
        for (int i = 0; i < nomes.length ; i++){
            if (i == 0){
                continue;
            }
            ultimoNome.append(" ").append(nomes[i]);
        }
        return ultimoNome.toString();
    }

    public static String converterMaiusculas(String str){
        return str.toUpperCase();
    }

    public static String abreviaNome(String str){
        String[] nomes = str.split(" ");
        StringBuilder nomeAbreviado = new StringBuilder();
        for (int i = 0; i < nomes.length ; i++){
            if (i == 0){
                nomeAbreviado.append(nomes[i]).append(" ");
                continue;
            }
            if (i == nomes.length -1){
                nomeAbreviado.append(" ").append(nomes[i]);
                continue;
            }
            if (isEmpty(nomes[i])){
                continue;
            }
            nomeAbreviado.append(" ").append(nomes[i].charAt(0)).append(".");

        }
        return nomeAbreviado.toString();
    }
}
