/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views.main.client;

/**
 *
 * @author GIANG
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ChuKyDienTuPanel extends JPanel {
    private Point lastPoint;
    private BufferedImage image;

    public ChuKyDienTuPanel() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(400, 300));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lastPoint = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                drawLine(lastPoint, e.getPoint());
                lastPoint = e.getPoint();
            }
        });
    }

    private void drawLine(Point startPoint, Point endPoint) {
        if (image == null) {
            int width = getWidth();
            int height = getHeight();
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }

        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        g2d.dispose();
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }
    }

    public void saveSignatureAsImage() {
        if (image != null) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(null); // Assuming this method is called from a non-GUI class, otherwise replace null with the parent component
            if (result == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                try {
                    // Ensuring the file has a .png extension
                    if (!fileToSave.getAbsolutePath().endsWith(".png")) {
                        fileToSave = new File(fileToSave.getAbsolutePath() + ".png");
                    }
                    ImageIO.write(image, "PNG", fileToSave);
                    JOptionPane.showMessageDialog(null, "Chữ ký đã được lưu thành công!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi khi lưu chữ ký: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chữ ký không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Chữ Ký Điện Tử");
                ChuKyDienTuPanel chuKyPanel = new ChuKyDienTuPanel();
                JButton taoChuKyButton = new JButton("Lưu Chữ Ký");
                taoChuKyButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        chuKyPanel.saveSignatureAsImage();
                    }
                });
                frame.add(chuKyPanel, BorderLayout.CENTER);
                frame.add(taoChuKyButton, BorderLayout.SOUTH);
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
