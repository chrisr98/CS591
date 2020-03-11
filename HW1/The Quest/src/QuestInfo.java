import java.util.ArrayList;

public class QuestInfo {
	
	public static ArrayList<String[]> Armory = new ArrayList<String[]>();
	public static ArrayList<String[]> Dragons = new ArrayList<String[]>();
	public static ArrayList<String[]> Exoskeletons = new ArrayList<String[]>();
	public static ArrayList<String[]> FireSpells = new ArrayList<String[]>();
	public static ArrayList<String[]> IceSpells = new ArrayList<String[]>();
	public static ArrayList<String[]> LightningSpells = new ArrayList<String[]>();
	public static ArrayList<String[]> Paladins = new ArrayList<String[]>();
	public static ArrayList<String[]> Potions = new ArrayList<String[]>();
	public static ArrayList<String[]> Sorcerers = new ArrayList<String[]>();
	public static ArrayList<String[]> Spirits = new ArrayList<String[]>();
	public static ArrayList<String[]> Warriors = new ArrayList<String[]>();
	public static ArrayList<String[]> Weaponry = new ArrayList<String[]>();
	
	

	public QuestInfo() {
		// TODO Auto-generated constructor stub
		
		// Add Armory Items
		//Name/cost/required level/damage reduction
		String[] Platinum_Shield = {"Platinum_Shield", "150", "1", "200"};
		String[] Breastplate = {"Breastplate", "350", "3", "600"};
		String[] Full_Body_Armor = {"Full_Body_Armor", "1000", "8", "1100"};
		String[] Wizard_Shield = {"Wizard_Shield", "1200", "10", "1500"};
		String[] Speed_Boots = {"Speed_Boots", "550", "4", "600"};
		
		Armory.add(Platinum_Shield);
		Armory.add(Breastplate);
		Armory.add(Full_Body_Armor);
		Armory.add(Wizard_Shield);
		Armory.add(Speed_Boots);
		
		// Add Dragons Items
		//Name/level/damage/defense/dodge chance
		String[] Desghidorrah = {"Desghidorrah", "3", "300", "400", "35"};
		String[] Chrysophylax = {"Chrysophylax", "2", "200", "500", "20"};
		String[] BunsenBurner = {"BunsenBurner", "4", "400", "500", "45"};
		String[] Natsunomeryu = {"Natsunomeryu", "1", "100", "200", "10"};
		String[] TheScaleless = {"TheScaleless", "7", "700", "600", "75"};
		String[] Kas_Ethelinh = {"Kas-Ethelinh", "5", "600", "500", "60"};
		String[] Alexstraszan = {"Alexstraszan", "10", "1000", "9000", "55"};
		String[] Phaarthurnax = {"Phaarthurnax", "6", "600", "700", "60"};
		String[] D_Maleficent = {"D-Maleficent", "9", "900", "950", "85"};
		String[] TheWeatherbe = {"TheWeatherbe", "8", "800", "900", "80"};
		
		Dragons.add(Desghidorrah);
		Dragons.add(Chrysophylax);
		Dragons.add(BunsenBurner);
		Dragons.add(Natsunomeryu);
		Dragons.add(TheScaleless);
		Dragons.add(Kas_Ethelinh);
		Dragons.add(Alexstraszan);
		Dragons.add(Phaarthurnax);
		Dragons.add(D_Maleficent);
		Dragons.add(TheWeatherbe);
		
		// Add Exoskeletons Items
		//Name/level/damage/defense/dodge chance
		String[] Cyrrollalee = {"Cyrrollalee", "7", "700", "800", "75"};
		String[] Brandobaris = {"Brandobaris", "3", "350", "450", "30"};
		String[] BigBad_Wolf = {"BigBad-Wolf", "1", "150", "250", "15"};
		String[] WickedWitch = {"WickedWitch", "2", "250", "350", "25"};
		String[] Aasterinian = {"Aasterinian", "4", "400", "500", "45"};
		String[] Chronepsish = {"Chronepsish", "6", "650", "750", "60"};
		String[] Kiaransalee = {"Kiaransalee", "8", "850", "950", "85"};
		String[] St_Shargaas = {"St-Shargaas", "5", "550", "650", "55"};
		String[] Merrshaullk = {"Merrshaullk", "10", "1000", "900", "55"};
		String[] St_Yeenoghu = {"St-Yeenoghu", "9", "950", "850", "90"};
		
		Exoskeletons.add(Cyrrollalee);
		Exoskeletons.add(Brandobaris);
		Exoskeletons.add(BigBad_Wolf);
		Exoskeletons.add(WickedWitch);
		Exoskeletons.add(Aasterinian);
		Exoskeletons.add(Chronepsish);
		Exoskeletons.add(Kiaransalee);
		Exoskeletons.add(St_Shargaas);
		Exoskeletons.add(Merrshaullk);
		Exoskeletons.add(St_Yeenoghu);

		// Add FireSpells
		//Name/cost/required level/damage/mana cost
		String[] Flame_Tornado = {"Flame_Tornado", "700", "4", "850", "300"};
		String[] Breath_of_Fire = {"Breath_of_Fire", "350", "1", "450", "100"};
		String[] Heat_Wave = {"Heat_Wave", "450", "2", "600", "150"};
		String[] Lava_Commet = {"Lava_Commet", "800", "7", "1000", "550"};
		
		FireSpells.add(Flame_Tornado);
		FireSpells.add(Breath_of_Fire);
		FireSpells.add(Heat_Wave);
		FireSpells.add(Lava_Commet);
		
		// Add IceSpells
		String[] Snow_Canon = {"Snow_Canon", "500", "2", "650", "250"};
		String[] Ice_Blade = {"Ice_Blade", "250", "1", "450", "100"};
		String[] Frost_Blizzard = {"Frost_Blizzard", "750", "5", "850", "350"};
		String[] Arctic_storm = {"Arctic_storm", "700", "6", "800", "300"};
		
		IceSpells.add(Snow_Canon);
		IceSpells.add(Ice_Blade);
		IceSpells.add(Frost_Blizzard);
		IceSpells.add(Arctic_storm);

		// Add LightningSpells
		String[] LightningDagger = {"LightningDagger", "400", "1", "500", "150"};
		String[] Thunder_Blast = {"Thunder_Blast", "750", "4", "950", "400"};
		String[] Electric_Arrows = {"Electric_Arrows", "550", "5", "650", "200"};
		String[] Spark_Needles = {"Spark_Needles", "500", "2", "600", "200"};
		
		LightningSpells.add(LightningDagger);
		LightningSpells.add(Thunder_Blast);
		LightningSpells.add(Electric_Arrows);
		LightningSpells.add(Spark_Needles);
		
		// Add Paladins
		//Name/mana/strength/agility/dexterity/starting money/starting experience
		String[] Solonor_Thelandira = {"Solonor_Thelandira", "300", "750", "650", "700", "2500", "7"};
		String[] Sehanine_Moonbow = {"Sehanine_Moonbow", "300", "750", "700", "700", "2500", "7"};
		String[] Skoraeus_Stonebones = {"Skoraeus_Stonebones", "250", "650", "600", "350", "2500", "4"};
		String[] Garl_Glittergold = {"Garl_Glittergold", "100", "600", "500", "400", "2500", "5"};
		 
		Paladins.add(Solonor_Thelandira);
		Paladins.add(Sehanine_Moonbow);
		Paladins.add(Skoraeus_Stonebones);
		Paladins.add(Garl_Glittergold);
		
		// Add Potions
		//Name/cost/required level/attribute increase
		String[] Healing_Potion = {"Healing_Potion", "250", "1", "100"};
		String[] Strength_Potion = {"Strength_Potion", "200", "1", "75"};
		String[] Magic_Potion = {"Magic_Potion", "350", "2", "100"};
		String[] Luck_Elixir = {"Luck_Elixir", "500", "4", "65"};
		String[] Mermaid_Tears = {"Mermaid_Tears", "850", "5", "100"};
		String[] Ambrosia= {"Ambrosia", "1000", "8", "150"};
		
		Potions.add(Healing_Potion);
		Potions.add(Strength_Potion);
		Potions.add(Magic_Potion);
		Potions.add(Luck_Elixir);
		Potions.add(Mermaid_Tears);
		Potions.add(Ambrosia);
		
		// Add Sorcerers
		//Name/mana/strength/agility/dexterity/starting money/starting experience
		String[] Ryan_Glittergold = {"Ryan_Glittergold", "700", "550", "600", "500", "2500", "7"};
		String[] Rillifane_Rallathil = {"Rillifane_Rallathil", "1300", "750", "450", "500", "2500", "9"};
		String[] Segojan_Earthcaller = {"Segojan_Earthcaller", "900", "800", "500", "650", "2500", "5"};
		String[] Skors_Stones = {"Skors_Stones", "800", "850", "600", "450", "2500", "6"};
		
		Sorcerers.add(Ryan_Glittergold);
		Sorcerers.add(Rillifane_Rallathil);
		Sorcerers.add(Segojan_Earthcaller);
		Sorcerers.add(Skors_Stones);
		
		// Add Spirits
		//Name/level/damage/defense/dodge chance
		String[] Andrealphus = {"Andrealphus", "2", "600", "500", "40"};
		String[] Aim_Haborym = {"Aim-Haborym", "1", "450", "350", "35"};
		String[] Andromalius = {"Andromalius", "3", "550", "450", "25"};
		String[] Chiang_shih = {"Chiang-shih", "4", "700", "600", "40"};
		String[] FallenAngel = {"FallenAngel", "5", "800", "700", "50"};
		String[] Ereshkigall = {"Ereshkigall", "6", "950", "450", "35"};
		String[] Melchiresas = {"Melchiresas", "7", "350", "150", "75"};
		String[] Jormunngand = {"Jormunngand", "8", "600", "900", "20"};
		String[] Rakkshasass = {"Rakkshasass", "9", "550", "600", "35"};
		String[] Taltecuhtli = {"Taltecuhtli", "10", "300", "200", "50"};
		
		Spirits.add(Andrealphus);
		Spirits.add(Aim_Haborym);
		Spirits.add(Andromalius);
		Spirits.add(Chiang_shih);
		Spirits.add(FallenAngel);
		Spirits.add(Ereshkigall);
		Spirits.add(Melchiresas);
		Spirits.add(Jormunngand);
		Spirits.add(Rakkshasass);
		Spirits.add(Taltecuhtli);
		
		// Add Warriors
		//Name/mana/strength/agility/dexterity/starting money/starting experience
		String[] Gaerdal_Ironhand = {"Gaerdal_Ironhand", "100", "700", "500", "600", "1354", "7"};
		String[] Sejuaine_Monnbow = {"Sejuaine_Monnbow", "600", "700", "800", "500", "2500", "8"};
		String[] Muamman_Duathall = {"Muamman_Duathall", "300", "900", "500", "750", "2546", "6"};
		String[] Flandal_Steelskin = {"Flandal_Steelskin", "200", "750", "650", "700", "2500", "7"};
		
		Warriors.add(Gaerdal_Ironhand);
		Warriors.add(Sejuaine_Monnbow);
		Warriors.add(Muamman_Duathall);
		Warriors.add(Flandal_Steelskin);
		
		// Add Weaponry
		//Name/cost/level/damage/required hands
		String[] Sword = {"Sword", "500", "1", "800", "1"};
		String[] Bow = {"Bow", "300", "2", "500", "2"};
		String[] Scythe = {"Scythe", "1000", "6", "1100", "2"};
		String[] Axe = {"Axe", "550", "5", "850", "1"};
		String[] Shield = {"Shield", "400", "1", "100", "1"};
		String[] TSwords = {"TSwords", "1400", "8", "1600", "2"};
		String[] Dagger = {"Dagger", "200", "1", "250", "1"};
		
		Weaponry.add(Sword);
		Weaponry.add(Bow);
		Weaponry.add(Scythe);
		Weaponry.add(Axe);
		Weaponry.add(Shield);
		Weaponry.add(TSwords);
		Weaponry.add(Dagger);
		
	}

	
	public void printArmory() {
		//Name/cost/required level/damage reduction
		System.out.println("\nChoose an armor, enter the number corresponding to the hero");
		for (int i = 0; i < Armory.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %n", Armory.get(i)[0], Armory.get(i)[1], Armory.get(i)[2], Armory.get(i)[3]);
		}
	}
	
