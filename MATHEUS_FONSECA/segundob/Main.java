package MATHEUS_FONSECA.segundob;
import javax.swing.JOptionPane;

public class Main {
    
    
    public static void atv1() {
        JOptionPane.showMessageDialog(null, "Olá, Mundo!");
    }
    
    
    public static void atv2() {
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");
        if (nome != null) {
            JOptionPane.showMessageDialog(null, "Bem-vindo, " + nome + "!");
        }
    }
    
   
    public static void atv3() {
        int resposta = JOptionPane.showConfirmDialog(null, "Você deseja continuar?");
        if (resposta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu continuar!");
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Você escolheu não continuar.");
        } else if (resposta == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Você cancelou a operação.");
        }
    }
    
    public static void atv4() {
        String[] options = {"Opção 1", "Opção 2", "Opção 3"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Opções",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        if (escolha >= 0 && escolha < options.length) {
            JOptionPane.showMessageDialog(null, "Você escolheu " + options[escolha]);
        }
    }
    
    static class MinhaExcecao extends Exception {
        public MinhaExcecao(String mensagem) {
            super(mensagem);
            JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    public static void atv6() {
        String[] operacoes = {"Soma", "Subtração", "Multiplicação", "Divisão"};
        int operacao = JOptionPane.showOptionDialog(null, "Escolha uma operação:", "Calculadora",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, operacoes, operacoes[0]);
        
        if (operacao >= 0 && operacao < operacoes.length) {
            try {
                String strNum1 = JOptionPane.showInputDialog("Digite o primeiro número:");
                String strNum2 = JOptionPane.showInputDialog("Digite o segundo número:");
                
                if (strNum1 == null || strNum2 == null) {
                    throw new MinhaExcecao("Operação cancelada pelo usuário.");
                }
                
                double num1 = Double.parseDouble(strNum1);
                double num2 = Double.parseDouble(strNum2);
                double resultado = 0;

                switch (operacao) {
                    case 0: 
                        resultado = num1 + num2;
                        break;
                    case 1: 
                        resultado = num1 - num2;
                        break;
                    case 2: 
                        resultado = num1 * num2;
                        break;
                    case 3:
                        if (num2 == 0) {
                            throw new MinhaExcecao("Divisão por zero não é permitida.");
                        }
                        resultado = num1 / num2;
                        break;
                }
                
                JOptionPane.showMessageDialog(null, "O resultado é: " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (NumberFormatException e) {
                try {
                    throw new MinhaExcecao("Entrada inválida. Por favor, insira números válidos.");
                } catch (MinhaExcecao minhaExcecao) {
             
                }
            } catch (MinhaExcecao minhaExcecao) {
                
            }
        }
    }
    
    public static void main(String[] args) {
       
      
    }
}
