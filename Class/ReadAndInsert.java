/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_automatos.Class;

import atividade_automatos.Class.Nodo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Guize
 */
public class ReadAndInsert {
    
    public static void lerArq(List<Nodo> lst,String caminhoDoArquivo) throws FileNotFoundException
    {
        FileReader f = new FileReader(caminhoDoArquivo);
        Scanner arquivoLido = new Scanner(f);
        
        arquivoLido.useDelimiter("\n");
        
        String linhaLida = arquivoLido.next();
        while (arquivoLido.hasNext())
        {
            linhaLida = arquivoLido.next();
            
            String vetor[] = linhaLida.split(";");
            
            Nodo nodo = new Nodo();
            
            nodo.setOrigem(Integer.parseInt(vetor[0]));
            nodo.setLetra(vetor[1].charAt(0));
            nodo.setDestino(Integer.parseInt(vetor[2]));
            
            if(vetor[3].charAt(0) == '1')
                nodo.seteFinal(true);
            else
                nodo.seteFinal(false);
            
            if(vetor[4].equals("EMPTY"))
                nodo.setPilhaSai(null);
            else
                nodo.setPilhaSai(vetor[4]);

            if(vetor[5].equals("EMPTY"))
                nodo.setPilhaEntra(null);
            else
                nodo.setPilhaEntra(vetor[5]);

            lst.add(nodo);
        }

        arquivoLido.close();
    }
}
