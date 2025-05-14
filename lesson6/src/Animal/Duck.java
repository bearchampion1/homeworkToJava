package Animal;

public class Duck extends Chicken {
	private String webbing ; 
	
	public Duck() {
		super();
	}
	public Duck(String name , String webbing) {
		super(name, webbing);
		this.webbing = webbing;
	}
	
	public String getWebbing() {
		return webbing;
	}
	public void  setWebbing(String webbing) {
		this.webbing = webbing;
	}
	public void swim() {
		System.out.println("游泳");
	}
	@Override
	public void wu() {
		System.out.println("阿~ 阿~");
	}
	@Override
	public void fly() {
		System.out.println("會飛");
	}
	
}
