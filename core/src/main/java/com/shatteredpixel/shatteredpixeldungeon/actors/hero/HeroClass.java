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

package com.shatteredpixel.shatteredpixeldungeon.actors.hero;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Badges;
import com.shatteredpixel.shatteredpixeldungeon.Challenges;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.QuickSlot;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.ArmorAbility;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.huntress.NaturesPower;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.huntress.SpiritHawk;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.huntress.SpectralBlades;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.mage.WildMagic;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.mage.WarpBeacon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.mage.ElementalBlast;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.rogue.DeathMark;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.rogue.ShadowClone;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.rogue.SmokeBomb;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.warrior.HeroicLeap;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.warrior.Shockwave;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.abilities.warrior.Endure;
import com.shatteredpixel.shatteredpixeldungeon.items.BrokenSeal;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.Waterskin;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.ClothArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.armor.PlateArmor;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.CloakOfShadows;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.HornOfPlenty;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.SandalsOfNature;
import com.shatteredpixel.shatteredpixeldungeon.items.artifacts.UnstableSpellbook;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.PotionBandolier;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.ScrollHolder;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.VelvetPouch;
import com.shatteredpixel.shatteredpixeldungeon.items.bags.MagicalHolster;
import com.shatteredpixel.shatteredpixeldungeon.items.food.Food;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfInvisibility;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfMindVision;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfStrength;
import com.shatteredpixel.shatteredpixeldungeon.items.quest.CorpseDust;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfHaste;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfEnergy;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfSharpshooting;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfFuror;
import com.shatteredpixel.shatteredpixeldungeon.items.rings.RingOfMight;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.exotic.ScrollOfEnchantment;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfLullaby;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfRage;
import com.shatteredpixel.shatteredpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.AquaBlast;
import com.shatteredpixel.shatteredpixeldungeon.items.spells.FeatherFall;
import com.shatteredpixel.shatteredpixeldungeon.items.wands.*;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.Weapon;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.enchantments.*;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.SpiritBow;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Gloves;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MagesStaff;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.Crossbow;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.AssassinsBlade;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.WornShortsword;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.WarHammer;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.darts.Dart;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.ThrowingKnife;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles.ThrowingStone;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.watabou.utils.Bundle;
import com.watabou.utils.DeviceCompat;

public enum HeroClass {

	WARRIOR( HeroSubClass.BERSERKER, HeroSubClass.GLADIATOR ),
	MAGE( HeroSubClass.BATTLEMAGE, HeroSubClass.WARLOCK ),
	ROGUE( HeroSubClass.ASSASSIN, HeroSubClass.FREERUNNER ),
	HUNTRESS( HeroSubClass.SNIPER, HeroSubClass.WARDEN );

	private HeroSubClass[] subClasses;

	HeroClass( HeroSubClass...subClasses ) {
		this.subClasses = subClasses;
	}

	public void initHero( Hero hero ) {

		hero.heroClass = this;
		Talent.initClassTalents(hero);

		Item i = new ClothArmor().identify();
		if (!Challenges.isItemBlocked(i)) hero.belongings.armor = (ClothArmor)i;

		i = new Food();
		if (!Challenges.isItemBlocked(i)) i.collect();

		new VelvetPouch().collect();
		Dungeon.LimitedDrops.VELVET_POUCH.drop();

		Waterskin waterskin = new Waterskin();
		waterskin.collect();

		new ScrollOfIdentify().identify();

		switch (this) {
			case WARRIOR:
				initWarrior( hero );
				break;

			case MAGE:
				initMage( hero );
				break;

			case ROGUE:
				initRogue( hero );
				break;

			case HUNTRESS:
				initHuntress( hero );
				break;
		}

		for (int s = 0; s < QuickSlot.SIZE; s++){
			if (Dungeon.quickslot.getItem(s) == null){
				Dungeon.quickslot.setSlot(s, waterskin);
				break;
			}
		}

	}

