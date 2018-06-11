package com.haoli.util;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GifShow extends JFrame{
	public static void main(String[] args){
		GifShow show = new GifShow();
		show.gifShow("/Users/haoli/Downloads/GIF/吃惊1.gif");
	}
	
	
	public void gifShow(String pathOfGif) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 421, 322);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //使用自己的组件显示GIF
        GifComponent gifComponent=new GifComponent(new File(pathOfGif), 120,413,288);
        gifComponent.setBounds(0, 0, 413, 288);
        contentPane.add(gifComponent);
    }
}

