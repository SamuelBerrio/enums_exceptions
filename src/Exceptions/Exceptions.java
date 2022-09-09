package Exceptions;

import javax.swing.*;

public class Exceptions {
    public static void main(String[] args) {
        int des;
        do {
            FuncionesCalculadora operacion = new FuncionesCalculadora();
            try {
                operacion.setOperandos(Integer.parseInt((JOptionPane.showInputDialog("Ingrese un numero"))), Integer.parseInt(JOptionPane.showInputDialog("Ingrese otro numero")));
            } catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
            }
            int opera;
            opera = JOptionPane.showOptionDialog(
                    null, "Seleccione una opcion", "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Sumar", "Restar", "Multiplicar", "Dividir"}, "Sumar");
            switch (opera) {
                case 0:
                    try {
                        rango(operacion.sumar());
                        JOptionPane.showMessageDialog(null, "El resultado es: " + operacion.sumar());
                    }catch (exceptionNegative e){
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Dialogo error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    try {
                        rango(operacion.restar());
                        JOptionPane.showMessageDialog(null, "El resultado es: " + operacion.restar());
                    }catch (exceptionNegative e){
                        JOptionPane.showMessageDialog(null,e.getMessage(),"Dialogo error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                case 2:
                    try {
                        JOptionPane.showMessageDialog(null, "El resultado es: " + operacion.multiplicar());
                    }catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                case 3:
                    try {
                        JOptionPane.showMessageDialog(null, "El resultado es: " + operacion.dividir());
                    } catch (ArithmeticException ae) {
                        JOptionPane.showMessageDialog(null, "Division cero", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Operacion con String", "Dialogo error", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                default:
                    System.out.println("Operacion invalida");
                    break;

            }

            des = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "Continuacion",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        } while (des == 0);
    }

    static void rango(int num) throws exceptionNegative {
        if (num <0) {
            throw new exceptionNegative("Número negativo como resultado");
        }
    }
}