	public String[] getArmor(int i) {
		System.out.printf("%s: %s %s %s %n", Armory.get(i)[0], Armory.get(i)[1], Armory.get(i)[2], Armory.get(i)[3]);
		return Armory.get(i);
	}
	
	public int getArmorySize() {
		return Armory.size();
	}
	
	public void printDragons() {
		//Name/level/damage/defense/dodge chance
		System.out.println("\nChoose a dragon, enter the number corresponding to the hero");
		for (int i = 0; i < Dragons.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %n", Dragons.get(i)[0], Dragons.get(i)[1], Dragons.get(i)[2], Dragons.get(i)[3], Dragons.get(i)[4]);
		}
	}
	
	public String[] getDragon(int i) {
		System.out.printf("%s: %s %s %s %s %n", Dragons.get(i)[0], Dragons.get(i)[1], Dragons.get(i)[2], Dragons.get(i)[3], Dragons.get(i)[4]);
		return Dragons.get(i);
	}
	
	public int getDragonsSize() {
		return Dragons.size();
	}

	public void printExoskeletons() {
		//Name/level/damage/defense/dodge chance
		System.out.println("\nChoose an exoskeleton, enter the number corresponding to the hero");
		for (int i = 0; i < Exoskeletons.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %n", Exoskeletons.get(i)[0], Exoskeletons.get(i)[1], Exoskeletons.get(i)[2], Exoskeletons.get(i)[3], Exoskeletons.get(i)[4]);
		}
	}
	
