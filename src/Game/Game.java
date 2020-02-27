
package Game;
import java.awt.Component;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 *
 * @author wilson Afonso Vieira Nunes
 */
public class Game {
    
    public static void main(String[] args) {
        ArvoreNo<String> root;
        pergunta();
        root = iniciarArvore();
        do {
            jogar(root);
        }while (query ("Jogar Novamente?"));
        
        JOptionPane.showMessageDialog(null, "Jogo Finalizado");
        root.print(1);
        System.exit(0);
    }
    
    private static void pergunta() {
        Component frame = null;
        JOptionPane.showMessageDialog(null, "Pense em um Animal?");
    }

    private static ArvoreNo<String> iniciarArvore() {
        ArvoreNo<String> root;
        ArvoreNo<String> filho;
        
        final String pergunta = "O animal vive na Água?";
        final String perguntaEsq = "O animal é maior que um Coelho?";
        final String perguntaDir = "O Animal é um Roedor?";
        final String  animal1 = "Tubarão";
        final String animal2 = "Tartaruga";
        final String animal3 = "Rato";
        final String animal4 = "Gato";
        
        root = new ArvoreNo<>(pergunta, null, null);
        
        filho = new ArvoreNo<>(perguntaEsq, null, null);

        filho.setEsquerdo(new ArvoreNo<>(animal1, null, null));
        filho.setDireito(new ArvoreNo<>(animal2, null, null));
        root.setEsquerdo(filho);
        
        filho = new ArvoreNo<>(perguntaDir, null, null);
        filho.setEsquerdo(new ArvoreNo<>(animal3, null, null));
        filho.setDireito(new ArvoreNo<>(animal4,null,null));
        root.setDireito(filho);
        return root;
        
    }

    private static void jogar(ArvoreNo<String> root) {
        while (!root.folha()){
            if (query(root.getData())){
                root = root.getEsquerdo();
            } else {
                root = root.getDireito();
            }
        }
        
        if (!query("O Animal é " + root.getData()+ ". Certo?")){
            learn(root);
        } else {
            JOptionPane.showMessageDialog(null, "Acertei!!");
        }
    }

    private static boolean query(String jogarNovamente) {
        String resposta = null;
        Component frame = null;
        int n = JOptionPane.showConfirmDialog(frame,jogarNovamente,jogarNovamente,JOptionPane.YES_NO_OPTION);
        if(n == 0){
            resposta= "Sim";  
        }
        if(n == 1 ){
            resposta = "Não";
        }
        return resposta.startsWith("Sim");
    }

    private static void learn(ArvoreNo<String> root) {
        String animalAdivinhado;
        String animalCorreto;
        String novaPergunta;
        
        
        animalAdivinhado = root.getData();
        JFrame frame = new JFrame("Jogo");
        
        
        
        String nome = JOptionPane.showInputDialog(null, "Não sei! Qual o Animal?");
        if ( nome == null || nome.equals("")){
            System.exit(0);
        }
        
        animalCorreto = nome;
        
        String pergunta = JOptionPane.showInputDialog(null, "O que a(o) " + animalCorreto + " faz que a(o) " 
                + animalAdivinhado + " Não faz?");
        if(pergunta == null || pergunta.equals("")){
            System.exit(0);
        }
        novaPergunta = pergunta;
        
        root.setData(novaPergunta);
        if(query("A(O) "+ animalCorreto +" "+ novaPergunta)){
            root.setEsquerdo(new ArvoreNo<>(animalCorreto, null,null));
            root.setDireito(new ArvoreNo<>(animalAdivinhado, null,null));
        }else{
            root.setEsquerdo(new ArvoreNo<>(animalAdivinhado, null,null));
            root.setDireito(new ArvoreNo<>(animalCorreto, null,null));
        }
    }
        
    
}
