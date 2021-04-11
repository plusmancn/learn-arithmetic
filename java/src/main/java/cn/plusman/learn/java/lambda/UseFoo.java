package cn.plusman.learn.java.lambda;

import java.util.function.Function;

/**
 * @author plusman
 * @since 2021/4/5 5:08 PM
 */
public class UseFoo {
    private String value = "Enclosing scope value";
    
   
    public void sayHello() {
        System.out.println("hello from UseFoo");
    }
    
    public String scopeExperiment() {
        final Foo fooIC = new Foo() {
            String value = "Inner class value";
            
            @Override
            public String method(final String string) {
                return value;
            }
        };
        final String resultIC = fooIC.method("");
        
        final Foo fooLambda = parameter -> {
            final String value = "Lambda value";
            System.out.println("lambda invoke");
            return this.value;
        };
        final String resultLambda = fooLambda.method("");
        
        return "Results: resultIC = " + resultIC + ", resultLambda = " + resultLambda;
    }
    
    public static void main(String[] args) {
        UseFoo useFoo = new UseFoo();
        String result = useFoo.scopeExperiment();
        System.out.println(result);
    }
    
}
