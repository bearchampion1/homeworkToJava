package BMI;
 
public class User {
	
		private String name; //使用者名字
		private float height;//使用者身高
		private int weight;//使用者體重
		public User(String name, float height, int weight) {
			this.name = name;
			this.height = height;
			this.weight = weight;
		}
		public String getName() {
			return name;
		}
		public float getHeight() {
			return height;
		}
		public int getWeight() {
			return weight;
		}
		
}
