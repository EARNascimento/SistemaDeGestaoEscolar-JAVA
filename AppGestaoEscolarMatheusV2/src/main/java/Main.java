import javax.swing.*;

//Testando o merge
//Testando o merge de novo, agora na main
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Hub().setVisible(true);
            }
        });
    }
}