	public Badges.Badge masteryBadge() {
		switch (this) {
			case WARRIOR:
				return Badges.Badge.MASTERY_WARRIOR;
			case MAGE:
				return Badges.Badge.MASTERY_MAGE;
			case ROGUE:
				return Badges.Badge.MASTERY_ROGUE;
			case HUNTRESS:
				return Badges.Badge.MASTERY_HUNTRESS;
		}
		return null;
	}

	private static void initWarrior( Hero hero ) {
		startEasyMode(hero, 2);
		
		hero.belongings.weapon = (WarHammer)getWeapon("warhammer");

		ThrowingStone stones = new ThrowingStone();
		stones.quantity(10).collect();
		Dungeon.quickslot.setSlot(0, stones);
		
		PlateArmor plateArmor = new PlateArmor();
		plateArmor.identify().collect();

		if (hero.belongings.armor != null){
			hero.belongings.armor.affixSeal(new BrokenSeal());
			hero.belongings.armor.inscribe();
		}

		HornOfPlenty hornOfPlenty = new HornOfPlenty();
		(hero.belongings.artifact = hornOfPlenty).identify();
		hero.belongings.artifact.activate( hero );

		RingOfMight ringOfMight = new RingOfMight();
		(hero.belongings.ring = ringOfMight).identify();
		hero.belongings.ring.activate( hero );
		ringOfMight.upgrade();

		new PotionOfHealing().identify();
		new ScrollOfRage().identify();
	}

	private static void initMage( Hero hero ) {
		startEasyMode(hero, 1);

		MagesStaff staff = (MagesStaff)getWeapon("magesStaff");
		hero.belongings.weapon = staff;
		hero.belongings.weapon.activate(hero);
		Dungeon.quickslot.setSlot(0, staff);

		UnstableSpellbook spellbook = new UnstableSpellbook();
		(hero.belongings.artifact = spellbook).identify();
		hero.belongings.artifact.activate( hero );

		RingOfEnergy ringOfEnergy = new RingOfEnergy();
		(hero.belongings.ring = ringOfEnergy).identify();
		hero.belongings.ring.activate( hero );
		ringOfEnergy.upgrade();
		
		WandOfBlastWave wandOfBlastWave = new WandOfBlastWave();
		wandOfBlastWave.identify().collect();
		WandOfCorrosion wandOfCorrosion = new WandOfCorrosion();
		wandOfCorrosion.identify().collect();
		WandOfCorruption wandOfCorruption = new WandOfCorruption();
		wandOfCorruption.identify().collect();
		WandOfDisintegration wandOfDisintegration = new WandOfDisintegration();
		wandOfDisintegration.identify().collect();
		WandOfFireblast wandOfFireblast = new WandOfFireblast();
		wandOfFireblast.identify().collect();
		WandOfFrost wandOfFrost = new WandOfFrost();
		wandOfFrost.identify().collect();
		WandOfLightning wandOfLightning = new WandOfLightning();
		wandOfLightning.identify().collect();
		WandOfLivingEarth wandOfLivingEarth = new WandOfLivingEarth();
		wandOfLivingEarth.identify().collect();
		WandOfPrismaticLight wandOfPrismaticLight = new WandOfPrismaticLight();
		wandOfPrismaticLight.identify().collect();
		WandOfRegrowth wandOfRegrowth = new WandOfRegrowth();
		wandOfRegrowth.identify().collect();
		WandOfTransfusion wandOfTransfusion = new WandOfTransfusion();
		wandOfTransfusion.identify().collect();
		WandOfWarding wandOfWarding = new WandOfWarding();
		wandOfWarding.identify().collect();
		
		CorpseDust corpseDust = new CorpseDust();
		corpseDust.doPickUp(hero);

		AquaBlast aquaBlast = new AquaBlast();
		aquaBlast.quantity(99999).collect();

		new ScrollOfUpgrade().identify();
		new PotionOfLiquidFlame().identify();
	}

