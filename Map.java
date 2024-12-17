/**
 * 개선된 청주대학교 지도 맵
 * 
 * @author 2021011923 정원진
 * @version : 0.0.0
 * 
 * @created 2024-12-17
 * @lastModified 2024-12-17
 * 
 * @changelog
 * 	2024-12-17: 프로젝트 시작 및 프로토타입 생성
 * 
 */

package pkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Map extends JFrame{
	
	JPanel pnael = new JPanel();
	
	/**
	 * 모든 건물을 다 넣기엔 너무 많아서 
	 * 정문으로 기준으로 38동 대학 문화관까지만
	 */
	JButton[] buttons = new JButton[23];
	String[] list = new String[] {
			"1", "2", "3", "4", "5", 
			"6", "7", "8", "9", "10",
			"11", "14", "16", "18", "20",
			"23", "38", "40", "42", "46",
			"92", "98"};
	
	Map() {
		this.setTitle("청주대학교 지도");
		
		
		buttons();
		this.setSize(1600,900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	void buttons() {
		JPanel panel = new JPanel();
		
		/** 버튼 생성
		 * 	각각 동마다의 설명이 필요하므로 하드코딩
		 * 
		 * @created 2024-12-17
		 */
		for (int i = 0; i < list.length; i++) {
			
			panel.add(buttons[i] = new JButton(list[i]));
			buttons[i].setBackground(Color.cyan);
			buttons[i].setFont(new Font("Arial",Font.BOLD, 18));
			
			buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String run = e.getActionCommand();
					
					
					switch (run) {
					case "1": System.out.println("1동입니다");
				    break;
				    
					case "2": System.out.println("2동입니다");
				    break;
				    
					case "3": System.out.println("3동입니다");
				    break;
				    
					case "4": System.out.println("4동입니다");
				    break;
				    
					case "5": System.out.println("5동입니다");
				    break;
				    
					case "6": System.out.println("6동입니다");
				    break;
				    
					case "7": System.out.println("7동입니다");
				    break;
				    
					case "8": System.out.println("8동입니다");
				    break;
				    
					case "9": System.out.println("9동입니다");
				    break;
				    
					case "10": System.out.println("10동입니다");
				    break;
				    
					case "11": System.out.println("11동입니다");
				    break;
				    
					case "14": System.out.println("14동입니다");
				    break;
				    
					case "16": System.out.println("16동입니다");
				    break;
				    
					case "18": System.out.println("18동입니다");
				    break;
				    
					case "20": System.out.println("20동입니다");
				    break;
				    
					case "23": System.out.println("23동입니다");
				    break;
				    
					case "38": System.out.println("38동입니다");
				    break;
				    
					case "40": System.out.println("40동입니다");
				    break;
				    
					case "42": System.out.println("42동입니다");
				    break;
				    
					case "46": System.out.println("46동입니다");
				    break;
				    
					case "92": System.out.println("92동입니다");
				    break;
				    
					case "98": System.out.println("98동입니다");
				    break;
					}
				}
			});
		}
		
		
		add(panel,BorderLayout.CENTER);
		
	}

	public static void main(String[] args) {
		new Map();

	}

}
