package pkg;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Map extends JFrame {

    JPanel buttonPanel = new JPanel();
    JLabel textLabel_1 = new JLabel("여기에 이름이 입력됩니다.");
    JLabel textLabel_2 = new JLabel("여기에 설명이 입력됩니다.");

    JButton[] buttons = new JButton[23];
    String[] list = new String[]{
            "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "14", "16", "18", "20",
            "23", "38", "40", "42", "46",
            "93", "98"};

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
        bgPanel.add(textLabel_1);
        bgPanel.add(textLabel_2);

        //x,y,넓이,높이
        buttonPanel.setBounds(50, 500, 1500, 500);
        
        
        textLabel_1.setBounds(1200, 50, 400, 100);
        textLabel_1.setFont(new Font("맑은고딕", Font.BOLD, 20));
        
        
        textLabel_2.setBounds(1200, 100, 400, 100);
        textLabel_2.setFont(new Font("맑은고딕", Font.BOLD, 20));
        textLabel_2.setForeground(Color.gray);

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
                    textLabel_1.setText("1동 청석교육역사관");
                    textLabel_2.setText("");
                    break;
                    
                case "2":
                    textLabel_1.setText("2동 대학원");
                    textLabel_2.setText("");
                    break;
                    
                case "3":
                    textLabel_1.setText("3동 입학취업지원관");
                    textLabel_2.setText("");
                    break;
                    
                case "4":
                    textLabel_1.setText("4동 박물관");
                    textLabel_2.setText("");
                    break;
                    
                case "5":
                    textLabel_1.setText("5동 청석관(본관)");
                    textLabel_2.setText("");
                    break;
                    
                case "6":
                    textLabel_1.setText("6동 융합관");
                    textLabel_2.setText("");
                    break;
                    
                case "7":
                    textLabel_1.setText("7동 공과대학(구관)");
                    textLabel_2.setText("");
                    break;
                    
                case "8":
                    textLabel_1.setText("8동 보건의료과학대학");
                    textLabel_2.setText("");
                    break;
                    
                case "9":
                    textLabel_1.setText("9동 비즈니스대학");
                    textLabel_2.setText("");
                    break;
                    
                case "10":
                    textLabel_1.setText("10동 교수연구동");
                    textLabel_2.setText("");
                    break;
                    
                case "11":
                    textLabel_1.setText("11동 중앙도서관");
                    textLabel_2.setText("");
                    break;
                    
                case "13":
                    textLabel_1.setText("13동 종합강의동");
                    textLabel_2.setText("");
                    break;
                    
                case "14":
                    textLabel_1.setText("14동 공과대학(신관)");
                    textLabel_2.setText("");
                    break;
                    
                case "16":
                    textLabel_1.setText("16동 CJU학생지원관");
                    textLabel_2.setText("");
                    break;
                    
                case "18":
                    textLabel_1.setText("18동 금융센터");
                    textLabel_2.setText("");
                    break;
                    
                case "20":
                    textLabel_1.setText("20동 인문사회 . 사범대학");
                    textLabel_2.setText("");
                    break;
                    
                case "23":
                    textLabel_1.setText("23동 PoE관");
                    textLabel_2.setText("");
                    break;
                    
                case "38":
                    textLabel_1.setText("38동 대학문화관");
                    textLabel_2.setText("");
                    break;
                    
                case "40":
                    textLabel_1.setText("40동 종합운동장");
                    textLabel_2.setText("");
                    break;
                    
                case "42":
                    textLabel_1.setText("42동 새천년종합정보관");
                    textLabel_2.setText("");
                    break;
                    
                case "46":
                    textLabel_1.setText("46동 온실");
                    textLabel_2.setText("");
                    break;
                    
                case "93":
                    textLabel_1.setText("93동 기숙사(진원관)");
                    textLabel_2.setText("");
                    break;
                    
                case "98":
                    textLabel_1.setText("98동 교양 실습동");
                    textLabel_2.setText("");
                    break;
            }
            });
        }
    }

    /**
     * 텍스트 설정
     */
    void text() {
    	textLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    	textLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
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