	private static void initRogue( Hero hero ) {
		startEasyMode(hero, 1);
				
		Crossbow crossbow = (Crossbow)getWeapon("crossbow");
		crossbow.doEquip(hero);

		Dart darts = new Dart();
		darts.quantity(99999).collect();

		CloakOfShadows cloak = new CloakOfShadows();
		(hero.belongings.artifact = cloak).identify();
		hero.belongings.artifact.activate( hero );


		RingOfHaste ringOfHaste = new RingOfHaste();
		(hero.belongings.ring = ringOfHaste).identify();
		hero.belongings.ring.activate( hero );
		ringOfHaste.upgrade();

		Dungeon.quickslot.setSlot(0, cloak);
		Dungeon.quickslot.setSlot(1, darts);

		new ScrollOfMagicMapping().identify();
		new PotionOfInvisibility().identify();
	}

	private static void initHuntress( Hero hero ) {
		startEasyMode(hero, 1);

		(hero.belongings.weapon = new Gloves()).identify();
		SpiritBow bow = (SpiritBow)getWeapon("spiritBow");

		SandalsOfNature sandals = new SandalsOfNature();
		(hero.belongings.artifact = sandals).identify();
		hero.belongings.artifact.activate( hero );

		RingOfSharpshooting ring = new RingOfSharpshooting();
		(hero.belongings.ring = ring).identify();
		ring.upgrade();
		hero.belongings.ring.activate( hero );

//		Crossbow crossbow = (Crossbow)getWeapon("crossbow");
//		crossbow.doEquip(hero);

//		Dart darts = new Dart();
//		darts.quantity(999999).collect();
//		Dungeon.quickslot.setSlot(1, darts);

		new PotionOfMindVision().identify();
		new ScrollOfLullaby().identify();
	}

	private static void upgradeItem(Item item, int upgradeCount) {
		for (int i = 0; i < upgradeCount ; i++) {
			item.upgrade();
		}
	}

	private static Weapon getWeapon(String weapon) {
		if (weapon == "crossbow"){
			Crossbow crossbow = new Crossbow();
			crossbow.identify().collect();
			upgradeItem(crossbow, 10);
			crossbow.enchant();
			return crossbow;
		}
		else if (weapon == "assassinsBlade"){
			AssassinsBlade assassinsBlade = new AssassinsBlade();
			assassinsBlade.identify().collect();
			upgradeItem(assassinsBlade, 10);
			assassinsBlade.enchant();
			return assassinsBlade;
		}
		else if (weapon == "magesStaff"){
			MagesStaff staff = new MagesStaff(new WandOfMagicMissile());
			staff.identify().collect();
			upgradeItem(staff, 10);
			staff.enchant();
			return staff;
		}
		else if (weapon == "warhammer"){
			WarHammer hammer = new WarHammer();
			hammer.identify().collect();
			upgradeItem(hammer, 10);
			hammer.enchant();
			return hammer;
		}
		else {
			SpiritBow bow = new SpiritBow();
			bow.identify().collect();
			bow.enchant();
			return bow;
		}
	}

	private static void startEasyMode(Hero hero, int souCount) {
		new ScrollHolder().collect();
		Dungeon.LimitedDrops.SCROLL_HOLDER.drop();

		new PotionBandolier().collect();
		Dungeon.LimitedDrops.POTION_BANDOLIER.drop();

		new MagicalHolster().collect();
		Dungeon.LimitedDrops.MAGICAL_HOLSTER.drop();

		ScrollOfUpgrade upgradeScroll = new ScrollOfUpgrade();
		upgradeScroll.quantity(souCount).collect();
		upgradeScroll.identify();
		Dungeon.quickslot.setSlot(3, upgradeScroll);

		PotionOfStrength potionOfStrength = new PotionOfStrength();
		potionOfStrength.quantity(4).collect();
		potionOfStrength.identify();
		Dungeon.quickslot.setSlot(2, potionOfStrength);

		FeatherFall featherFall = new FeatherFall();
		featherFall.quantity(4).collect();

		ScrollOfEnchantment soe = new ScrollOfEnchantment();
		soe.quantity(10).collect();
		Dungeon.quickslot.setSlot(1, upgradeScroll);
	}