	public String[] getExoskeleton(int i) {
		System.out.printf("%s: %s %s %s %s %n", Exoskeletons.get(i)[0], Exoskeletons.get(i)[1], Exoskeletons.get(i)[2], Exoskeletons.get(i)[3], Exoskeletons.get(i)[4]);
		return Exoskeletons.get(i);
	}
	
	public int getExoskeletonsSize() {
		return Exoskeletons.size();
	}
	
	public void printFireSpells() {
		//Name/cost/required level/damage/mana cost
		System.out.println("\nChoose a fire spell, enter the number corresponding to the hero");
		for (int i = 0; i < FireSpells.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %n", FireSpells.get(i)[0], FireSpells.get(i)[1], FireSpells.get(i)[2], FireSpells.get(i)[3], FireSpells.get(i)[4]);
		}
	}
	
	public String[] getFireSpell(int i) {
		System.out.printf("%s: %s %s %s %s %n", FireSpells.get(i)[0], FireSpells.get(i)[1], FireSpells.get(i)[2], FireSpells.get(i)[3], FireSpells.get(i)[4]);
		return FireSpells.get(i);
	}
	
	public int getFireSpellsSize() {
		return FireSpells.size();
	}

	public void printIceSpells() {
		System.out.println("\nChoose an ice spell, enter the number corresponding to the hero");
		for (int i = 0; i < IceSpells.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %n", IceSpells.get(i)[0], IceSpells.get(i)[1], IceSpells.get(i)[2], IceSpells.get(i)[3], IceSpells.get(i)[4]);
		}
	}
	
