package pkg;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Map extends JFrame {

    JPanel buttonPanel = new JPanel();
    JLabel textLabel = new JLabel("테스트용 텍스트");

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

        bgPanel.setLayout(null);

        buttons();
        text();

        bgPanel.add(buttonPanel);
        bgPanel.add(textLabel);

        //x,y,넓이,높이
        buttonPanel.setBounds(50, 500, 1500, 500);
        textLabel.setBounds(1200, 100, 200, 100);
        textLabel.setFont(new Font("맑은고딕", Font.BOLD, 20));
        textLabel.setForeground(Color.gray);

        this.setTitle("청주대학교 지도");
        this.setResizable(false); // 창 크기 변경불가
        this.setSize(1600, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(bgPanel);
        this.setVisible(true);
    }

    /**
     * 버튼 생성
     */
    void buttons() {
        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // 배경 투명
        buttonPanel.setLayout(new FlowLayout());

        for (int i = 0; i < list.length; i++) {

            buttonPanel.add(buttons[i] = new JButton(list[i]));
            buttons[i].setBackground(Color.cyan);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 18));

            buttons[i].addActionListener(e -> {
                String run = e.getActionCommand();

                switch (run) {
                    case "1":
                        textLabel.setText("1동입니다");
                        break;
                    case "2":
                        textLabel.setText("2동입니다");
                        break;
                    case "3":
                        textLabel.setText("3동입니다");
                        break;
                    case "4":
                        textLabel.setText("4동입니다");
                        break;
                    case "5":
                        textLabel.setText("5동입니다");
                        break;
                    case "6":
                        textLabel.setText("6동입니다");
                        break;
                    case "7":
                        textLabel.setText("7동입니다");
                        break;
                    case "8":
                        textLabel.setText("8동입니다");
                        break;
                    case "9":
                        textLabel.setText("9동입니다");
                        break;
                    case "10":
                        textLabel.setText("10동입니다");
                        break;
                    case "11":
                        textLabel.setText("11동입니다");
                        break;
                    case "14":
                        textLabel.setText("14동입니다");
                        break;
                    case "16":
                        textLabel.setText("16동입니다");
                        break;
                    case "18":
                        textLabel.setText("18동입니다");
                        break;
                    case "20":
                        textLabel.setText("20동입니다");
                        break;
                    case "23":
                        textLabel.setText("23동입니다");
                        break;
                    case "38":
                        textLabel.setText("38동입니다");
                        break;
                    case "40":
                        textLabel.setText("40동입니다");
                        break;
                    case "42":
                        textLabel.setText("42동입니다");
                        break;
                    case "46":
                        textLabel.setText("46동입니다");
                        break;
                    case "92":
                        textLabel.setText("92동입니다");
                        break;
                    case "98":
                        textLabel.setText("98동입니다");
                        break;
                }
            });
        }
    }

    /**
     * 텍스트 설정
     */
    void text() {
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
