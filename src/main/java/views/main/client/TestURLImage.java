/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.main.client;

import java.awt.EventQueue;
import javax.swing.UIManager;

/**
 *
 * @author GIANG
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class TestURLImage {

    public static void main(String[] args) {
        new TestURLImage();
    }

    public TestURLImage() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            try {
                String path = "https://res.cloudinary.com/djfpcyyfe/image/upload/v1717260495/yqwqb9lvwkhpykfsaif0.png";
                System.out.println("Get Image from " + path);
                URL url = new URL(path);
                BufferedImage image = ImageIO.read(url);
                System.out.println("Load image into frame...");
                JLabel label = new JLabel(new ImageIcon(image));
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.getContentPane().add(label);
                f.pack();
                f.setLocationRelativeTo(null); // Đặt vị trí cửa sổ ở giữa màn hình
                f.setVisible(true);
            } catch (IOException exp) {
                exp.printStackTrace();
            }

        });
    }
    public JLabel getImageLabelFromURL(String path) {
        JLabel label = null;
        try {
            URL url = new URL(path);
            BufferedImage image = ImageIO.read(url);
            label = new JLabel(new ImageIcon(image));
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        return label;
    }
}
