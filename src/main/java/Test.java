import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Test {

	static Logger log = Logger.getLogger(Test.class);

	public static void main(String[] args) {

//		BasicConfigurator.configure();
		log.info("info");
		log.warn("warn");

	}
}
