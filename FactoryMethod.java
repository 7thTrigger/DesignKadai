public class Client {	//Clientクラス
	public static void main(String[] args) {
		Koujyou koujyou1 = new TvKoujyou();
		Koujyou koujyou2 = new RadioKoujyou();

		Seihin[] array = new Seihin[3];
		array[0] = koujyou1.create();	//工場１
		array[1] = koujyou2.create();	//工場２
		array[2] = koujyou1.create();	//工場３

		for (int i = 0; i < array.length; ++i) {
			array[i].print();
		}
	}
}

abstract class Koujyou {	//工場クラス
	public final Seihin create() {
		Seihin seihin = factoryMethod(); touroku(seihin);	//製品を登録する
		return seihin;
	}
	public abstract Seihin factoryMethod();
	public abstract void touroku(Seihin s);
}

class TvKoujyou extends Koujyou {	//テレビを作るクラス
	public Seihin factoryMethod() {
		return new Television();	//newテレビを返す
	}
	public void touroku(Seihin s) {
		Television t = (Television) s;
		t.numberring();
		t.setDate(Date.today());	//日付を入力
	}
}

class RadioKoujyou extends Koujyou {	//ラジオを作るクラス
	public Seihin factoryMethod() {
		return new Radio();	//newラジオを返す
	}
	public void touroku(Seihin s) {
		Radio r = (Radio) s;
		r.numberring();
	}
}

abstract class Seihin {	//製品クラス
	public abstract void print();
}

class Television extends Seihin {
	private int tvSerialNumber;
	private String date;

	public void numberring() {	//ナンバリングをする
		tvSerialNumber = Counter.getTvNumber();
	}

	public void setDate(String date) {
		this.date = date;
	}

public void print() {
	System.out.println("このテレビに関する情報:");
	System.out.println(" 製造番号:" + tvSerialNumber);
	System.out.println(" 製造年月日:" + date);
	}
}

class Radio extends Seihin {	//ラジオ製品に情報を追加する
	private int radioSerialNumber;

	public void numberring() {
		radioSerialNumber = Counter.getRadioNumber();
	}
	public void print() {
		System.out.println("このラジオに関する情報:");
		System.out.println(" 製造番号:" + radioSerialNumber);
	}
}

class Date {
	public static String today() {
		return "2004/01/20";
	}
}
class Counter {
	private static int tvNum = 100;
	private static int radioNum = 76;

	public static int getTvNumber() {
		return tvNum++;
	}

	public static int getRadioNumber() {
		return radioNum++;
	}
}