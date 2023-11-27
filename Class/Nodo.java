package atividade_automatos.Class;

/**
 *
 * @author 14795836698
 */
public class Nodo {
    int origem;
    int destino;
    char letra;
    boolean eFinal;
    String pilhaSai;
    String pilhaEntra;

    public Nodo(char letra, int origem, int destino, boolean eFinal, String pilhaSai, String pilhaEntra)
    {
        this.origem = origem;
        this.destino = destino;
        this.letra = letra;
        this.eFinal = eFinal;
        this.pilhaSai = pilhaSai;
        this.pilhaEntra = pilhaEntra;
    }
    
    public Nodo()
    {
        this.origem = 999;
        this.destino = 999;
        this.letra = '^';
        this.eFinal = false;
        this.pilhaSai = "SAI_VAZIA";
        this.pilhaEntra = "ENTRA_VAZIA";
    }
    
    public void printInfo()
    {
        System.out.print(this.origem + " | ");
        System.out.print(this.destino + " | ");
        System.out.print(this.letra + " | ");
        System.out.print(this.eFinal + " | ");
        System.out.print(this.pilhaSai + " | ");
        System.out.print(this.pilhaEntra + "\n");
    }

    public char getLetra() {
        return letra;
    }

    public int getDestino() {
        return destino;
    }

    public boolean geteFinal() {
        return eFinal;
    }

    public int getOrigem() {
        return origem;
    }
    
    public String getPilhaSai(){
        return pilhaSai;
    }

    public String getPilhaEntra(){
        return pilhaEntra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public void seteFinal(boolean eFinal) {
        this.eFinal = eFinal;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public void setPilhaSai(String pilhaSai) {
        this.pilhaSai = pilhaSai;
    }

    public void setPilhaEntra(String pilhaEntra) {
        this.pilhaEntra = pilhaEntra;
    }
}
