package cn.plusman.learn.java.enumdemo;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author plusman
 * @since 2021/7/3 10:27 AM
 */
enum Operation {
    /**
     * ADD
     */
    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
           return  x - y; 
        }
    };
    
    private final String symbol;
    
    Operation(String symbol) {
        this.symbol = symbol; 
    }
    
    /**
     * 意外发现，toMap 替换 forLoop，代码更加优雅
     */
    private static final Map<String, Operation> stringToEnum = Stream.of(values())
        .collect(Collectors.toMap(
            v -> v.toString(),
            v -> v
        ));
    
    /**
     * fromString 是约定（最佳实践，非技术层面限制）
     */
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
    
    @Override
    public String toString() {
        return symbol;
    }
    
    public abstract double apply(double x, double y);
}


public class OperationDemo {
    public static void main(String[] args) {
        System.out.println(
            Operation.PLUS.apply(1.0, 2.0)
        );
    }
}