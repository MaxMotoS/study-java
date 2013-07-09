import ru.mts.admsk.mvsereb3;

public class PackageTest {
	public static void main(String[] args) {
		System.out.println("Package Hello");
		ClassPathTest cp = new ClassPathTest();
		System.out.println(cp.name);
	}
}