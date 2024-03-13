package com.springframeworkdemo.learnspringframework;

public class AppGamingBasicJava {
	
	public static void main(String[] args) {
//		var marioGame = new MarioGame();
		var superContraGame = new SuperContraGame();
		var gameRunner = new GameRunner(superContraGame);
		gameRunner.run();
	}

}
