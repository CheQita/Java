package main;

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import javax.swing.BoxLayout;
    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.SwingUtilities;

    /**
     *
     * @author root
     */

    public class test extends JFrame{

        JPanel rightPanel;

        public test() {
             initGui();
        }        

        public void initGui()
        {
           JPanel mainPanel=new JPanel();
           mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

           JPanel leftPanel=new JPanel();
           leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

            rightPanel=new JPanel();
           rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

           JButton dbBut=new JButton("DB");
           JButton appliBut=new JButton("Appli");
           appliBut.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent arg0) {
                	System.out.println("hej");
                    JLabel label=new JLabel("dsggs");
                   rightPanel.add(label);
                   rightPanel.revalidate();
                }
            });

           JButton backendBut=new JButton("Backend");

           leftPanel.add(dbBut);
           leftPanel.add(appliBut);
           leftPanel.add(backendBut);    

           mainPanel.add(leftPanel);
           mainPanel.add(rightPanel);

           add(mainPanel);

            setTitle("System Manger");
            setSize(400, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);


        }

    public static void main(String args[]) {
            SwingUtilities.invokeLater(new Runnable() {

                public void run() {
                    test myObj = new test();
                    myObj.setVisible(true);
                }
            });
        }
    }