package pkg;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Map extends JFrame {

    /**
     * 필드 선언
     */
    JPanel panel = new JPanel();
    JLabel label = new JLabel();

    JButton[] buttons = new JButton[23];
    String[] list = new String[]{
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "14", "16", "18", "20",
            "23", "38", "40", "42", "46",
            "92", "98"};

    Map() {

        BackgroundPanel bgPanel;
        try {
            BufferedImage img = ImageIO.read(new File("img/bg.png"));
            bgPanel = new BackgroundPanel(img);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "이미지가 없습니다!");
            System.exit(0);
            return;
        }

        bgPanel.setLayout(new BorderLayout());
        buttons();

        bgPanel.add(panel, BorderLayout.CENTER);

        this.setTitle("청주대학교 지도");
        this.setResizable(false); // 창 크기 변경불가
        this.setSize(1600, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(bgPanel);
        this.setVisible(true);
    }

    
    /**
     * 버튼 클래스
     */
    void buttons() {
        panel = new JPanel();
        panel.setOpaque(false);

        for (int i = 0; i < list.length; i++) {

            panel.add(buttons[i] = new JButton(list[i]));
            buttons[i].setBackground(Color.cyan);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 18));

            buttons[i].addActionListener(e -> {
                String run = e.getActionCommand();

                switch (run) {
                    case "1":
                        System.out.println("1동입니다");
                        break;
                    case "2":
                        System.out.println("2동입니다");
                        break;
                    case "3":
                        System.out.println("3동입니다");
                        break;
                    case "4":
                        System.out.println("4동입니다");
                        break;
                    case "5":
                        System.out.println("5동입니다");
                        break;
                    case "6":
                        System.out.println("6동입니다");
                        break;
                    case "7":
                        System.out.println("7동입니다");
                        break;
                    case "8":
                        System.out.println("8동입니다");
                        break;
                    case "9":
                        System.out.println("9동입니다");
                        break;
                    case "10":
                        System.out.println("10동입니다");
                        break;
                    case "11":
                        System.out.println("11동입니다");
                        break;
                    case "14":
                        System.out.println("14동입니다");
                        break;
                    case "16":
                        System.out.println("16동입니다");
                        break;
                    case "18":
                        System.out.println("18동입니다");
                        break;
                    case "20":
                        System.out.println("20동입니다");
                        break;
                    case "23":
                        System.out.println("23동입니다");
                        break;
                    case "38":
                        System.out.println("38동입니다");
                        break;
                    case "40":
                        System.out.println("40동입니다");
                        break;
                    case "42":
                        System.out.println("42동입니다");
                        break;
                    case "46":
                        System.out.println("46동입니다");
                        break;
                    case "92":
                        System.out.println("92동입니다");
                        break;
                    case "98":
                        System.out.println("98동입니다");
                        break;
                }
            });
        }
    }

    public static void main(String[] args) {
        new Map();
    }
}

/**
 * 배경 이미지
 */
class BackgroundPanel extends JPanel {
    private final Image backgroundImage;

    public BackgroundPanel(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
