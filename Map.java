package pkg;

/**
 * 개선된 청주대학교 지도 맵
 * 
 * @author 2021011923 정원진
 * @version : 0.0.5
 * 
 * @created 2024-12-17
 * @lastModified 2024-12-23
 * 
 * @changelog
 * 	2024-12-17: 프로젝트 시작 및 프로토타입 생성
 * 	2024-12-19: 배경이미지 추가
 * 	2024-12-20: 텍스트추가 및 절대위치지정
 *  2024-12-21: 텍스트 세분화 및 버튼 클릭시 출력값 추가
 *  2024-12-23: 건물이미지 추가 및 버튼 클릭시 이미지변경기능 추가
 * 
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Map extends JFrame {

    JPanel buttonPanel = new JPanel();
    JPanel imgsPanel = new JPanel();
    
    JLabel textLabel_1 = new JLabel("여기에 이름이 입력됩니다.");
    JLabel textLabel_2 = new JLabel("여기에 설명이 입력됩니다.");
    
    Image image;
    

    //버튼 생성
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

        imgs();
        buttons();
        text();

        bgPanel.add(buttonPanel);
        bgPanel.add(textLabel_1);
        bgPanel.add(textLabel_2);
        bgPanel.add(imgsPanel);

        //x,y,넓이,높이
        buttonPanel.setBounds(50, 500, 1500, 500);
        
        
        textLabel_1.setBounds(1200, 175, 400, 100);
        textLabel_1.setFont(new Font("맑은고딕", Font.BOLD, 20));
        
        
        textLabel_2.setBounds(1200, 200, 400, 100);
        textLabel_2.setFont(new Font("맑은고딕", Font.BOLD, 18));
        textLabel_2.setForeground(Color.gray);

        this.setTitle("청주대학교 지도");
        this.setResizable(false); // 창 크기 변경불가
        this.setSize(1600, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(bgPanel);
        this.setVisible(true);
    }
    
    //이미지 생성
    //GPT의 도움을 받았습니다.
    void imgs() {
        imgsPanel = new JPanel() {

            {
                image = new ImageIcon("img/0_1.png").getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {

                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        imgsPanel.setLayout(null);
        imgsPanel.setBounds(1290, 50, 220, 118);
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
					textLabel_2.setText("과거 법학대학 건물로 사용됐었다");
					image = new ImageIcon("img/1.png").getImage();
					imgsPanel.repaint();
					break;

				case "2":
					textLabel_1.setText("2동 대학원");
					textLabel_2.setText("대학원생들이 강의를 듣는 곳");
					image = new ImageIcon("img/2.png").getImage();
					imgsPanel.repaint();
					break;

				case "3":
					textLabel_1.setText("3동 입학취업지원관");
					textLabel_2.setText("");
					image = new ImageIcon("img/3.png").getImage();
					imgsPanel.repaint();
					break;

				case "4":
					textLabel_1.setText("4동 박물관");
					textLabel_2.setText("");
					image = new ImageIcon("img/4.png").getImage();
					imgsPanel.repaint();
					break;

				case "5":
					textLabel_1.setText("5동 청석관(본관)");
					textLabel_2.setText("");
					image = new ImageIcon("img/5.png").getImage();
					imgsPanel.repaint();
					break;

				case "6":
					textLabel_1.setText("6동 융합관");
					textLabel_2.setText("");
					image = new ImageIcon("img/6.png").getImage();
					imgsPanel.repaint();
					break;

				case "7":
					textLabel_1.setText("7동 공과대학(구관)");
					textLabel_2.setText("");
					image = new ImageIcon("img/7.png").getImage();
					imgsPanel.repaint();
					break;

				case "8":
					textLabel_1.setText("8동 보건의료과학대학");
					textLabel_2.setText("");
					image = new ImageIcon("img/8.png").getImage();
					imgsPanel.repaint();
					break;

				case "9":
					textLabel_1.setText("9동 비즈니스대학");
					textLabel_2.setText("");
					image = new ImageIcon("img/9.png").getImage();
					imgsPanel.repaint();
					break;

				case "10":
					textLabel_1.setText("10동 교수연구동");
					textLabel_2.setText("");
					image = new ImageIcon("img/10.png").getImage();
					imgsPanel.repaint();
					break;

				case "11":
					textLabel_1.setText("11동 중앙도서관");
					textLabel_2.setText("");
					image = new ImageIcon("img/11.png").getImage();
					imgsPanel.repaint();
					break;

				case "14":
					textLabel_1.setText("14동 공과대학(신관)");
					textLabel_2.setText("");
					image = new ImageIcon("img/14.png").getImage();
					imgsPanel.repaint();
					break;

				case "16":
					textLabel_1.setText("16동 CJU학생지원관");
					textLabel_2.setText("");
					image = new ImageIcon("img/16.png").getImage();
					imgsPanel.repaint();
					break;

				case "18":
					textLabel_1.setText("18동 금융센터");
					textLabel_2.setText("");
					image = new ImageIcon("img/18.png").getImage();
					imgsPanel.repaint();
					break;

				case "20":
					textLabel_1.setText("20동 인문사회 . 사범대학");
					textLabel_2.setText("");
					image = new ImageIcon("img/20.png").getImage();
					imgsPanel.repaint();
					break;

				case "23":
					textLabel_1.setText("23동 PoE관");
					textLabel_2.setText("");
					image = new ImageIcon("img/0.png").getImage();
					imgsPanel.repaint();
					break;

				case "38":
					textLabel_1.setText("38동 대학문화관");
					textLabel_2.setText("");
					image = new ImageIcon("img/38.png").getImage();
					imgsPanel.repaint();
					break;

				case "40":
					textLabel_1.setText("40동 종합운동장");
					textLabel_2.setText("");
					image = new ImageIcon("img/40.png").getImage();
					imgsPanel.repaint();
					break;

				case "42":
					textLabel_1.setText("42동 새천년종합정보관");
					textLabel_2.setText("");
					image = new ImageIcon("img/42.png").getImage();
					imgsPanel.repaint();
					break;

				case "46":
					textLabel_1.setText("46동 온실");
					textLabel_2.setText("");
					image = new ImageIcon("img/46.png").getImage();
					imgsPanel.repaint();
					break;

				case "93":
					textLabel_1.setText("93동 기숙사(진원관)");
					textLabel_2.setText("");
					image = new ImageIcon("img/93.png").getImage();
					imgsPanel.repaint();
					break;

				case "98":
					textLabel_1.setText("98동 교양 실습동");
					textLabel_2.setText("");
					image = new ImageIcon("img/98.png").getImage();
					imgsPanel.repaint();
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