	public String title() {
		return Messages.get(HeroClass.class, name());
	}

	public String desc(){
		return Messages.get(HeroClass.class, name()+"_desc");
	}

	public HeroSubClass[] subClasses() {
		return subClasses;
	}

	public ArmorAbility[] armorAbilities(){
		switch (this) {
			case WARRIOR: default:
				return new ArmorAbility[]{new HeroicLeap(), new Shockwave(), new Endure()};
			case MAGE:
				return new ArmorAbility[]{new ElementalBlast(), new WildMagic(), new WarpBeacon()};
			case ROGUE:
				return new ArmorAbility[]{new SmokeBomb(), new DeathMark(), new ShadowClone()};
			case HUNTRESS:
				return new ArmorAbility[]{new SpectralBlades(), new NaturesPower(), new SpiritHawk()};
		}
	}

	public String spritesheet() {
		switch (this) {
			case WARRIOR: default:
				return Assets.Sprites.WARRIOR;
			case MAGE:
				return Assets.Sprites.MAGE;
			case ROGUE:
				return Assets.Sprites.ROGUE;
			case HUNTRESS:
				return Assets.Sprites.HUNTRESS;
		}
	}

	public String splashArt(){
		switch (this) {
			case WARRIOR: default:
				return Assets.Splashes.WARRIOR;
			case MAGE:
				return Assets.Splashes.MAGE;
			case ROGUE:
				return Assets.Splashes.ROGUE;
			case HUNTRESS:
				return Assets.Splashes.HUNTRESS;
		}
	}
	
	public String[] perks() {
		switch (this) {
			case WARRIOR: default:
				return new String[]{
						Messages.get(HeroClass.class, "warrior_perk1"),
						Messages.get(HeroClass.class, "warrior_perk2"),
						Messages.get(HeroClass.class, "warrior_perk3"),
						Messages.get(HeroClass.class, "warrior_perk4"),
						Messages.get(HeroClass.class, "warrior_perk5"),
				};
			case MAGE:
				return new String[]{
						Messages.get(HeroClass.class, "mage_perk1"),
						Messages.get(HeroClass.class, "mage_perk2"),
						Messages.get(HeroClass.class, "mage_perk3"),
						Messages.get(HeroClass.class, "mage_perk4"),
						Messages.get(HeroClass.class, "mage_perk5"),
				};
			case ROGUE:
				return new String[]{
						Messages.get(HeroClass.class, "rogue_perk1"),
						Messages.get(HeroClass.class, "rogue_perk2"),
						Messages.get(HeroClass.class, "rogue_perk3"),
						Messages.get(HeroClass.class, "rogue_perk4"),
						Messages.get(HeroClass.class, "rogue_perk5"),
				};
			case HUNTRESS:
				return new String[]{
						Messages.get(HeroClass.class, "huntress_perk1"),
						Messages.get(HeroClass.class, "huntress_perk2"),
						Messages.get(HeroClass.class, "huntress_perk3"),
						Messages.get(HeroClass.class, "huntress_perk4"),
						Messages.get(HeroClass.class, "huntress_perk5"),
				};
		}
	}
	
	public boolean isUnlocked(){
		//always unlock on debug builds
		if (DeviceCompat.isDebug()) return true;
		
		switch (this){
			case WARRIOR: default:
				return true;
			case MAGE:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_MAGE);
			case ROGUE:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_ROGUE);
			case HUNTRESS:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_HUNTRESS);
		}
	}
	
	public String unlockMsg() {
		switch (this){
			case WARRIOR: default:
				return "";
			case MAGE:
				return Messages.get(HeroClass.class, "mage_unlock");
			case ROGUE:
				return Messages.get(HeroClass.class, "rogue_unlock");
			case HUNTRESS:
				return Messages.get(HeroClass.class, "huntress_unlock");
		}
	}

}
