package com.design_shinbi.blackjack;

import java.util.Scanner;

public class Blackjack {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start(scanner);
        scanner.close();
    }


    public static void start(Scanner scanner) {
    	Player player = new Player(scanner);
    	Dealer dealer = new Dealer();
    	Stock stock = new Stock();
    	
    	player.start(stock);
    	dealer.start(stock);
    	
    	dealer.display();
    	
    	player.play(stock);
    	dealer.play(stock);
    	
    	showResult(player, dealer);
    	
  
    }

    public static void showResult(Attender player, Attender dealer) {
        dealer.display();
        player.display();
        
        int dealerStrength = dealer.calculateStrength();
        int playerStrength = player.calculateStrength();
        
        if(dealerStrength < playerStrength) {
        	System.out.println("あなたの勝ち！");
        }else if(dealerStrength > playerStrength) {
        	System.out.println("あなたの負け！");
        }else {
        	System.out.println("引き分けです！");
        }

    }
}
