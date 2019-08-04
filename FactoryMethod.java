public class Client {	//Client�N���X
	public static void main(String[] args) {
		Koujyou koujyou1 = new TvKoujyou();
		Koujyou koujyou2 = new RadioKoujyou();

		Seihin[] array = new Seihin[3];
		array[0] = koujyou1.create();	//�H��P
		array[1] = koujyou2.create();	//�H��Q
		array[2] = koujyou1.create();	//�H��R

		for (int i = 0; i < array.length; ++i) {
			array[i].print();
		}
	}
}

abstract class Koujyou {	//�H��N���X
	public final Seihin create() {
		Seihin seihin = factoryMethod(); touroku(seihin);	//���i��o�^����
		return seihin;
	}
	public abstract Seihin factoryMethod();
	public abstract void touroku(Seihin s);
}

class TvKoujyou extends Koujyou {	//�e���r�����N���X
	public Seihin factoryMethod() {
		return new Television();	//new�e���r��Ԃ�
	}
	public void touroku(Seihin s) {
		Television t = (Television) s;
		t.numberring();
		t.setDate(Date.today());	//���t�����
	}
}

class RadioKoujyou extends Koujyou {	//���W�I�����N���X
	public Seihin factoryMethod() {
		return new Radio();	//new���W�I��Ԃ�
	}
	public void touroku(Seihin s) {
		Radio r = (Radio) s;
		r.numberring();
	}
}

abstract class Seihin {	//���i�N���X
	public abstract void print();
}

class Television extends Seihin {
	private int tvSerialNumber;
	private String date;

	public void numberring() {	//�i���o�����O������
		tvSerialNumber = Counter.getTvNumber();
	}

	public void setDate(String date) {
		this.date = date;
	}

public void print() {
	System.out.println("���̃e���r�Ɋւ�����:");
	System.out.println(" �����ԍ�:" + tvSerialNumber);
	System.out.println(" �����N����:" + date);
	}
}

class Radio extends Seihin {	//���W�I���i�ɏ���ǉ�����
	private int radioSerialNumber;

	public void numberring() {
		radioSerialNumber = Counter.getRadioNumber();
	}
	public void print() {
		System.out.println("���̃��W�I�Ɋւ�����:");
		System.out.println(" �����ԍ�:" + radioSerialNumber);
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