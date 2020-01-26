package com.main;

import java.util.Random;

public class Spawner {
	
	private Handler handler;
	private HUD hud;
	private int regulator=100;
	private int Slower=200;
	private int Limitor=2;
	private GameObject gameObject;
	private boolean BossAlive=false;
	private boolean WeirdRoom=false;
	
	private Random r=new Random();
	
	private int ScoreKeep=0;
	public Spawner(Handler handler, HUD hud)
	{
		this.handler= handler;
		this.hud=hud;
	}
	
	public void tick()
	{
		ScoreKeep++;
		Boss1();
		Boss2();
		basicSpawn();
	}
	private void Boss2()
	{
		if(hud.getLevel()==11)
		{
			if(BossAlive==false) {
				ScoreKeep=0;
				handler.addObject(new Boss2(Game.WIDTH/2,0, ID.Boss2 , handler));	
				BossAlive=true;
			}
			for(int i=0; i<handler.object.size();i++)
			{
				gameObject=handler.object.get(i);
				if(gameObject.getId()!=ID.Player&&gameObject.getId()!=ID.Boss2&&gameObject.getId()!=ID.Trail&&gameObject.getId()!=ID.Boss2Bullet) {
					handler.removeObject(gameObject);
				}
			}
			if(ScoreKeep>=500)
			{
				hud.setLevel(12);
				ScoreKeep=regulator+1;
				Slower=200;
				Limitor=59;
				for(int i=0; i<handler.object.size();i++)
				{
					gameObject=handler.object.get(i);
					if(gameObject.getId()==ID.Boss2||gameObject.getId()==ID.Boss2Bullet) {
						handler.removeObject(gameObject);
						BossAlive=false;
					}
				}
			}
			}
		
	}

	private void Boss1()

	{
		if(hud.getLevel()==5)
		{
			if(BossAlive==false) {
				ScoreKeep=0;
				handler.addObject(new Boss1(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.Boss1,handler));	
				BossAlive=true;
			}
			
			for(int i=0; i<handler.object.size()-1;i++)
			{
//				u = i;
				gameObject=handler.object.get(i);
				if(gameObject.getId()!=ID.Player&&gameObject.getId()!=ID.Boss1&&gameObject.getId()!=ID.Trail) {
					handler.removeObject(gameObject);
				}
			}
			if(ScoreKeep>=300)
			{
				hud.setLevel(6);
				ScoreKeep=regulator+1;
				Slower=200;
				Limitor=59;
				for(int i=0; i<handler.object.size();i++)
				{
					gameObject=handler.object.get(i);
					if(gameObject.getId()==ID.Boss1) {
						handler.removeObject(gameObject);
						BossAlive=false;
					}
				}
			}
			}
	}
	
	private void basicSpawn()
	{
		if(BossAlive==false)
		{	
		if(ScoreKeep>= regulator)
		{
			ScoreKeep=0;
			Limitor++;
			regulator=regulator*2;
			if(regulator>Slower)
				regulator=Slower/2;
			Slower+=50;
			hud.setLevel(hud.getLevel()+1);
			if(hud.getLevel()==7&&WeirdRoom==false) {
				hud.setLevel(6);
				WeirdRoom=true;
				}
		
			if(Limitor%3==0)
				handler.addObject(new basicEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.basicEnnemy,handler));
			if(Limitor%4==0)
				handler.addObject(new fastEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.fastEnnemy,handler));
			if(Limitor%5==0) {
				handler.addObject(new smartEnemy(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.smartEnnemy,handler));
				handler.addObject(new Healer(r.nextInt(Game.WIDTH-70), r.nextInt(Game.HEIGHT-70), ID.Healer,handler));
		}
			
		
	}
	
	
}
	}
}
