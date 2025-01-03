package pkg;

/**
 * 개선된 청주대학교 지도 맵
 * 
 * @author 2021011923 정원진
 * @version : 0.0.6
 * 
 * @created 2024-12-17
 * @lastModified 2024-12-24
 * 
 * @changelog
 * 	2024-12-17: 프로젝트 시작 및 프로토타입 생성
 * 	2024-12-19: 배경이미지 추가
 * 	2024-12-20: 텍스트추가 및 절대위치지정
 *  2024-12-21: 텍스트 세분화 및 버튼 클릭시 출력값 추가
 *  2024-12-23: 건물이미지 추가 및 버튼 클릭시 이미지변경기능 추가
 *  2024-12-24: 버튼의 절대위치 조정
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
            "11", "13","14", "16", "18", "20",
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
        buttonPanel.setBounds(50, 0, 5000, 5000);
        
        
        textLabel_1.setBounds(1200, 150, 400, 100);
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
     * 버튼 생성 및 절대위치 조정
     */
	void buttons() {
		buttonPanel.setOpaque(false); // 배경 투명
	    buttonPanel.setLayout(null); // 절대위치
		
	    int[][] btPositions = {
	            {100, 310, 50, 50},  // 버튼 1 *
	            {220, 330, 50, 50}, // 버튼 2 *
	            {250, 400, 50, 50}, // 버튼 3 *
	            {580, 225, 50, 50}, // 버튼 4 *
	            {530, 290, 50, 50}, // 버튼 5 *
	            {460, 190, 50, 50}, // 버튼 6 *
	            {500, 90, 50, 50}, // 버튼 7 *
	            {610, 100, 50, 50}, // 버튼 8 *
	            {840, 180, 50, 50}, // 버튼 9 *
	            {980, 200, 50, 50}, // 버튼 10 *
	            {320, 230, 50, 50},  // 버튼 11
	            {1075, 300, 50, 50}, // 버튼 13 *
	            {450, 55, 50, 50}, // 버튼 14 *
	            {150, 460, 50, 50}, // 버튼 16 *
	            {310, 380, 50, 50}, // 버튼 18 *
	            {730, 250, 50, 50},  // 버튼 20 *
	            {200, 420, 50, 50}, // 버튼 23 *
	            {300, 10, 50, 50}, // 버튼 38 *
	            {180, 100, 50, 50}, // 버튼 40 *
	            {220, 170, 50, 50}, // 버튼 42 *
	            {370, 60, 50, 50},  // 버튼 46 *
	            {630, 310, 50, 50}, // 버튼 93 *
	            {100, 550, 50, 50} //버튼 98 *
	        };

		for (int i = 0; i < list.length; i++) {

			buttonPanel.add(buttons[i] = new JButton(list[i]));
			buttons[i].setFont(new Font("Arial", Font.BOLD, 13));
	        buttons[i].setBounds(btPositions[i][0], btPositions[i][1], btPositions[i][2], btPositions[i][3]);
	        buttonPanel.add(buttons[i]);
			
			buttons[i].addActionListener(e -> {
				String run = e.getActionCommand();

				switch (run) {
				case "1":
					textLabel_1.setText("청석교육역사관[01]");
					textLabel_2.setText("과거 법학대학 건물로 사용됐었다");
					image = new ImageIcon("img/1.png").getImage();
					imgsPanel.repaint();
					break;

				case "2":
					textLabel_1.setText("대학원[02]");
					textLabel_2.setText("대학원생들이 강의를 듣는 곳");
					image = new ImageIcon("img/2.png").getImage();
					imgsPanel.repaint();
					break;

				case "3":
					textLabel_1.setText("입학취업지원관[03]");
					textLabel_2.setText("입학/취업관리팀이 근무하는 곳");
					image = new ImageIcon("img/3.png").getImage();
					imgsPanel.repaint();
					break;

				case "4":
					textLabel_1.setText("박물관[04]");
					textLabel_2.setText("유물/서재등을 전시하는 곳");
					image = new ImageIcon("img/4.png").getImage();
					imgsPanel.repaint();
					break;

				case "5":
					textLabel_1.setText("청석관(본관)[05]");
					textLabel_2.setText("교직원식당이 있는 곳");
					image = new ImageIcon("img/5.png").getImage();
					imgsPanel.repaint();
					break;

				case "6":
					textLabel_1.setText("융합관[06]");
					textLabel_2.setText("소프트웨어융합학부 학생들이 수업받는 곳");
					image = new ImageIcon("img/6.png").getImage();
					imgsPanel.repaint();
					break;

				case "7":
					textLabel_1.setText("공과대학[07]");
					textLabel_2.setText("건축학과 학생들이 수업을 받는 곳");
					image = new ImageIcon("img/7.png").getImage();
					imgsPanel.repaint();
					break;

				case "8":
					textLabel_1.setText("보건의료과학대학[08]");
					textLabel_2.setText("항공학과/간호학과 학생이 수업을 듣는 곳");
					image = new ImageIcon("img/8.png").getImage();
					imgsPanel.repaint();
					break;

				case "9":
					textLabel_1.setText("비즈니스대학[09]");
					textLabel_2.setText("경제학과,회계학생들이 수업을 듣는 곳");
					image = new ImageIcon("img/9.png").getImage();
					imgsPanel.repaint();
					break;

				case "10":
					textLabel_1.setText("교수연구동[10]");
					textLabel_2.setText("(모르는 장소)");
					image = new ImageIcon("img/10.png").getImage();
					imgsPanel.repaint();
					break;

				case "11":
					textLabel_1.setText("중앙도서관[11]");
					textLabel_2.setText("책을 빌리거나 열람실에서 공부를 하는 곳");
					image = new ImageIcon("img/11.png").getImage();
					imgsPanel.repaint();
					break;
					
				case "13":
					textLabel_1.setText("종합강의동[13]");
					textLabel_2.setText("종합적인 수업을 듣는 곳");
					image = new ImageIcon("img/13.png").getImage();
					imgsPanel.repaint();
					break;

				case "14":
					textLabel_1.setText("공과대학(신관)[14]");
					textLabel_2.setText("공과대생들이 수업을 듣는 곳");
					image = new ImageIcon("img/14.png").getImage();
					imgsPanel.repaint();
					break;

				case "16":
					textLabel_1.setText("CJU학생지원관[16]");
					textLabel_2.setText("행정부서");
					image = new ImageIcon("img/16.png").getImage();
					imgsPanel.repaint();
					break;

				case "18":
					textLabel_1.setText("금융센터[18]");
					textLabel_2.setText("신한은행");
					image = new ImageIcon("img/18.png").getImage();
					imgsPanel.repaint();
					break;

				case "20":
					textLabel_1.setText("인문사회/사범대학[20]");
					textLabel_2.setText("인문/사범대생이 수업을 듣는 곳");
					image = new ImageIcon("img/20.png").getImage();
					imgsPanel.repaint();
					break;

				case "23":
					textLabel_1.setText("PoE관[23]");
					textLabel_2.setText("교육연구시설");
					image = new ImageIcon("img/0.png").getImage();
					imgsPanel.repaint();
					break;

				case "38":
					textLabel_1.setText("대학문화관[38]");
					textLabel_2.setText("행정부서와 매점이 위치한 곳");
					image = new ImageIcon("img/38.png").getImage();
					imgsPanel.repaint();
					break;

				case "40":
					textLabel_1.setText("종합운동장[40]");
					textLabel_2.setText("운동장입니다.");
					image = new ImageIcon("img/40.png").getImage();
					imgsPanel.repaint();
					break;

				case "42":
					textLabel_1.setText("새천년종합정보관[42]");
					textLabel_2.setText("어학교육,교수학습개발을 하는 곳");
					image = new ImageIcon("img/42.png").getImage();
					imgsPanel.repaint();
					break;

				case "46":
					textLabel_1.setText("온실[46]");
					textLabel_2.setText("(모르는 장소)");
					image = new ImageIcon("img/46.png").getImage();
					imgsPanel.repaint();
					break;

				case "93":
					textLabel_1.setText("기숙사(진원관)[93]");
					textLabel_2.setText("학생들이 숙박하는 장소");
					image = new ImageIcon("img/93.png").getImage();
					imgsPanel.repaint();
					break;

				case "98":
					textLabel_1.setText("교양 실습동[98]");
					textLabel_2.setText("항공학부가 사용하는 곳");
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
