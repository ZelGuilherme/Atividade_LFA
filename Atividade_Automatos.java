package atividade_automatos;


import atividade_automatos.Class.Input;
import atividade_automatos.Class.ReadAndInsert;
import atividade_automatos.Class.Nodo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Atividade_Automatos {
    
    static class Global {
        int charQuant;
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        /* --------------- OLD ---------------
        aut1 = L = {w | w possua aa ou bb como sub palavra}
        aut2 = L = {w | entre dois a's de w, há quantidade par de b's }
        aut3 = L = {w | w tenha aa ou aba, como subpalavra } 
        aut4 = L = {w | entre dois b's de w, há quantidade impar de a's } 
        
        aut5 eu que fiz aqui pq não consegui montar o que foi colocado
        no site. L = {w | depois de B sempre tem A.
        Se não for vazio, começa e termina com C.
        */


        /*
         * PILHA:
         * noInicial;letra;noDestino;eFinal;pilhaSai;pilhaEntra;
         */
        
        String caminhoDoArquivo = "C:\\Users\\Guize\\Code\\Automatos"
        + "\\Atividade_Automatos\\src\\atividade_automatos\\aut2.txt";
        
        List<Nodo> lst = new ArrayList<>();
        Input input = new Input();
	    ReadAndInsert lerArq = new ReadAndInsert();
        Global global = new Global();
        String EMPTY = "EMPTY";


        Nodo auxNodo = new Nodo();
        auxNodo.setPilhaEntra(EMPTY);
        auxNodo.setPilhaSai(EMPTY);

        
        FileReader arqLido = new FileReader(caminhoDoArquivo);
        Scanner leitor = new Scanner(arqLido);
        
        global.charQuant = Integer.parseInt(leitor.nextLine());

        leitor.close();
		
		try {
            arqLido.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        lerArq.lerArq(lst, caminhoDoArquivo);
        
        String palavra = input.Input();
        
        int posAtualLista = 0;
        
        Stack<String> pilha = new Stack();



        for(int i = 0; i < palavra.length(); i++)
        {
            char letra = palavra.charAt(i);
            char[] letrasPalavra = new char[palavra.length()];
            
            int[] origem = new int[global.charQuant];
            int[] destino = new int[global.charQuant];
            for(int j = 0; j < global.charQuant; j++)
            {
                origem[j] = lst.get(posAtualLista + j).getOrigem();
                destino[j] = lst.get(posAtualLista + j).getDestino();
            }
            for(int k = 0; k < global.charQuant; k++)
            {
                if(origem[k] == posAtualLista/global.charQuant && letra == lst.get(posAtualLista + k).getLetra())
                {
                    letrasPalavra[i] = palavra.charAt(i);
                    System.out.println("\n\n********************************");
                    System.out.println("Palavra lida: " + Arrays.toString(letrasPalavra));

                    System.out.println("\nNodo origem: " + (posAtualLista + k)/global.charQuant);

                    System.out.println("Letra lida: " + lst.get(posAtualLista + k).getLetra());

                    if(lst.get(posAtualLista + k).getPilhaSai() != null
                        && pilha.lastElement().equals(lst.get(posAtualLista + k).getPilhaSai()))
                    {
                        System.out.println("\nPilha antes de remover: " + Arrays.toString(pilha.toArray()));

                        for(int p = 0; p < lst.get(posAtualLista + k).getPilhaSai().length(); p++)
                            pilha.pop();

                        System.out.println("Pilha depois de remover: " + Arrays.toString(pilha.toArray()) + "\n");
                    }
                    
                    if(lst.get(posAtualLista + k).getPilhaEntra() != null)
                    {
                        System.out.println("\nPilha antes de inserir: " + Arrays.toString(pilha.toArray()));

                        for(int w = 0; w < lst.get(posAtualLista + k).getPilhaEntra().length(); w++)
                        {
                            String newInsert = String.valueOf(lst.get(posAtualLista + k).getPilhaEntra().charAt(w));
                            pilha.push(newInsert);
                        }

                        System.out.print("Pilha depois de inserir: " + Arrays.toString(pilha.toArray()) + "\n");
                    }

                    System.out.print("********************************");

                    posAtualLista = destino[k]*global.charQuant;
                }
            }
        }
        
        System.out.print("\nTerminou no nodo: " + posAtualLista/global.charQuant + "\n\n");
        
        System.out.println("\nPILHA NO FINAL:" + Arrays.toString(pilha.toArray()) + "\n");

        if(lst.get(posAtualLista).geteFinal()
            && pilha.empty())
        {
            System.out.print("\nA palavra foi aceita\n\n\n");
        }
        else
        {
            System.out.print("\nA palavra nao foi aceita\n\n\n");
        }
    }
}
