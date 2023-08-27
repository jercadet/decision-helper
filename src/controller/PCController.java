package controller;

import view.PCGUI;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PCController {
        public static void main(String[] args) {
            PCGUI.setDefaultLookAndFeelDecorated(false);
            PCGUI frame = new PCGUI();

            frame.display();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            try {
                // Set cross-platform Java L&F (also called "Metal")
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

                //UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());

                //   UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                //    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                //    {
                //       if ("Nimbus".equals(info.getName())) {
                //          UIManager.setLookAndFeel(info.getClassName());
                //         break;
                //    }
                // }
            } catch (UnsupportedLookAndFeelException e) {
                // handle exception
            } catch (ClassNotFoundException e) {
                // handle exception
            } catch (InstantiationException e) {
                // handle exception
            } catch (IllegalAccessException e) {
                // handle exception
            } catch (Exception e) {
            }

        }
}
