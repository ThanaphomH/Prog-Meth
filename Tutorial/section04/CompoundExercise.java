
public class CompoundExercise {

	public static void main(String[] args) {
		int x = 1;
		x = x + 1;
		System.out.println(x); //2

		x += 1; //3
		System.out.println(x); //3
		System.out.println(++x); //4
		System.out.println(x++); //4 x -> 5
		System.out.println(x); //5

		int y = x++ + 0; //5 x->6
		System.out.println(x + "," + y); //11

		double z = ++x + 0.0;//x->7 7.0
		System.out.println(x + "," + z); //7,7.0

        String s = x + "1" + z; //717.0
		System.out.println(s);
		System.out.println(x + "," + y + "," + z); //7,5,7.0

		x /= (x - 7); //0
		System.out.println(x);

	}

}
