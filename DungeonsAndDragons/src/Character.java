import java.util.ArrayList;

public class Character {

	// the meat
	private int level, ac, initiative, speed, HPMax, HPCurrent, HPTemporary;
	private int hitDiceLeft, deathSavesSuccess, deathSavesFail, proficiencyBonus;
	private int strengthTotal, strengthBonus, dexterityTotal, dexterityBonus;
	private int constitutionTotal, constitutionBonus, intelligenceTotal;
	private int intelligenceBonus, wisdomTotal, wisdomBonus, charismaTotal;
	private int charismaBonus, passivePerception, cantrips, spellSlotsFirst;
	private int spellSlotsSecond, spellSlotsThird, spellSlotsFourth;
	private int spellSlotsFifth, spellSlotsSixth, spellSlotsSeventh;
	private int spellSlotsEighth, copper, silver, gold, platinum;
	private ArrayList<String> traits, proficiencies, equipment, weapons, spells;
	private String background, alignment, hitDiceType, race;

	// constructors
	// empty constructor
	Character() {
	}

	// constructor using necessities
	Character(int levelIn, int HPMaxIn, int strengthTotalIn,
			int dexterityTotalIn, int constitutionTotalIn, int intelligenceTotalIn,
			int wisdomTotalIn, int charismaTotalIn, String backgroundIn,
			String alignmentIn) {

		// set the inputs
		level = levelIn;
		HPMax = HPMaxIn;
		strengthTotal = strengthTotalIn;
		dexterityTotal = dexterityTotalIn;
		constitutionTotal = constitutionTotalIn;
		intelligenceTotal = intelligenceTotalIn;
		wisdomTotal = wisdomTotalIn;
		charismaTotal = charismaTotalIn;
		background = backgroundIn;
		alignment = alignmentIn;
		HPCurrent = HPMaxIn;
		hitDiceLeft = levelIn;

		// set the zeros
		HPTemporary = 0;
		deathSavesFail = 0;
		deathSavesSuccess = 0;
		copper = 0;
		silver = 0;
		gold = 0;
		platinum = 0;
		speed = 0;
		cantrips = 0;
		spellSlotsFirst = 0;
		spellSlotsSecond = 0;
		spellSlotsThird = 0;
		spellSlotsFourth = 0;
		spellSlotsFifth = 0;
		spellSlotsSixth = 0;
		spellSlotsSeventh = 0;
		spellSlotsEighth = 0;
		traits = new ArrayList<>();
		proficiencies = new ArrayList<>();
		equipment = new ArrayList<>();
		weapons = new ArrayList<>();
		spells = new ArrayList<>();
		hitDiceType = "";

		// set the bonuses using calculateBonus()
		strengthBonus = Functions.calculateBonus(strengthTotal);
		dexterityBonus = Functions.calculateBonus(dexterityTotal);
		constitutionBonus = Functions.calculateBonus(constitutionTotal);
		intelligenceBonus = Functions.calculateBonus(intelligenceTotal);
		wisdomBonus = Functions.calculateBonus(wisdomTotal);
		charismaBonus = Functions.calculateBonus(charismaTotal);
		initiative = dexterityBonus;

		//natural ac
		ac = 10 + dexterityBonus;
	}

	// setters
	public void setHPTemporary(int health) {HPTemporary = health;}
	public void setDeathSavesSuccess(int save) {deathSavesSuccess = save;}
	public void setDeathSavesFail(int save) {deathSavesFail = save;}
	public void setCopper(int mon) {copper = mon;}
	public void setSilver(int mon) {silver = mon;}
	public void setGold(int mon) {gold = mon;}
	public void setPlatinum(int mon) {platinum = mon;}
	public void setSpeed(int sp) {speed = sp;}
	public void setCantrips(int sp) {cantrips = sp;}
	public void setSpellSlotsFirst(int sp) {spellSlotsFirst = sp;}
	public void setSpellSlotsSecond(int sp) {spellSlotsSecond = sp;}
	public void setSpellSlotsThird(int sp) {spellSlotsThird = sp;}
	public void setSpellSlotsFourth(int sp) {spellSlotsFourth = sp;}
	public void setSpellSlotsFifth(int sp) {spellSlotsFifth = sp;}
	public void setSpellSlotsSixth(int sp) {spellSlotsSixth = sp;}
	public void setSpellSlotsSeventh(int sp) {spellSlotsSeventh = sp;}
	public void setSpellSlotsEighth(int sp) {spellSlotsEighth = sp;}

	// getters
	public ArrayList<String> getTraits() {return this.traits;}

	//adders
	public void addTrait(String input) {traits.add(input);}
	public void addProficiencies(String input) {proficiencies.add(input);}
	public void addEquipment(String input) {equipment.add(input);}
	public void addWeapons(String input) {weapons.add(input);}
	public void addSpells(String input) {spells.add(input);}
}