	public String[] getIceSpell(int i) {
		System.out.printf("%s: %s %s %s %s %n", IceSpells.get(i)[0], IceSpells.get(i)[1], IceSpells.get(i)[2], IceSpells.get(i)[3], IceSpells.get(i)[4]);
		return IceSpells.get(i);
	}
	
	public int getIceSpellsSize() {
		return IceSpells.size();
	}
	
	public void printLightningSpells() {
		System.out.println("\nChoose a lightning spell, enter the number corresponding to the hero");
		for (int i = 0; i < LightningSpells.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %n", LightningSpells.get(i)[0], LightningSpells.get(i)[1], LightningSpells.get(i)[2], LightningSpells.get(i)[3], LightningSpells.get(i)[4]);
		}
	}
	
	public String[] getLightningSpell(int i) {
		System.out.printf("%s: %s %s %s %s %n", LightningSpells.get(i)[0], LightningSpells.get(i)[1], LightningSpells.get(i)[2], LightningSpells.get(i)[3], LightningSpells.get(i)[4]);
		return LightningSpells.get(i);
	}
	
	public int getLightningSpellsSize() {
		return LightningSpells.size();
	}
	
	public void printPaladins() {
		System.out.println("\nChoose a paladin, enter the number corresponding to the hero");
		for (int i = 0; i < Paladins.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %s %s %n", Paladins.get(i)[0], Paladins.get(i)[1], Paladins.get(i)[2], Paladins.get(i)[3], Paladins.get(i)[4], Paladins.get(i)[5], Paladins.get(i)[6]);
		}
	}
	
