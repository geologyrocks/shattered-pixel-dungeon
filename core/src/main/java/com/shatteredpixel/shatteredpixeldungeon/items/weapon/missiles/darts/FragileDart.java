/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.MagicImmune;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.HeroClass;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.Bag;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.VelvetPouch;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Crossbow;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.MissileWeapon;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.Dart;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.plants.Plant;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndBag;
import com.shatteredpixel.shatteredpixeldungeon.windows.WndOptions;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class FragileDart extends MissileWeapon {

	{
		image = ItemSpriteSheet.DART;
		hitSound = Assets.Sounds.HIT_ARROW;
		hitSoundPitch = 1.3f;
		
		tier = 1;
		
		// single-shot for ease
		baseUses = 1;
	}
	
	@Override
	public int min(int lvl) {
		if (bow != null){
			return  4 +                    //4 base
					bow.buffedLvl() + lvl; //+1 per level or bow level
		} else {
			return  1 +     //1 base, down from 2
					lvl;    //scaling unchanged
		}
	}

	@Override
	public int max(int lvl) {
		if (bow != null){
			return  12 +                       //12 base
					3*bow.buffedLvl() + 2*lvl; //+3 per bow level, +2 per level (default scaling +2)
		} else {
			return  2 +     //2 base, down from 5
					2*lvl;  //scaling unchanged
		}
	}
	
	private static Crossbow bow;
	
	private void updateCrossbow(){
		if (Dungeon.hero.belongings.weapon() instanceof Crossbow){
			bow = (Crossbow) Dungeon.hero.belongings.weapon();
		} else {
			bow = null;
		}
	}

	public boolean crossbowHasEnchant( Char owner ){
		return bow != null && bow.enchantment != null && owner.buff(MagicImmune.class) == null;
	}
	
	@Override
	public boolean hasEnchant(Class<? extends Enchantment> type, Char owner) {
		if (bow != null && bow.hasEnchant(type, owner)){
			return true;
		} else {
			return super.hasEnchant(type, owner);
		}
	}
	
	@Override
	public int proc(Char attacker, Char defender, int damage) {
		if (bow != null){
			damage = bow.proc(attacker, defender, damage);
		}

		return super.proc(attacker, defender, damage);
	}
	
	@Override
	protected void onThrow(int cell) {
		updateCrossbow();
		super.onThrow(cell);
	}

	@Override
	public void throwSound() {
		updateCrossbow();
		if (bow != null) {
			Sample.INSTANCE.play(Assets.Sounds.ATK_CROSSBOW, 1, Random.Float(0.87f, 1.15f));
		} else {
			super.throwSound();
		}
	}
	
	@Override
	public String info() {
		updateCrossbow();
		if (bow != null && !bow.isIdentified()){
			int level = bow.level();
			//temporarily sets the level of the bow to 0 for IDing purposes
			bow.level(0);
			String info = super.info();
			bow.level(level);
			return info;
		} else {
			return super.info();
		}
	}
	
	@Override
	public boolean isUpgradable() {
		return false;
	}
	
	@Override
	public int value() {
		return super.value()/2; //half normal value
	}
}
