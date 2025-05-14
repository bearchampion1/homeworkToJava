package BMI;
import java.util.Scanner;
public class BMI_System {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float BMIvalue;
		float argheight = Float.parseFloat(args[1]);//convert argument type from string to float
		int argweight = Integer.parseInt(args[2]);//convert argument type from string to integer
		User example = new User(args[0],argheight, argweight);//call class and input argument prompt
		System.out.println("plese input your name:");
		String username = scan.next();//string input
		System.out.println("plese input your weight(kg):");
		int userweight = scan.nextInt();
		System.out.println("plese input your height(cm):");
		float userheight = scan.nextFloat();
		User user =new User(username, userheight , userweight);
		BMIvalue = BMI_operate(example.getWeight(),example.getHeight());
		System.out.println("user name is:"+example.getName());//print argument_name
		System.out.println("user weight is:"+example.getWeight()+ "kg");//print argument_weight
		System.out.println("user height is:"+example.getHeight()+ "cm");//print argument_height
		System.out.printf("user BMI is:%.2f\n",BMIvalue);//print argument_BMI
		divider();
		BMIvalue = BMI_operate(user.getWeight(),user.getHeight());
		System.out.println("user name is:"+user.getName());//print argument_name
		System.out.println("user weight is:"+user.getWeight()+ "kg");//print argument_weight
		System.out.println("user height is:"+user.getHeight()+ "cm");//print argument_height
		System.out.printf("user BMI is:%.2f\n",BMIvalue);//print argument_BMI
		divider();
		System.out.printf("Input user1 new weight :\n");//print argument_weight
		userweight = scan.nextInt() ;
		User user_new_detail = new User(username, userheight, userweight);
		BMIvalue = BMI_operate(user_new_detail.getWeight(),user.getHeight());//BMI計算
		System.out.println("user name is:"+user_new_detail.getName());//print argument_name
		System.out.println("user weight is:"+user_new_detail.getWeight()+ "kg");//print argument_weight
		System.out.println("user height is:"+user_new_detail.getHeight()+ "cm");//print argument_height
		System.out.printf("user BMI is:%.2f\n",BMIvalue);//print argument_BMI
		scan.close();
}
	public static void divider() {
		for (int i = 0; i<20 ; i++) {//print "-*20"
			
			if( i == 19){
				System.out.println("-");
				break;
			}
			System.out.print("-");
		}
	}
	public static float BMI_operate(int weight , float height) {//operate BMI
		float BMI;
		height = height/100;
		BMI = (float)weight /(height*height);
		return BMI;
	}
}
