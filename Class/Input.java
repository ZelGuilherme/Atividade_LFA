/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_automatos.Class;

import java.util.Scanner;

/**
 *
 * @author Guize
 */
public class Input {
     public String Input()
    {
        Scanner leitor = new Scanner(System.in);
        System.out.print("\nInsira a palavra a ser testada:\n\n");
        
        String palavra = leitor.nextLine();
        return palavra;
    }
}
