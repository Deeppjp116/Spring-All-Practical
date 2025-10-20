package pk1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        System.out.println("Singleton Scope:");
        MyBean singleton1 = (MyBean) context.getBean("singletonBean");
        MyBean singleton2 = (MyBean) context.getBean("singletonBean");
        System.out.println("singleton1 == singleton2? " + (singleton1 == singleton2));

        System.out.println("\nPrototype Scope:");
        MyBean prototype1 = (MyBean) context.getBean("prototypeBean");
        MyBean prototype2 = (MyBean) context.getBean("prototypeBean");
        System.out.println("prototype1 == prototype2? " + (prototype1 == prototype2));
    }
}