	public String[] getPaladins(int i) {
		System.out.printf("%s: %s %s %s %s %s %s %n", Paladins.get(i)[0], Paladins.get(i)[1], Paladins.get(i)[2], Paladins.get(i)[3], Paladins.get(i)[4], Paladins.get(i)[5], Paladins.get(i)[6]);
		return Paladins.get(i);
	}
	
	public int getPaladinsSize() {
		return Paladins.size();
	}
	
	public void printPotions() {
		//Name/cost/required level/attribute increase
		System.out.println("\nChoose a potion, enter the number corresponding to the hero");
		for (int i = 0; i < Potions.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %n", Potions.get(i)[0], Potions.get(i)[1], Potions.get(i)[2], Potions.get(i)[3]);
		}
	}
	
	public String[] getPotion(int i) {
		System.out.printf("%s: %s %s %s %n", Potions.get(i)[0], Potions.get(i)[1], Potions.get(i)[2], Potions.get(i)[3]);
		return Potions.get(i);
	}
	
	public int getPotionsSize() {
		return Potions.size();
	}
	
	public void printSorcerers() {
		System.out.println("\nChoose a sorcerer, enter the number corresponding to the hero");
		for (int i = 0; i < Sorcerers.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %s %s %n", Sorcerers.get(i)[0], Sorcerers.get(i)[1], Sorcerers.get(i)[2], Sorcerers.get(i)[3], Sorcerers.get(i)[4], Sorcerers.get(i)[5], Sorcerers.get(i)[6]);
		}
	}
	
	public String[] getSorcerer(int i) {
		System.out.printf("%s: %s %s %s %s %s %s %n", Sorcerers.get(i)[0], Sorcerers.get(i)[1], Sorcerers.get(i)[2], Sorcerers.get(i)[3], Sorcerers.get(i)[4], Sorcerers.get(i)[5], Sorcerers.get(i)[6]);
		return Sorcerers.get(i);
	}
	
	public int getSorcerersSize() {
		return Sorcerers.size();
	}
	
	public void printSpirits() {
		//Name/level/damage/defense/dodge chance
		System.out.println("\nChoose a spirit, enter the number corresponding to the hero");
		for (int i = 0; i < Spirits.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %n", Spirits.get(i)[0], Spirits.get(i)[1], Spirits.get(i)[2], Spirits.get(i)[3], Spirits.get(i)[4]);
		}
	}
	
	public String[] getSpirit(int i) {
		System.out.printf("%s: %s %s %s %s %n", Spirits.get(i)[0], Spirits.get(i)[1], Spirits.get(i)[2], Spirits.get(i)[3], Spirits.get(i)[4]);
		return Spirits.get(i);
	}
	
	public int getSpiritsSize() {
		return Spirits.size();
	}
	
	public void printWarriors() {
		System.out.println("\nChoose a warrior, enter the number corresponding to the hero");
		for (int i = 0; i < Warriors.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %s %s %n", Warriors.get(i)[0], Warriors.get(i)[1], Warriors.get(i)[2], Warriors.get(i)[3], Warriors.get(i)[4], Warriors.get(i)[5], Warriors.get(i)[6]);
		}
	}
	
	public String[] getWarrior(int i) {
		System.out.printf("%s: %s %s %s %s %s %s %n", Warriors.get(i)[0], Warriors.get(i)[1], Warriors.get(i)[2], Warriors.get(i)[3], Warriors.get(i)[4], Warriors.get(i)[5], Warriors.get(i)[6]);
		return Warriors.get(i);
	}
	
	public int getWarriorsSize() {
		return Warriors.size();
	}
	
	public void printWeaponry() {
		//Name/cost/level/damage/required hands
		System.out.println("\nChoose a weapon, enter the number corresponding to the hero");
		for (int i = 0; i < Weaponry.size(); i++) {
			System.out.print(i+1 + " --> ");
			System.out.printf("%s: %s %s %s %s %n", Weaponry.get(i)[0], Weaponry.get(i)[1], Weaponry.get(i)[2], Weaponry.get(i)[3], Weaponry.get(i)[4]);
		}
	}
	
	public String[] getWeapon(int i) {
		System.out.printf("%s: %s %s %s %s %n", Weaponry.get(i)[0], Weaponry.get(i)[1], Weaponry.get(i)[2], Weaponry.get(i)[3], Weaponry.get(i)[4]);
		return Weaponry.get(i);
	}
	
	public int getWeaponrySize() {
		return Weaponry.size();
	}
	
	
	
	
	
	
}
