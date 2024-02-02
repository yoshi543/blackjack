package com.design_shinbi.blackjack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Attender {
	protected List<Card> cards;
	protected String name;
	
	public Attender(String name) { 
		this.name = name;
		initialize();
	}
	
	public void initialize() {   //初期化
		this.cards = new ArrayList<Card>();
	}                      //山札
	
	public void start(Stock stock) {
		this.cards.clear();
		for(int i = 0; i < 2; i++) {
			Card card = stock.pickCard();
			this.cards.add(card);
		}
	}
	
	public String getName() {   
		return name;
	}
	
	public void hit(Stock stock) {     //ヒット：カードを１枚引く
		Card card = stock.pickCard();   //山札からカードを引くよ
		this.cards.add(card);
	}
	
	public static int calculateStrengthFromList(List<Card>list) {
		int strength = 0;
		boolean havingAce = false;
		
		
		for(Card card : list) {
			int number = card.getNumber();  // Aが11になるのは多くて1枚
			if(number == 1) {                  //最初は１を足してみる
				havingAce = true; //aを持っているという情報をtrueにする
			}
			if(number > 10) {
				number = 10;
			}
			strength += number;
			
			}
			if(havingAce && strength <= 11) {
			strength += 10;
			}
		
			if(strength > 21) {
			strength = 0;
			}
			
			return strength;
		}
	
	public int calculateStrength() {
        int strength = calculateStrengthFromList(this.cards);
        return strength;
    }
	
	public String toString() {
		String string = name + ":";
		for(int i = 0; i < this.cards.size(); i++) {
			Card card = this.cards.get(i);
			string = string + card.toString();
		}
		return string;
	}
	
	public void display() {
		System.out.println(this.toString());
	}
	
	public abstract void play(Stock stock) throws IOException;
	
}
